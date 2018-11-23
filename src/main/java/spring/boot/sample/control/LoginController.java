package spring.boot.sample.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: majunsheng
 * @Date: 2018/11/20
 **/
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value = "json",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String hello() {
        return "Hello Spring-Boot";
    }

    @RequestMapping(value = "init",method = RequestMethod.GET)
    public String init(){
        String str = "2131332";
        return "success";
    }
}
