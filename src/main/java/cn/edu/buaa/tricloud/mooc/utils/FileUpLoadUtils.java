package cn.edu.buaa.tricloud.mooc.utils;

import cn.edu.buaa.tricloud.mooc.exception.AttachmentUploadError;
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
        media_path = servletContext.getRealPath("/")+"../medias";
    }

    public void mkdir(String login_name) {
        File file = new File(media_path+"/"+login_name);
        if ( !file.exists() ) file.mkdirs();
    }

    public void mkdir(String login_name, Integer cid) {
        File file = new File(media_path+"/"+login_name+"/"+cid);
        if ( !file.exists() ) file.mkdirs();
    }

    public String save(String login_name, Integer cid, Part file) {
        String uri = "/" + login_name + "/" + cid.toString() + "/" + file.getSubmittedFileName();
        try {
            file.write(media_path+uri);
        } catch (IOException ex) {
            throw new AttachmentUploadError(ex.getLocalizedMessage());
        }
        return uri;

    }

    public String save(String prefix, Part file) {
        String uri = "/" + prefix + "/" + file.getSubmittedFileName();
        try {
            file.write(media_path + uri);
        } catch (IOException ex) {
            throw new AttachmentUploadError(ex.getLocalizedMessage());
        }
        return uri;
    }

}
