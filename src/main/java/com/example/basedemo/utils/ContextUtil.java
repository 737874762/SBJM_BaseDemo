package com.example.basedemo.utils;


import com.example.basedemo.jwt.Payload;

/**
 * ThreadLocal工具类，用来获取请求用户的信息
 */
public class ContextUtil {



    //线程局部变量
    private static ThreadLocal<Payload> threadLocal = new ThreadLocal<Payload>();

    public static Payload getCurrentUser() {
        return threadLocal.get();
    }

    public static void setCurrentUser(Payload payload) {
        threadLocal.set(payload);
    }

    public static void clear() {
        threadLocal.remove();
    }

}
