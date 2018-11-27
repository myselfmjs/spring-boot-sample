package spring.boot.sample.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: majunsheng
 * @Date: 2018/11/26
 **/
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpReqeuest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        //新增一个属性，测试Listener 是否会监听
        httpReqeuest.setAttribute("add","add");

        httpReqeuest.setAttribute("remove","remove");
        httpReqeuest.setAttribute("remove","remove again");

        httpReqeuest.removeAttribute("remove");


        String url = httpReqeuest.getRequestURI();
        String addr = httpReqeuest.getRemoteAddr();
        int post = httpReqeuest.getRemotePort();
        String host =  httpReqeuest.getRemoteHost();
        String localAddr = httpReqeuest.getLocalAddr();
        String localName = httpReqeuest.getLocalName();
        int localPost =  httpReqeuest.getLocalPort();
        //web 项目的根路径
        String strUrl = httpReqeuest.getContextPath();

       /* System.out.println("url:"+ url);
        System.out.println("post:"+ post);
        System.out.println("host:"+ host);
        System.out.println("addr:"+ addr);
        System.out.println("localAddr:"+ localAddr);
        System.out.println("localName:"+ localName);
        System.out.println("localPost:"+ localPost);
        System.out.println("strUrl:"+ strUrl);*/

        filterChain.doFilter(httpReqeuest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
