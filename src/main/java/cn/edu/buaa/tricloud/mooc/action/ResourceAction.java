package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.Request.ResourceInsert;
import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.QueryParameterError;
import cn.edu.buaa.tricloud.mooc.service.ResourceService;
import cn.edu.buaa.tricloud.mooc.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import javax.validation.Valid;

/**
 * Created by qixiang on 8/20/17.
 */
@RestController
@RequestMapping("/course/resource")
public class ResourceAction {

    @Autowired
    ResourceService resourceService;

    @RequestMapping(value = "/{cid}/", method = RequestMethod.POST)
    public Response insert(@PathVariable("cid") Integer cid,
                           @RequestPart("attachment") Part attachment,
                           @Valid ResourceInsert resourceInsert,
                           BindingResult errors) {
        if ( errors.hasErrors() ) throw new QueryParameterError(BindingResultUtil.getMessage(errors));
        return ResponseBuilder.build(resourceService.insert(cid,resourceInsert,attachment));
    }

    @RequestMapping(value = "/{cid}/", method = RequestMethod.GET)
    public Response get(@PathVariable("cid") Integer cid) {
        return ResponseBuilder.build(resourceService.getByCourse(cid));
    }

    @RequestMapping(value = "/{cid}/{rid}/", method = RequestMethod.PUT)
    public Response update(@PathVariable("cid") Integer cid,
                           @PathVariable("rid") Integer rid,
                           @RequestPart("attachment") Part attachment,
                           @RequestParam("name") String name) {
        if ( name == null || attachment.getSize() == 0 ) throw new QueryParameterError("resource update parameters should has name or attachment");
        return ResponseBuilder.build(null);
    }

    @RequestMapping(value = "/{cid}/{rid}/", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("cid") Integer cid,
                           @PathVariable("rid") Integer rid) {
        resourceService.delete(cid,rid);
        return ResponseBuilder.build(null);
    }

}
