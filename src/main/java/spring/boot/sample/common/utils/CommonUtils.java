package spring.boot.sample.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;

/**
 * 公用 工具类
 */
public class CommonUtils {


    /**
     * 获取下载模板路径
     * @param request
     * @return
     */
    public static String getTempletPath(HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/");
        if (StringUtils.isBlank(realPath )) {
            try {
                // 支持Weblogic
                realPath = request.getSession().getServletContext().getResource("/").getPath();
            } catch (MalformedURLException e) {
                realPath= "";
            }
        }
        realPath += "/WEB-INF/template/";
        return realPath;
    }

}
