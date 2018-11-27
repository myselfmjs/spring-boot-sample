package spring.boot.sample.common.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * @Author: majunsheng
 * @Date: 2018/11/26
 * 监听Request中的属性操作
 **/
public class ServletRequestAttributerListener01 implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("------- request  添加属性后 -------");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("------- request  删除属性后 -------");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("------- request  替换属性后 -------");
        String name = srae.getName();
        Object value = srae.getValue();
        System.out.println("request被替换的key：" + name + "  ,替换前的value：" + value);

    }
}
