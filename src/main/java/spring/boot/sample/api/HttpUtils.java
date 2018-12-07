package spring.boot.sample.api;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

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
       /* try {

            String resultString = HttpUtils.sendGet(
                    "http://c.y.qq.com/soso/fcgi-bin/client_search_cp",
                    "","w=夜之光");
            System.out.println(resultString);
        } catch (Exception e) {

            // TODO: handle exception

            System.out.print(e.getMessage());

        }*/
       String lry = "W3RpOueou+mmmV0KW2FyOuWRqOadsOS8pl0KW2FsOumtlOadsOW6p10KW2J5Ol0KW29mZnNldDowXQpbMDA6MDAuMDBd56i76aaZIC0g5ZGo5p2w5LymIChKYXkgQ2hvdSkKWzAwOjEwLjIyXeivje+8muWRqOadsOS8pgpbMDA6MjAuNDRd5puy77ya5ZGo5p2w5LymClswMDozMC42Nl3lr7nov5nkuKrkuJbnlYzlpoLmnpzkvaDmnInlpKrlpJrnmoTmirHmgKgKWzAwOjM0LjExXei3jOWAkuS6huWwseS4jeaVoue7p+e7reW+gOWJjei1sApbMDA6MzcuMDdd5Li65LuA5LmI5Lq66KaB6L+Z5LmI55qE6ISG5byx5aCV6JC9ClswMDo0MS41MF3or7fkvaDmiZPlvIDnlLXop4bnnIvnnIsKWzAwOjQzLjA1XeWkmuWwkeS6uuS4uueUn+WRveWcqOWKquWKm+WLh+aVoueahOi1sOS4i+WOuwpbMDA6NDcuMDNd5oiR5Lus5piv5LiN5piv6K+l55+l6LazClswMDo0OS40Nl3nj43mg5zkuIDliIflsLHnrpfmsqHmnInmi6XmnIkKWzAwOjUyLjkyXQpbMDA6NTQuMDRd6L+Y6K6w5b6X5L2g6K+05a625piv5ZSv5LiA55qE5Z+O5aChClswMDo1Ny42M13pmo/nnYDnqLvpppnmsrPmtYHnu6fnu63lpZTot5EKWzAxOjAwLjU3XeW+ruW+rueskSDlsI/ml7blgJnnmoTmoqbmiJHnn6XpgZMKWzAxOjA0LjM0XQpbMDE6MDUuNzNd5LiN6KaB5ZOt6K6p6JCk54Gr6Jmr5bim552A5L2g6YCD6LeRClswMTowOS4yNF3kuaHpl7TnmoTmrYzosKPmsLjov5znmoTkvp3pnaAKWzAxOjEyLjE3XeWbnuWutuWQpyDlm57liLDmnIDliJ3nmoTnvo7lpb0KWzAxOjE2Ljg3XQpbMDE6NDEuMDBd5LiN6KaB6L+Z5LmI5a655piT5bCx5oOz5pS+5byDClswMTo0My4xNF3lsLHlg4/miJHor7TnmoQKWzAxOjQ0LjU0Xei/veS4jeWIsOeahOaipuaDs+aNouS4quaipuS4jeWwseW+l+S6hgpbMDE6NDcuNThd5Li66Ieq5bex55qE5Lq655Sf6bKc6Imz5LiK6ImyClswMTo0OS44OF3lhYjmiorniLHmtoLkuIrllpzmrKLnmoTpopzoibIKWzAxOjUyLjU2XeeskeS4gOS4quWQpwpbMDE6NTMuNjFd5Yqf5oiQ5ZCN5bCx5LiN5piv55uu55qEClswMTo1NS42MV3orqnoh6rlt7Hlv6vkuZDlv6vkuZDov5nmiY3lj6vlgZrmhI/kuYkKWzAxOjU4LjU4XeerpeW5tOeahOe6uOmjnuacugpbMDI6MDAuMTBd546w5Zyo57uI5LqO6aOe5Zue5oiR5omL6YeMClswMjowMi44OF0KWzAyOjA0LjI5XeaJgOiwk+eahOmCo+W/q+S5kApbMDI6MDUuNzJd6LWk6ISa5Zyo55Sw6YeM6L+96Jy76JyT6L+95Yiw57Sv5LqGClswMjowOC43MF3lgbfmkZjmsLTmnpzooqvonJzonILnu5nlj67liLDmgJXkuoYKWzAyOjExLjc0XeiwgeWcqOWBt+eskeWRogpbMDI6MTMuMjRd5oiR6Z2g552A56i76I2J5Lq6ClswMjoxNC40OV3lkLnnnYDpo44g5ZSx552A5q2MIOedoeedgOS6hgpbMDI6MTcuNTVd5Y2I5ZCO5ZCJ5LuW5Zyo6Jmr6bij5Lit5pu05riF6ISGClswMjoxOS42Nl0KWzAyOjIwLjQ1XemYs+WFiea0kuWcqOi3r+S4iuWwseS4jeaAleW/g+eijgpbMDI6MjMuMTdd54+N5oOc5LiA5YiHIOWwseeul+ayoeacieaLpeaciQpbMDI6MjYuMjhdClswMjoyNy43Nl3ov5jorrDlvpfkvaDor7TlrrbmmK/llK/kuIDnmoTln47loKEKWzAyOjMxLjMzXemaj+edgOeou+mmmeays+a1gee7p+e7reWllOi3kQpbMDI6MzQuMTld5b6u5b6u56yRIOWwj+aXtuWAmeeahOaipuaIkeefpemBkwpbMDI6MzguMDNdClswMjozOS4yNV3kuI3opoHlk63orqnokKTngavomavluKbnnYDkvaDpgIPot5EKWzAyOjQyLjk0XeS5oemXtOeahOatjOiwo+awuOi/nOeahOS+nemdoApbMDI6NDYuMDFd5Zue5a625ZCnIOWbnuWIsOacgOWIneeahOe+juWlvQpbMDI6NTEuMDld6L+Y6K6w5b6X5L2g6K+05a625piv5ZSv5LiA55qE5Z+O5aChClswMjo1NC43M13pmo/nnYDnqLvpppnmsrPmtYHnu6fnu63lpZTot5EKWzAyOjU3LjY3XeW+ruW+rueskSDlsI/ml7blgJnnmoTmoqbmiJHnn6XpgZMKWzAzOjAxLjczXQpbMDM6MDIuNzhd5LiN6KaB5ZOt6K6p6JCk54Gr6Jmr5bim552A5L2g6YCD6LeRClswMzowNi40NF3kuaHpl7TnmoTmrYzosKPmsLjov5znmoTkvp3pnaAKWzAzOjA5LjQwXeWbnuWutuWQpyDlm57liLDmnIDliJ3nmoTnvo7lpb0=";
        System.out.println(lry);
    }
}
