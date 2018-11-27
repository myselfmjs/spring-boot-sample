package spring.boot.sample.common.initlizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Author: majunsheng
 * @Date: 2018/11/20
 **/
@Order(1)
public class MyWebApplicationInitializer02 implements WebApplicationInitializer{

    private Logger logger= LoggerFactory.getLogger(MyWebApplicationInitializer02.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        logger.info("启动加载自定义的MyWebApplicationInitializer02");
        System.out.println("启动加载自定义的MyWebApplicationInitializer02");
    }
}
