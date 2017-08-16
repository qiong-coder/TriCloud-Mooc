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

    private static String SelectUsers = "from User";

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<User> selectUsers() {
        return currentSession().createQuery(SelectUsers).getResultList();

    }

    public User selectByUserName(String username) {
        currentSession().createQuery()
        if ( users.containsKey(username) ) return new User(username,users.get(username));
        else throw new UserNotFound();
    }

    public int insertUser(User user) {
        if ( users.containsKey(user.getUsername()) ) throw new UserDuplicate();
        users.put(user.getUsername(),user.getPassword()); return 1;
    }
}
