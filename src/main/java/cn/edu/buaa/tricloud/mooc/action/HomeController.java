package cn.edu.buaa.tricloud.mooc.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qixiang on 8/14/17.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String showRegistrationForm(Model model) {
//        model.addAttribute(new Account());
//        return "registerForm";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String processRegistration(@Valid  Account user,
//                                      Errors errors) {
//        if ( errors.hasErrors() ) return "registerForm";
//        else return "success";
//    }
}
