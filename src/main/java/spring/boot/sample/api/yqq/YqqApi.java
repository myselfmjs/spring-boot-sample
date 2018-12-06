package spring.boot.sample.api.yqq;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.sample.api.HttpUtils;

import java.net.URLEncoder;

/**
 * @Author: majunsheng
 * @Date: 2018/12/4
 * 访问qq音乐接口
 **/
@Controller
@RequestMapping("yqqApi")
public class YqqApi {

    /**
     * QQ音乐搜索
     * @param keyword  搜索词
     * @param callbackcount 每页显示数
     * @param pageindex 第几页
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String search(String keyword,String callbackcount,String pageindex){
        String url = "http://c.y.qq.com/soso/fcgi-bin/client_search_cp";
        String referer = "https://y.qq.com/portal/search.html";
        String result = "";
        String param = "ct=24&qqmusic_ver=1298&remoteplace=txt.yqq.center&t=0&aggr=1&cr=1&catZhida=1&platform=yqq&g_tk=5381&format=json";
        if (StringUtils.isBlank(callbackcount)){
            callbackcount = "20";
        }
        if (StringUtils.isBlank(pageindex)){
            pageindex = "1";
        }
        try {
             param += "&w=" + URLEncoder.encode(keyword,"utf-8") +"&n=" + callbackcount +"&p=" +pageindex;

            result = HttpUtils.sendGet(url,referer,param);
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取key的值
     * @param songmid
     * @return
     */
    @RequestMapping(value = "getKey",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getKey(String songmid){
        String url = "http://u.y.qq.com/cgi-bin/musicu.fcg";
        String referer = "https://y.qq.com/portal/player.html";
        String param = "data={\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"5857471480\",\"songmid\":[\""+ songmid + "\"],\"songtype\":[0],\"uin\":\"0\",\"loginflag\":1,\"platform\":\"20\"}},\"comm\":{\"uin\":0,\"format\":\"json\",\"ct\":20,\"cv\":0}}";
        String result = "";
        try {
            result =  HttpUtils.sendGet(url,referer,param);
            result = StringEscapeUtils.unescapeHtml4(result);
            int index = result.indexOf("\"purl");
            int end = result.indexOf(",\"qmdlfromtag");
            result = "{"+ result.substring(index,end) + "}";
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }
}
