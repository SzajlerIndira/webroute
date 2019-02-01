package com.codecool.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodAnnotation {

    public String getPath() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String path = null;
        Method[] methods = AnnotationImplementation.class.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(WebRoute.class);
            if (annotation instanceof WebRoute) {
                WebRoute webRoute = (WebRoute) annotation;
                path = webRoute.path();
                System.out.println(path);
                method.invoke(null);
            }
        }
        return path;
    }
}
