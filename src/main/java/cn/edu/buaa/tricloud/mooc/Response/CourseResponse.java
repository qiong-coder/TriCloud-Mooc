package cn.edu.buaa.tricloud.mooc.Response;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.domain.Course;

import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
public class CourseResponse {

    private AccountResponse account;

    private List<Course> courses;

    public static CourseResponse build(AccountResponse accountResponse, List<Course> courses) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setAccount(accountResponse);
        courseResponse.setCourses(courses);
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
}
