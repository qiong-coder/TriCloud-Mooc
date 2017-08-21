package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.service.CourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qixiang on 8/21/17.
 */

@RestController
@RequestMapping("/course/order")
public class CourseOrderAction {

    @Autowired
    CourseOrderService courseOrderService;

    @RequestMapping(value = "/{login_name}/{cid}/", method = RequestMethod.POST)
    public Response insertOrderCourse(@PathVariable("login_name") String login_name,
                                      @PathVariable("cid") Integer cid)
    {
        return ResponseBuilder.build(courseOrderService.insertOrderCourse(login_name,cid));
    }

    @RequestMapping(value = "/{login_name}/", method = RequestMethod.GET)
    public Response getOrderCourses(@PathVariable("login_name") String login_name)
    {
        return ResponseBuilder.build(courseOrderService.listOrdersByLoginName(login_name));
    }

    @RequestMapping(value = "/{oid}/", method = RequestMethod.PUT)
    public Response updateOrderCourse(@PathVariable("oid") Integer oid)
    {
        return null;
    }

    @RequestMapping(value = "/{oid}/", method = RequestMethod.DELETE)
    public Response deleteOrderCourse(@PathVariable("oid") Integer oid)
    {
        courseOrderService.delete(oid);
        return ResponseBuilder.build(null);
    }

    @RequestMapping(value = "/machine/{oid}/{type}", method = RequestMethod.PUT)
    public Response updateOrderCourseMachine(@PathVariable("oid") Integer oid,
                                             @PathVariable("type") Integer type)
    {
        return null;
    }

    @RequestMapping(value = "/number/{cid}/", method = RequestMethod.GET)
    public Response getOrderNumberByCourseId(@PathVariable("cid") Integer cid)
    {
        return ResponseBuilder.build(courseOrderService.listOrderNumberByCourseId(cid));
    }

}
