package cn.edu.buaa.tricloud.mooc.repository;

import cn.edu.buaa.tricloud.mooc.domain.Course;
import java.util.List;

/**
 * Created by qixiang on 8/19/17.
 */
public interface CourseRepository {

    List<Course> list();

    Course get(Integer id);

    Integer insert(Course course);

    void update(Course course);

    void delete(Integer id);

}
