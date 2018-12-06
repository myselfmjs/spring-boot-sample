/**
 * 
 */
package spring.boot.sample.sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.boot.sample.common.controller.BaseController;
import spring.boot.sample.sample.entity.User;
import spring.boot.sample.sample.service.UserService;

import java.util.List;

/**
 * 用户表Controller
 * @author majunsheng
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(Model model) {
        return "sample/userList";
    }



    @RequestMapping(value = {"", "form"}, method = RequestMethod.GET)
    public String form(Model model) {
        List<User> list = userService.findAll();
        User user = new User();
        if (list !=null && list.size()>0){
            user = list.get(0);
        }
        model.addAttribute("user",user);
        return "sample/userForm";
    }

    @RequestMapping(value="json",method = RequestMethod.GET)
    public String json(Model model){
        return "Success";
    }
}