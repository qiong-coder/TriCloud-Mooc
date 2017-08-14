package cn.edu.buaa.tricloud.mooc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by qixiang on 8/14/17.
 */

@Configuration
@ComponentScan(basePackages = {"cn.edu.buaa.tricloud.mooc.service"},excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, value= EnableWebMvc.class))
public class RootConfig {
}
