package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.domain.CourseOrder;
import cn.edu.buaa.tricloud.mooc.repository.HibernateSessionFactory;
import cn.edu.buaa.tricloud.mooc.repository.CourseOrderRepository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qixiang on 8/21/17.
 */
@Repository("OrderRepository")
@Transactional
public class CourseOrderRepositoryImpl extends HibernateSessionFactory implements CourseOrderRepository {

    public List<CourseOrder> listOrdersByCourseId(Integer cid) {
        return (List<CourseOrder>)getCurrentSession().createCriteria(CourseOrder.class)
                .add(Restrictions.eq("cid",cid)).list();
    }

    public List<CourseOrder> listOrdersByLoginName(String login_name) {
        return (List<CourseOrder>)getCurrentSession().createCriteria(CourseOrder.class)
                .add(Restrictions.eq("login_name",login_name)).list();
    }

    public Map<Integer, Long> listNumbersByCourseId(Integer cid) {
        Map<Integer,Long> result = new HashMap<Integer, Long>();
        List<Object[]> numbers = getCurrentSession().createCriteria(CourseOrder.class)
                .add(Restrictions.eq("cid",cid))
                .setProjection(Projections.projectionList()
                .add(Projections.groupProperty("school"))
                .add(Projections.rowCount())).list();
        for ( Object[] obj : numbers ) {
            result.put((Integer) obj[0],(Long)obj[1]);
        }
        return result;
    }

    public CourseOrder get(Integer id) {
        return (CourseOrder)getCurrentSession().get(CourseOrder.class,id);
    }

    public Integer insert(CourseOrder courseOrder) {
        return (Integer) getCurrentSession().save(courseOrder);
    }

    public void update(CourseOrder courseOrder) {
        getCurrentSession().update(courseOrder);
    }

    public void delete(Integer id) {
        getCurrentSession().delete("id", id);
    }
}
