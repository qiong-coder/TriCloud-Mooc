package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.MachineOperatorError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by stupid-coder on 8/22/17.
 */
@RestControllerAdvice
public class MachineAdvice {

    @ExceptionHandler(MachineOperatorError.class)
    public Response operatorError(MachineOperatorError machineOperatorError)
    {
        return ResponseBuilder.build(0, machineOperatorError);
    }

}
