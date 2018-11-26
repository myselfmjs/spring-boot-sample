package spring.boot.sample.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSession;

/**
 * @Author: majunsheng
 * @Date: 2018/11/26
 * 监听Session
 **/
public class MyHttpSessionListener implements javax.servlet.http.HttpSessionListener {

    public static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("------ 创建Session -----");
        String sessionId =  se.getSession().getId();
        System.out.println("SessionId:" + sessionId);
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("------ 销毁Session ------");
    }
}
