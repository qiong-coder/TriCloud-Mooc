package cn.edu.buaa.tricloud.mooc.action;


import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;
import cn.edu.buaa.tricloud.mooc.exception.ActionNotFound;
import cn.edu.buaa.tricloud.mooc.exception.ActionNotSupport;
import cn.edu.buaa.tricloud.mooc.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stupid-coder on 8/22/17.
 */
@RestController
@RequestMapping(value = "/machine")
public class MachineAction {


    @Autowired
    MachineService machineService;

    @RequestMapping(value = "/{action}/{oid}/", method = RequestMethod.GET)
    public Response acton(@PathVariable("action") String action,
                          @PathVariable("oid") Integer oid) {
        if ( action.compareTo("create") == 0 )
            throw new ActionNotSupport("failure to support the create - create operator just called with course order created");
        else if ( action.compareTo("start") == 0 ) {
            machineService.start(oid);
            return ResponseBuilder.build(null);
        }
        else if ( action.compareTo("stop") == 0 ) {
            machineService.start(oid);
            return ResponseBuilder.build(null);
        }
        else if ( action.compareTo("migrate") == 0 ) {
            machineService.migrate(oid);
            return ResponseBuilder.build(null);
        } else throw new ActionNotFound(String.format("failure to supported the action:%s",action));
    }

}
