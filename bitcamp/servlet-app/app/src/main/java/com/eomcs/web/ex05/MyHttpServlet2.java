package com.eomcs.web.ex05;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class MyHttpServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)  req;
        HttpServletResponse response = (HttpServletResponse)  res;
        service(request, response);
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
