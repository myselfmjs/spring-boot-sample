package spring.boot.sample.error;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: majunsheng
 * @Date: 2018/11/26
 * SpringBoot2.0 配置错误页面
 **/
@Configuration
public class ErrorConfig02 {

    /*@Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/WEB-INF/error/404.jsp");
                ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/WEB-INF/error/404.jsp");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/error/404.jsp");

                factory.addErrorPages(error404Page,error405Page,error500Page);
            }
        };
    }*/
}
