package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.exception.UserDuplicate;
import cn.edu.buaa.tricloud.mooc.exception.UserNotFound;
import cn.edu.buaa.tricloud.mooc.model.User;
import cn.edu.buaa.tricloud.mooc.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qixiang on 8/15/17.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    private Map<String,String> users;

    public UserRepositoryImpl() {
        users = new HashMap<String, String>();
        users.put("root","admin");
    }

    public List<User> selectUsers() {
        List<User> userList = new ArrayList<User>();
        for ( Map.Entry<String,String> entry : users.entrySet() ) {
            userList.add(new User(entry.getKey(),entry.getValue()));
        }
        return userList;
    }

    public User selectByUserName(String username) {
        if ( users.containsKey(username) ) return new User(username,users.get(username));
        else throw new UserNotFound();
    }

    public int insertUser(User user) {
        if ( users.containsKey(user.getUsername()) ) throw new UserDuplicate();
        users.put(user.getUsername(),user.getPassword()); return 1;
    }
}
