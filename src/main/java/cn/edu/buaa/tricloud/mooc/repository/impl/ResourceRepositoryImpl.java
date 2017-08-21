package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.domain.Resource;
import cn.edu.buaa.tricloud.mooc.repository.HibernateSessionFactory;
import cn.edu.buaa.tricloud.mooc.repository.ResourceRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qixiang on 8/20/17.
 */
@Repository("ResourceRepository")
@Transactional
public class ResourceRepositoryImpl extends HibernateSessionFactory implements ResourceRepository {

    public List<Resource> getByCourse(Integer cid) {
        return (List<Resource>) getCurrentSession().createCriteria(Resource.class).add(Restrictions.eq("cid",cid)).list();
    }

    public Resource getById(Integer rid) {
        return (Resource) getCurrentSession().get(Resource.class,rid);
    }

    public Integer insert(Resource resource) {
        return (Integer) getCurrentSession().save(resource);
    }

    public void update(Resource resource) {
        getCurrentSession().update(resource);
    }

    public void delete(Integer id) {
        getCurrentSession().delete("id",id);
    }
}
