package com.codecool.annotation;
import com.sun.net.httpserver.HttpExchange;

import java.lang.Object;
public class App {
    @WebRoute(path = "/test")





    void onTest(){

        System.out.println("ez a teszt");
    }
}
