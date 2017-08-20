package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.Request.CourseInsert;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.exception.CourseNotFound;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
import cn.edu.buaa.tricloud.mooc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by qixiang on 8/19/17.
 */
@Component("CourseService")
public class CourseServiceImpl implements CourseService {

    private static String medias_path = System.getProperty("catalina.base")
            + "/tricloud-mooc/TriCloud-Mooc/WEB-INF/medias";

    static {
        File dir = new File(medias_path);
        if ( !dir.exists() ) dir.mkdirs();
    }

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

    public Integer insertCourse(CourseInsert courseInsert, Part description) {
        String description_path = medias_path + "/" + description.getSubmittedFileName();
        try {
            description.write(description_path);
        } catch (IOException e) {
            return 0;
        }
        return courseRepository.insert(courseInsert.build(description.getSubmittedFileName()));
    }

    public void updateCourse(Course course) {
    }

    public void deleteCourseById(Integer id) {
        courseRepository.delete(id);
    }
}
