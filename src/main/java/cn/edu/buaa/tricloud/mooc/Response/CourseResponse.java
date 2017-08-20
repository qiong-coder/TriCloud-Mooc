package cn.edu.buaa.tricloud.mooc.Response;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponse {

    private AccountResponse account;

    private Course course;

    private List<Course> courses;

    public static CourseResponse build(AccountResponse accountResponse, List<Course> courses) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setAccount(accountResponse);
        if ( courses != null ) courseResponse.setCourses(courses);
        courseResponse.setCourses(new ArrayList<Course>());
        return courseResponse;
    }

    public static CourseResponse build(AccountResponse accountResponse, Course course) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setAccount(accountResponse);
        if ( course != null ) courseResponse.setCourse(course);
        courseResponse.setCourses(new ArrayList<Course>());
        return courseResponse;
    }

    public AccountResponse getAccount() {
        return account;
    }

    public void setAccount(AccountResponse account) {
        this.account = account;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
