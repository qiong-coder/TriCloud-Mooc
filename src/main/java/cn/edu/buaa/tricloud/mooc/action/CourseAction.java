package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.Request.CourseInsert;
import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by qixiang on 8/19/17.
 */

@RestController
@RequestMapping(value = "/course")
public class CourseAction {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response list() {
        return ResponseBuilder.build(courseService.listAllCourses());
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public Response get(@PathVariable("id") Integer id) {
        return ResponseBuilder.build(courseService.getCourseById(id));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Response insert(@Valid CourseInsert courseInsert) {
        return ResponseBuilder.build(courseService.insertCourse(courseInsert));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Response update() {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Response delete() {
        return null;
    }

}
