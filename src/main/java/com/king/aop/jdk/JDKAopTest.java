package com.king.aop.jdk;

import org.springframework.cglib.core.DebuggingClassWriter;

import java.lang.reflect.Proxy;

public class JDKAopTest {
    public static void main(String[] args) {
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IUserService userService = (IUserService) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(), new Class[]{IUserService.class},new LogPrintHandler(new UserService()));
        /**
         * Thread.currentThread().getContextClassLoader()拿到当前线程的上下文类加载
         */
        userService.doSomething();


    }
}
