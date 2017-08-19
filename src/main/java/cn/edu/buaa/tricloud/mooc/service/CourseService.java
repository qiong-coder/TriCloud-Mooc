package cn.edu.buaa.tricloud.mooc.service;

import cn.edu.buaa.tricloud.mooc.Request.CourseInsert;
import cn.edu.buaa.tricloud.mooc.domain.Course;

import java.util.List;

/**
 * Created by qixiang on 8/19/17.
 */
public interface CourseService {

    List<Course> listAllCourses();

    Course getCourseById(Integer id);

    Integer insertCourse(CourseInsert course);

    void updateCourse(Course course);

    void deleteCourseById(Integer id);

}