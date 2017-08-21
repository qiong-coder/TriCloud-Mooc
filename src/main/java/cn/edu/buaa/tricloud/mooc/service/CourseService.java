package cn.edu.buaa.tricloud.mooc.service;

import cn.edu.buaa.tricloud.mooc.Request.CourseInsert;
import cn.edu.buaa.tricloud.mooc.Response.CourseResponse;
import cn.edu.buaa.tricloud.mooc.domain.Course;

import javax.servlet.http.Part;
import java.util.List;

/**
 * Created by qixiang on 8/19/17.
 */
public interface CourseService {

    CourseResponse listByLoginName(String login_name);

    List<Course> listCourseBySchoolId(Integer id);

    Course getCourseById(Integer id);

    CourseResponse getCourseResponseById(Integer id);

    Integer insertCourse(String login_name, String name, Part attachment);

    void updateCourse(Integer id, String name, Part attachment);

    void deleteCourseById(Integer id);

}
