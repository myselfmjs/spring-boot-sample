package spring.boot.sample.common.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @Author: majunsheng
 * @Date: 2018/11/26
 * 监听Request对象 创建、销毁
 **/
public class ServletRequestListener01 implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("--------Request即将被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("--------Request即将被初始化");

    }
}
