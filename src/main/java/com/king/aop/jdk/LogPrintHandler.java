package com.king.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogPrintHandler implements InvocationHandler{

    private Object target;
    public LogPrintHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------模拟执行AOP织入代码！！--------------");
        Object obj = method.invoke(this.target, args);
        return obj;
    }
}
