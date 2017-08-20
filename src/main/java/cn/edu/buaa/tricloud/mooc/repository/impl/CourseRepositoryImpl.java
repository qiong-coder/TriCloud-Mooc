package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.domain.Course;
import cn.edu.buaa.tricloud.mooc.repository.CourseRepository;
import cn.edu.buaa.tricloud.mooc.repository.HibernateSessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qixiang on 8/19/17.
 */
@Repository("CourseRepository")
@Transactional
public class CourseRepositoryImpl extends HibernateSessionFactory implements CourseRepository {

    public List<Course> listByLoginName(String login_name) {
        return (List<Course>) getCurrentSession().createCriteria(Course.class)
                .add(Restrictions.eq("login_name",login_name)).list();
    }

    public Course get(Integer id) {
        return (Course) getCurrentSession().get(Course.class,id);
    }

    public Integer insert(Course course) {
        return (Integer) getCurrentSession().save(course);
    }

    public void update(Course course) {
        getCurrentSession().update(course);
    }

    public void delete(Integer id) {
        getCurrentSession().delete("id", id);
    }
}
