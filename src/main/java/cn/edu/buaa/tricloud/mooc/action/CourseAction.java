package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.Request.CourseInsert;
import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.exception.QueryParameterError;
import cn.edu.buaa.tricloud.mooc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qixiang on 8/19/17.
 */

@RestController
@RequestMapping(value = "/course")
public class CourseAction {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/{login_name}/", method = RequestMethod.GET)
    public Response list(@PathVariable("login_name") String login_name) {
        return ResponseBuilder.build(courseService.listByLoginName(login_name));
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public Response get(@PathVariable("id") Integer id) {
        return ResponseBuilder.build(courseService.getCourseById(id));
    }

    @RequestMapping(value = "/{login_name}/", method = RequestMethod.POST)
    public Response insert(@RequestPart("attachment") Part attacchment,
                           @RequestParam("name") @NotNull String name,
                           @PathVariable("login_name") @Size(min=6,max=20) String login_name)

    {
        if ( attacchment.getSize() == 0 ) throw new QueryParameterError("failure to insert the course because of no course's description");
        return ResponseBuilder.build(courseService.insertCourse(login_name,name,attacchment));
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.PUT)
    public Response update(@PathVariable("id") Integer id,
                           Course course)
    {
        course.setId(id);
        courseService.updateCourse(course);
        return ResponseBuilder.build(null);
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") Integer id) {
        courseService.deleteCourseById(id);
        return ResponseBuilder.build(null);
    }

}
