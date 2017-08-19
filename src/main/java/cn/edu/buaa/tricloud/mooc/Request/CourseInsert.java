package cn.edu.buaa.tricloud.mooc.Request;

import cn.edu.buaa.tricloud.mooc.domain.Course;

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
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course build() {
        Course course = new Course();
        course.setName(getName());
        course.setTeacher_name(getTeacher_name());
        return course;
    }

}
