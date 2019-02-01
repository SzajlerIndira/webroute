package com.codecool.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MethodAnnotation {

    public String getPath() throws NoSuchMethodException {
        String path = null;
        Method[] methods = App.class.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(WebRoute.class);
            if (annotation instanceof WebRoute) {
                WebRoute webRoute = (WebRoute) annotation;
                path = webRoute.path();
            }
        }
        return path;
    }
}
