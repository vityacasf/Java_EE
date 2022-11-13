package com.socialmedia.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebFilter(urlPatterns = "/Output.jsp",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoggingFilter implements Filter {

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            Cookie[] cookies = request.getCookies();
            if ((String) request.getServletContext().getAttribute("username") != null) {
                filterChain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/Authorization.jsp").forward(request, response);
            }
        }
    }


