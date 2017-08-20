package cn.edu.buaa.tricloud.mooc.config;


import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Created by qixiang on 8/14/17.
 */

@Configuration
@ComponentScan(basePackages = {"cn.edu.buaa.tricloud.mooc.service.impl", "cn.edu.buaa.tricloud.mooc.repository", "cn.edu.buaa.tricloud.mooc.utils"},
        excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value= EnableWebMvc.class) ,
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ControllerAdvice.class)})
public class RootConfig {}
