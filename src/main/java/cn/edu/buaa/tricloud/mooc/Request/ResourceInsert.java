package cn.edu.buaa.tricloud.mooc.Request;

import cn.edu.buaa.tricloud.mooc.domain.Resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qixiang on 8/20/17.
 */
public class ResourceInsert {

    @NotNull
    private String name;

    @NotNull
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Resource build(Integer cid, String attachment) {
        Resource resource = new Resource();
        resource.setName(name);
        resource.setCid(cid);
        resource.setType(type);
        resource.setAttachment(attachment);
        return resource;
    }
}
