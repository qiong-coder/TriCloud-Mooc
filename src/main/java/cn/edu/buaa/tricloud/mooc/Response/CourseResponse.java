package cn.edu.buaa.tricloud.mooc.Response;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.domain.Resource;
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

    private List<Resource> resources;

    public static CourseResponse build(AccountResponse accountResponse, List<Course> courses) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setAccount(accountResponse);
        if ( courses != null ) courseResponse.setCourses(courses);
        else courseResponse.setCourses(new ArrayList<Course>());
        return courseResponse;
    }

    public static CourseResponse build(AccountResponse accountResponse, Course course, List<Resource> resources) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setAccount(accountResponse);
        courseResponse.setCourse(course);
        courseResponse.setResources(resources);
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
