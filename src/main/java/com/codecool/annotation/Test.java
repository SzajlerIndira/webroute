package com.codecool.annotation;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {
    static class MyHandler implements HttpHandler {


        public static void main(String[] args) throws Exception {
            MethodAnnotation methodAnnotation = new MethodAnnotation();
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext(methodAnnotation.getPath(), new MyHandler());
            server.setExecutor(null); // creates a default executor
            server.start();

        }
        //@WebRoute(path = "/test")
        public void handle(HttpExchange t) throws IOException {
            String response = "Thhhis is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
