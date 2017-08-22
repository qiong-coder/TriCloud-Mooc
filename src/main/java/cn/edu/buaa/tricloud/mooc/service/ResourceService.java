package cn.edu.buaa.tricloud.mooc.service;

import cn.edu.buaa.tricloud.mooc.Request.ResourceInsert;
import cn.edu.buaa.tricloud.mooc.domain.Resource;

import javax.servlet.http.Part;
import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
public interface ResourceService {

    List<Resource> getByCourse(Integer cid);

    Integer insert(Integer cid, ResourceInsert resourceInsert, Part attachment);

    void update(Integer cid, Integer rid, String name, Part attachment);

    void delete(Integer cid, Integer rid);
}
