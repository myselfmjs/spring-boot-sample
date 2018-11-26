package spring.boot.sample.error;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @Author: majunsheng
 * @Date: 2018/11/23
 * EmbeddedServletContainerCustomizer SpringBoot 2.0后不支持该组件
 * 替换为 WebServerFactoryCustomizer接口
 **/
@Configuration
public class ErrorConfig {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/WEB-INF/error/404.jsp");
                ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/WEB-INF/error/404.jsp");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/error/404.jsp");

                container.addErrorPages(error404Page,error405Page,error500Page);
            }
        };
    }
}

