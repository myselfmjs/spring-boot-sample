package spring.boot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.ErrorPageFilter;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="spring.boot.sample")
@EnableScheduling
public class DemoApplication extends SpringBootServletInitializer {

	/*@Bean
	public ErrorPageFilter errorPageFilter() {
		ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/WEB-INF/error/404.jsp");
		ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/WEB-INF/error/404.jsp");
		ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/error/404.jsp");
		ErrorPageFilter errorPageFilter = new ErrorPageFilter();
		errorPageFilter.addErrorPages(error404Page,error405Page,error500Page);
		return errorPageFilter;
	}*/

	/*@Bean
	public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR);
		filterRegistrationBean.setFilter(filter);
		//filterRegistrationBean.setEnabled(true);
		return filterRegistrationBean;
	}
*/
	@Bean
	public PropertySourcesPlaceholderConfigurer loadPropertyPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		List<Resource> resources = new ArrayList<Resource>();
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		//String env = ConfigUtil.getProfilesActivie();
		resources.add(resourceLoader.getResource("classpath:application.properties"));
		configurer.setLocations(resources.toArray(new Resource[resources.size()]));
		return configurer;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
