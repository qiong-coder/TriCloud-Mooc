package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import cn.edu.buaa.tricloud.mooc.exception.AccountRolesNonValidate;
import cn.edu.buaa.tricloud.mooc.exception.CourseNotFound;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
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
    AccountRepository accountRepository;

    @Autowired
    FileUpLoadUtils fileUpLoadUtils;

    public List<Course> listAllCourses() {
        List<Course> courses = courseRepository.list();
        if ( courses == null && courses.isEmpty() ) throw new CourseNotFound(String.format("failure to find the courses"));
        return courses;
    }

    public Course getCourseById(Integer id) {
        Course course = courseRepository.get(id);
        if ( course == null ) throw new CourseNotFound(String.format("failure to find the course by id:%d",id));
        return course;
    }

    public Integer insertCourse(String login_name, String name, Part description) {
        Account account = accountRepository.getAccountByLoginName(login_name);

        if ( account == null ) throw new AccountNotFound(String.format("failure to find the account by login name:%s",login_name));
        else if ( account.getRoles().compareTo(RolesConstant.TEACHER) != 0 ) throw new AccountRolesNonValidate(String.format("account has no right to create course - login name:%s",login_name));

        String save_name = fileUpLoadUtils.save(description);
        if ( save_name != null ) {
            Course course = new Course();
            course.setIdentity(login_name);
            course.setName(name);
            course.setDescription(save_name);
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
