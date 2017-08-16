package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.domain.User;
import cn.edu.buaa.tricloud.mooc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by qixiang on 8/14/17.
 */

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String selectUsers(Model model) {
        List<User> userList = userRepository.selectUsers();
        model.addAttribute(userList);
        return "users";
    }

    @RequestMapping(value = "/{username}/", method = RequestMethod.GET)
    public String selectByName(@PathVariable String username,
                               Model model) {
        User user = userRepository.selectByUserName(username);
        model.addAttribute(user);
        return "user";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String getRegisterForm(Model model)
    {
        model.addAttribute(new User());
        return "registerForm";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public String insertUser(@Valid User user, BindingResult errors)
    {
        System.out.format("User - username:%s, password:%s\n",user.getUsername(),user.getPassword());
        if ( errors.hasErrors() ) return "registerForm";
        userRepository.insertUser(user);
        return "redirect:/user/"+user.getUsername()+"/";
    }

}
