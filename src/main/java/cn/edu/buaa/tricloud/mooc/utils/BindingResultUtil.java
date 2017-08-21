package cn.edu.buaa.tricloud.mooc.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
public class BindingResultUtil {

    public static String getMessage(BindingResult bindingResult) {
        List<ObjectError> objectErrors = bindingResult.getAllErrors();

        StringBuilder stringBuilder = new StringBuilder();
        for ( ObjectError objectError : objectErrors ) {
            stringBuilder.append(objectError.toString());
        }

        return stringBuilder.toString();
    }

}
