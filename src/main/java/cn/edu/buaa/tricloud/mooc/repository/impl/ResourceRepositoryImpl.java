package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.domain.Resource;
import cn.edu.buaa.tricloud.mooc.repository.HibernateSessionFactory;
import cn.edu.buaa.tricloud.mooc.repository.ResourceRepository;

import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
public class ResourceRepositoryImpl extends HibernateSessionFactory implements ResourceRepository {

    public List<Resource> getByCourse(Integer cid) {
        //getCurrentSession().createCriteria(Resource.class).add(Re)
        return null;
    }
}
