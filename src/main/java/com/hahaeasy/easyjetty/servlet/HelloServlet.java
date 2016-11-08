package com.hahaeasy.easyjetty.servlet;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tonyxue on 2/5/16.
 */
public class HelloServlet extends HttpServlet {
    static Logger log = Logger.getLogger(HelloServlet.class.getName());
    static AtomicInteger hitCount = new AtomicInteger(100);

    public HelloServlet(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetPost(request, response);
    }

    private void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();

        ServletOutput result = new ServletOutput();
        result.setTitle("Hello World");
        result.setContent("Add your contents here");
        response.setContentType("text/json");

        response.getWriter().write(gson.toJson(result));
        response.getWriter().flush();

    }


}
