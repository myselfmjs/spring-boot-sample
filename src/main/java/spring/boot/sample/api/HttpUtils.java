package spring.boot.sample.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: majunsheng
 * @Date: 2018/12/4
 **/
public class HttpUtils {

    /**
     * 向指定URL发送GET方法的请求
     */
    public static String sendGet(String url,String referer,String param) throws Exception {
        String result = "";
        BufferedReader bReader = null;

        try {
            String urlName = url + "?" + param;
            URL restURL = new URL(urlName);
            /*
             * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
             */
            HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
            //请求方式
            conn.setRequestMethod("GET");
            // 设置是否向HttpURLConnection输出
            conn.setDoOutput(false);
            // 设置是否从httpUrlConnection读入
            conn.setDoInput(true);
            //设置请求的头信息
//             conn.setRequestProperty("Accept-Encoding","gzip");
//            conn.setRequestProperty("accept-language","zh-CN,zh;q=0.9");
//            conn.setRequestProperty("authority","c.y.qq.com");
//            conn.setRequestProperty("vary","Accept-Encoding");
            conn.setRequestProperty("Content-type","application/json;charset=utf-8");
            conn.setRequestProperty("referer",referer);
            //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
            conn.setAllowUserInteraction(false);
            // 连接
            conn.connect();
            int code = conn.getResponseCode();
            if (code == 200) {
                bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line;

                while (null != (line = bReader.readLine())) {
                    result += line;
                }
            }
            //断开连接，释放资源
            conn.disconnect();

        } catch (Exception e) {
            throw new Exception(e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (bReader != null) {
                    bReader.close();
                }
            } catch (Exception e2) {
                throw new Exception(e2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {

            String resultString = HttpUtils.sendGet(
                    "http://c.y.qq.com/soso/fcgi-bin/client_search_cp",
                    "","w=夜之光");
            System.out.println(resultString);
        } catch (Exception e) {

            // TODO: handle exception

            System.out.print(e.getMessage());

        }
    }
}
