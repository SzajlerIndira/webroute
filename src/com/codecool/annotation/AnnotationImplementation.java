package com.codecool.annotation;

public class AnnotationImplementation {
    @WebRoute(path = "/test")
    static String onTest(){

        return "This is test";
    }

    @WebRoute(path = "/test2")
    static String onTest2(){

        return "This is test2";
    }

}
