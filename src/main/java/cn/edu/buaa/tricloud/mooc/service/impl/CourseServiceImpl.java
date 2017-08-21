package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.Response.AccountResponse;
import cn.edu.buaa.tricloud.mooc.Response.CourseResponse;
import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.domain.Resource;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import cn.edu.buaa.tricloud.mooc.exception.AccountRolesNonValidate;
import cn.edu.buaa.tricloud.mooc.exception.CourseNotFound;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
import cn.edu.buaa.tricloud.mooc.repository.ResourceRepository;
import cn.edu.buaa.tricloud.mooc.service.AccountService;
import cn.edu.buaa.tricloud.mooc.service.CourseService;
import cn.edu.buaa.tricloud.mooc.utils.FileUpLoadUtils;
import cn.edu.buaa.tricloud.mooc.utils.RolesConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixiang on 8/19/17.
 */
@Component("CourseService")
public class CourseServiceImpl implements CourseService {


    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    FileUpLoadUtils fileUpLoadUtils;

    public CourseResponse listByLoginName(String login_name) {

        AccountResponse accountResponse = accountService.getAccountResponseByLoginName(login_name);

        List<Course> courses = courseRepository.listByLoginName(login_name);

        return CourseResponse.build(accountResponse,courses);
    }

    public List<Course> listCourseBySchoolId(Integer id) {
        List<Course> retCourses = new ArrayList<Course>();

        List<Account> accounts = accountService.getAccounts();
        for ( Account account : accounts ) {
            if ( account.getSchool().compareTo(id) != 0 ) continue;
            List<Course> courses = courseRepository.listByLoginName(account.getLogin_name());
            if ( courses == null || courses.isEmpty() ) continue;
            retCourses.addAll(courses);
        }

        return retCourses;
    }

    public Course getCourseById(Integer id) {
        Course course = courseRepository.get(id);
        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%d",id));
        return course;
    }


    public CourseResponse getCourseResponseById(Integer id) {
        Course course = courseRepository.get(id);
        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%d",id));

        AccountResponse accountResponse = accountService.getAccountResponseByLoginName(course.getLogin_name());

        List<Resource> resources = resourceRepository.getByCourse(id);

        return CourseResponse.build(accountResponse,course,resources);
    }

    public Integer insertCourse(String login_name, String name, Part attachment) {
        Account account = accountService.getAccountByLoginName(login_name);

        if ( account.getRoles().compareTo(RolesConstant.TEACHER) != 0 &&
                account.getRoles().compareTo(RolesConstant.ADMIN) != 0) throw new AccountRolesNonValidate(String.format("account has no right to create course - login name:%s",login_name));

        Course course = new Course();
        course.setLogin_name(login_name);
        course.setName(name);
        course.setAttachment("");
        Integer cid = courseRepository.insert(course);

        course = getCourseById(cid);
        fileUpLoadUtils.mkdir(login_name,cid);
        String attachment_name = fileUpLoadUtils.save(login_name, cid, attachment);
        course.setAttachment(attachment_name);
        courseRepository.update(course);

        return cid;
    }

    public void updateCourse(Integer id, String name, Part attachment) {
        Course course = courseRepository.get(id);

        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%s",id));

        if ( name != null )
            course.setName(name);

        if ( attachment.getSize() != 0 ) {
            course.setAttachment(fileUpLoadUtils.save(course.getLogin_name(), attachment));
        }

        courseRepository.update(course);
    }

    public void deleteCourseById(Integer id) {
        courseRepository.delete(id);
    }
}
