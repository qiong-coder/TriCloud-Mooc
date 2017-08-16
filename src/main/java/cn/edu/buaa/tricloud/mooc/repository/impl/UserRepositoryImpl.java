package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.exception.UserDuplicate;
import cn.edu.buaa.tricloud.mooc.exception.UserNotFound;
import cn.edu.buaa.tricloud.mooc.domain.User;
import cn.edu.buaa.tricloud.mooc.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qixiang on 8/15/17.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    private static final String SelectUsers = "FROM User";

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<User> selectUsers() {
        return currentSession().createQuery(SelectUsers).list();
    }

    public User selectByUserName(String username) {
        User user = currentSession().byNaturalId(User.class).using("username", username).load();
        if ( user != null ) return user;
        else throw new UserNotFound();
    }

    public int insertUser(User user) {
        User iuser = currentSession().byNaturalId(User.class).using("username", user.getUsername()).load();
        if ( iuser != null ) throw new UserDuplicate();
        currentSession().save(user);
        return 1;
    }
}
