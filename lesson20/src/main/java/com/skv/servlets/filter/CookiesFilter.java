package com.skv.servlets.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/servlet2")
public class CookiesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        Cookie[] cookies = request1.getCookies();

        if( cookies != null){
            for (Cookie cookie: cookies){
                if (cookie.getValue().equals("value")){
                    chain.doFilter(request, response);
                }
            }
        } else {
            throw new RuntimeException("Please, you have to visit the first page");
        }
    }

    @Override
    public void destroy() {

    }
}
