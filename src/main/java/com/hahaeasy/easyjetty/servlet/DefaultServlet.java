package com.hahaeasy.easyjetty.servlet;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tonyxue on 2/5/16.
 */
public class DefaultServlet extends HttpServlet {
    public DefaultServlet(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGetPost(request, response);
    }

    private void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();

        ServletOutput result = new ServletOutput();
        result.setTitle("Welcome to EasyJetty");
        result.setContent("Your request URL: " + request.getRequestURL());
        response.setContentType("text/json");

        response.getWriter().write(gson.toJson(result));
        response.getWriter().flush();

    }


}
