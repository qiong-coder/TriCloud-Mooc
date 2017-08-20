package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.Request.ResourceInsert;
import cn.edu.buaa.tricloud.mooc.Response.Response;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by qixiang on 8/20/17.
 */
@RestController
@RequestMapping("/course/resource")
public class ResourceAction {

    @RequestMapping(value = "/{cid}/", method = RequestMethod.POST)
    public Response insert(@PathVariable("cid") Integer cid,
                           @RequestPart("attachment") Part attachment,
                           @Valid ResourceInsert resourceInsert,
                           BindingResult errors) {

        return null;
    }

    @RequestMapping(value = "/{cid}/", method = RequestMethod.GET)
    public Response get(@PathVariable("cid") Integer cid) {

        return null;
    }

    @RequestMapping(value = "/{cid}/{rid}/", method = RequestMethod.PUT)
    public Response update(@PathVariable("cid") Integer cid,
                           @PathVariable("rid") Integer rid) {
        return null;
    }

    @RequestMapping(value = "/{cid}/{rid}/", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("cid") Integer cid,
                           @PathVariable("rid") Integer rid) {
        return null;
    }

}
