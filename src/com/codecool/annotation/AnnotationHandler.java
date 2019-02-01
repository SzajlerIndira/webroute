package com.codecool.annotation;

import com.sun.net.httpserver.HttpExchange;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationHandler {

    public String getPath() {
        String path;
        Method[] methods = AnnotationImplementation.class.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(WebRoute.class);
            if (annotation instanceof WebRoute) {
                WebRoute webRoute = (WebRoute) annotation;
                path = webRoute.path();
                return path;
            }
        }
        return null;
    }

    public static String getResponse(HttpExchange t) throws InvocationTargetException, IllegalAccessException {
        String response = "Something went wrong";

        String path;
        Method[] methods = AnnotationImplementation.class.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(WebRoute.class);
            if (annotation instanceof WebRoute) {
                WebRoute webRoute = (WebRoute) annotation;
                path = webRoute.path();
                if (t.getRequestURI().toString().equals(path)) {
                    response = (String) method.invoke(null);
                }
            }
        }
        return response;
    }
}
