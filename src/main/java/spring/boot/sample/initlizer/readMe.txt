
关于一起SpringBoot启动项操作

SpringBootServletInitializer
    implements
        WebApplicationInitializer


SpringServletContainerInitializer
    implements
        ServletContainerInitializer

此时我们先来看ServletContainerInitializer的作用，其主要就是在启动容器时负责加载相关配置：
 public abstract interface ServletContainerInitializer {
public abstract void onStartup(Set<Class<?>> paramSet, ServletContext paramServletContext) throws ServletException;
}
容器启动时会自动扫描当前服务中ServletContainerInitializer的实现类，并调用其onStartup方法，其参数Set<Class<?>> c，
可通过在实现类上声明注解javax.servlet.annotation.HandlesTypes(WebApplicationInitializer.class)注解自动注入，
@HandlesTypes会自动扫描项目中所有的WebApplicationInitializer.class的实现类，并将其全部注入Set。


在SpringServletContainerInitializer中可以发现所有WebApplicationInitializer实现类在执行onStartup方法前需要根据其注解@order值排序，