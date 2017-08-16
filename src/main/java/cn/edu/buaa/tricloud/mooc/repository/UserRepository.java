package cn.edu.buaa.tricloud.mooc.repository;

import cn.edu.buaa.tricloud.mooc.domain.User;

import java.util.List;

/**
 * Created by qixiang on 8/15/17.
 */
public interface UserRepository {

    List<User> selectUsers();

    User selectByUserName(String username);

    int insertUser(User user);

}
