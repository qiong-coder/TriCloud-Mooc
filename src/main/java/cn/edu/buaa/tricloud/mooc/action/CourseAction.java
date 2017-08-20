package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.Request.CourseInsert;
import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.QueryParameterError;
import cn.edu.buaa.tricloud.mooc.service.CourseService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import javax.validation.Valid;

/**
 * Created by qixiang on 8/19/17.
 */

@Controller
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

    @RequestMapping(value  = "/upload_test/", method = RequestMethod.GET)
    public String update_test(Model model) {
        model.addAttribute(new CourseInsert());
        return "upload_test";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Response insert(@RequestPart("description") Part description,
                           @Valid CourseInsert courseInsert,
                           BindingResult errors)
    {
        if ( errors.hasErrors() ) throw new QueryParameterError(errors.toString());
        if ( description.getSize() == 0 ) throw new QueryParameterError("failure to insert the course because of no course's description");
        return ResponseBuilder.build(courseService.insertCourse(courseInsert,description));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Response update() {
        return null;
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") Integer id) {
        courseService.deleteCourseById(id);
        return ResponseBuilder.build(null);
    }

}
