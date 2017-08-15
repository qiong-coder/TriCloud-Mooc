package cn.edu.buaa.tricloud.mooc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by qixiang on 8/15/17.
 */
//@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "user not found")
public class UserNotFound extends RuntimeException {
}
