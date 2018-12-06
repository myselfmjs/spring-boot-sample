package test;

import spring.boot.sample.api.HttpUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: majunsheng
 * @Date: 2018/12/4
 **/
public class RestUtil {

    public String load(String url,String query) throws Exception {

            url = url + "?w=" + query;

        URL restURL = new URL(url);
        /*
         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
         */
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        //请求方式
        conn.setRequestMethod("GET");
        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
        conn.setDoOutput(true);
        //设置请求的头信息
        conn.setRequestProperty("Content-type","application/json");
        conn.setRequestProperty("referer","https://y.qq.com/portal/search.html");
        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
        conn.setAllowUserInteraction(false);

        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line,resultStr="";

        while(null != (line=bReader.readLine()))
        {
            resultStr +=line;
        }
        System.out.println("3412412---"+resultStr);
        bReader.close();

        return resultStr;

    }

    public static void main(String []args) {try {

        RestUtil restUtil = new RestUtil();

        String resultString = restUtil.load(
                "http://c.y.qq.com/soso/fcgi-bin/client_search_cp",
                "w=夜之光");
        System.out.println(resultString);
    } catch (Exception e) {

        // TODO: handle exception

        System.out.print(e.getMessage());

    }

    }
}
