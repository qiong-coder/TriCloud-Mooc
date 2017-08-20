package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import cn.edu.buaa.tricloud.mooc.exception.AccountRolesNonValidate;
import cn.edu.buaa.tricloud.mooc.exception.CourseNotFound;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
import cn.edu.buaa.tricloud.mooc.service.AccountService;
import cn.edu.buaa.tricloud.mooc.service.CourseService;
import cn.edu.buaa.tricloud.mooc.utils.FileUpLoadUtils;
import cn.edu.buaa.tricloud.mooc.utils.RolesConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
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
    FileUpLoadUtils fileUpLoadUtils;

    public List<Course> listByLoginName(String login_name) {
        Account account = accountService.getAccountByLoginName(login_name);

        List<Course> courses = courseRepository.listByLoginName(login_name);
        if ( courses == null && courses.isEmpty() ) throw new CourseNotFound(String.format("failure to find the courses with login_name:%s",login_name));
        return courses;
    }

    public Course getCourseById(Integer id) {
        Course course = courseRepository.get(id);
        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%d",id));
        return course;
    }

    public Integer insertCourse(String login_name, String name, Part attachment) {
        Account account = accountService.getAccountByLoginName(login_name);

        if ( account.getRoles().compareTo(RolesConstant.TEACHER) != 0 ) throw new AccountRolesNonValidate(String.format("account has no right to create course - login name:%s",login_name));

        String save_name = fileUpLoadUtils.save(login_name, attachment);
        if ( save_name != null ) {
            Course course = new Course();
            course.setLogin_name(login_name);
            course.setName(name);
            course.setAttachment(save_name);
            return courseRepository.insert(course);
        }
        else return 0;
    }

    public void updateCourse(Course course) {
        Course course1 = getCourseById(course.getId());

        course1.merge(course);

        courseRepository.update(course1);
    }

    public void deleteCourseById(Integer id) {
        courseRepository.delete(id);
    }
}
