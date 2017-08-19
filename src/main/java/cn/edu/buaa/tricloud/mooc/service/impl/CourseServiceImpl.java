package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.Request.CourseInsert;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.exception.CourseNotFound;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
import cn.edu.buaa.tricloud.mooc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qixiang on 8/19/17.
 */
@Component("CourseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

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

    public Integer insertCourse(CourseInsert courseInsert) {
        return courseRepository.insert(courseInsert.build());
    }

    public void updateCourse(Course course) {
    }

    public void deleteCourseById(Integer id) {
        courseRepository.delete(id);
    }
}
