package cn.edu.buaa.tricloud.mooc.repository;

import cn.edu.buaa.tricloud.mooc.domain.Resource;

import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
public interface ResourceRepository {

    List<Resource> getByCourse(Integer cid);

    Resource getById(Integer rid);

    Integer insert(Resource resource);

    void update(Resource resource);

    void deleteByCourseId(Integer id);

    void delete(Integer id);

    void delete(Resource resource);
}
