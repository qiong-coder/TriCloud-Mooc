package cn.edu.buaa.tricloud.mooc.Request;

import cn.edu.buaa.tricloud.mooc.domain.Course;
import org.hibernate.validator.constraints.NotEmpty;

import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;

/**
 * Created by qixiang on 8/19/17.
 */
public class CourseInsert {

    @NotNull
    private String name;

    @NotNull
    private String teacher_name;

    @NotNull

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public Course build(String description) {
        Course course = new Course();
        course.setName(getName());
        return course;
    }

}
