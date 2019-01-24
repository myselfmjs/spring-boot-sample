package spring.boot.sample.api.taobao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: majunsheng
 * @Date: 2018/12/19
 **/
@Controller
@RequestMapping("taobaoApi")
public class TaoboApi {

    @RequestMapping(value = "search",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String search(){

        return null;
    }
}
