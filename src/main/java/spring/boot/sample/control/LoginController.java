package spring.boot.sample.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.sample.api.HttpUtils;
import spring.boot.sample.common.listener.MyHttpSessionListener;

/**
 * @Author: majunsheng
 * @Date: 2018/11/20
 **/
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value = "json",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String hello() throws Exception {
        return "Hello Spring-Boot 哈哈哈 中文乱码吗";
    }

    @RequestMapping(value = "init",method = RequestMethod.GET)
    public String init(){
        String str = "2131332";
        return "success";
    }

    @RequestMapping(value = "online",method = RequestMethod.GET)
    public String online(Model model){
        int online = MyHttpSessionListener.online;
        model.addAttribute("online",online);
        return "success";
    }
}
