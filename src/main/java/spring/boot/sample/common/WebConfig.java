package spring.boot.sample.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spring.boot.sample.Interceptor.LoginInterceptor;

/**
 * @Author: majunsheng
 * @Date: 2018/11/27
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                //拦截URL，默认为全部拦截
                .addPathPatterns();
                //排除不需要验证登录用户操作权限的请求
                //excludePathPatterns("/css/**")
                //excludePathPatterns("/js/**")
                //excludePathPatterns("/images/**")

        //super.addInterceptors(registry);
    }
}
