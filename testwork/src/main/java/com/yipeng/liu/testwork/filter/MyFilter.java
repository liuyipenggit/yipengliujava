package com.yipeng.liu.testwork.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lyp
 * @version V1.0
 * @Package com.yipeng.liu
 * @date 2021/8/20 14:00
 * @Copyright 韵达快递
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter 创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行过滤过程");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁！");
    }
}
