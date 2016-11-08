package com.hahaeasy.easyjetty.server;

import com.hahaeasy.easyjetty.servlet.DefaultServlet;
import com.hahaeasy.easyjetty.servlet.HelloServlet;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by tonyxue on 2/5/16.
 */
public class ServiceConfig {
    static Logger log = Logger.getLogger(ServiceConfig.class);

    static int serverPort = 8060;


    static void startServer() {
        try {
            Server server = new Server(serverPort);

            System.getProperties().setProperty("jetty.port", new Integer(serverPort).toString());

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            server.setHandler(context);

            context.addServlet(new ServletHolder(new HelloServlet()),"/hello");

            context.addServlet(new ServletHolder(new DefaultServlet()),"/*");

            server.start();

            server.join();

        } catch (Exception e) {
            log.error(e.toString(), e);
        }
    }

    public static void main(String[] args) {
        startServer();
    }



}
