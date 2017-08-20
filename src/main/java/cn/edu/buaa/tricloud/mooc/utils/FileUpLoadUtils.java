package cn.edu.buaa.tricloud.mooc.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Created by qixiang on 8/20/17.
 */
@Component("FileUpLoadUtils")
public class FileUpLoadUtils implements ServletContextAware {

    private String media_path;

    public void setServletContext(ServletContext servletContext) {
        media_path = servletContext.getRealPath("/WEB-INF/medias");
    }

    public String save(String prefix, Part file) {
        try {
            file.write(media_path + "/" + prefix + "/" + file.getSubmittedFileName());
        } catch (IOException ex) {
            return null;
        }
        return file.getSubmittedFileName();
    }

}
