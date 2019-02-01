package com.codecool.annotation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;

public class MyHandler implements HttpHandler {


        public static void main(String[] args) throws Exception {
            AnnotationHandler methodAnnotation = new AnnotationHandler();
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext(methodAnnotation.getPath(), new MyHandler());
            server.setExecutor(null); // creates a default executor
            server.start();

        }


        public void handle(HttpExchange t) throws IOException {
            String response = null;
            try {
                response = AnnotationHandler.getResponse(t);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }



}
