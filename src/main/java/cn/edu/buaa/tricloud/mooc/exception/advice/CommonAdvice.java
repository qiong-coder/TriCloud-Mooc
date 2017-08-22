package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;
import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.exception.ActionNotSupport;
import cn.edu.buaa.tricloud.mooc.exception.AttachmentUploadError;
import cn.edu.buaa.tricloud.mooc.exception.QueryParameterError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * Created by qixiang on 8/19/17.
 */
@RestControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(QueryParameterError.class)
    //@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ResponseCodeMessage.QUERY_PARAMETERS_ERROR_MESSAGE)
    public Response queryParametersException(QueryParameterError queryParameterError) {
        return ResponseBuilder.build(0,queryParameterError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    //@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = ResponseCodeMessage.QUERY_PARAMETERS_ERROR_MESSAGE)
    public Response queryParametersException2(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations ) {
            strBuilder.append(violation.getMessage() + "\n");
        }
        return ResponseBuilder.build(ResponseCodeMessage.QUERY_PARAMETERS_ERROR_CODE, strBuilder.toString());
    }

    @ExceptionHandler(AttachmentUploadError.class)
    public Response noHandlerFoundException(AttachmentUploadError e) {
        return ResponseBuilder.build(0,e);
    }

    @ExceptionHandler(ActionNotSupport.class)
    public Response actionNotSuppoted(ActionNotSupport actionNotSupport) {
        return ResponseBuilder.build(0, actionNotSupport);
    }
}
