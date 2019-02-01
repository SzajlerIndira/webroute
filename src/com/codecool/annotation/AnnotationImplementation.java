package com.codecool.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationImplementation {
    @WebRoute(path= "/test")
    public static void callMe() {
        System.out.println("teszt1");
    }

}
