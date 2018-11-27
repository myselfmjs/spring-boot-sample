package spring.boot.sample.common.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author: majunsheng
 * @Date: 2018/11/26
 * 通过application.properties 容器初始化执行
 **/
public class MyApplicationListener01 implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(String.format("%s --监听到事件源：%s.", MyApplicationListener01.class.getName(), applicationEvent.getSource()));

    }
}
