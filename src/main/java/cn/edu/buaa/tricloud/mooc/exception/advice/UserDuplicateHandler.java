package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.exception.UserDuplicate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qixiang on 8/15/17.
 */
@ControllerAdvice
public class UserDuplicateHandler {

    @ExceptionHandler(UserDuplicate.class)
    @ResponseBody
    public String userDuplicate() {
        return "error/duplicate";
    }


}
