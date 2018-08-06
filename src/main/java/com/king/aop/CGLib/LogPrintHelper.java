package com.king.aop.CGLib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class LogPrintHelper {

    private static class MyCallback implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("--------------------执行AOP织入的代码!!!----------------------");
            Object ret = proxy.invokeSuper(obj, args);
            return ret;
        }
    }

    public static void main(String[] args) {
        //将动态代理生成class文件并存储到C:/Users/Administrator/Desktop/aop/下
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:/Users/Administrator/Desktop/aop/");
        Enhancer enhancer = new Enhancer();
        //设置需要代理的类
        enhancer.setSuperclass(UserService.class);
        //设置要代理的拦截类
        enhancer.setCallback(new MyCallback());
        //生成代理类的实例
        UserService service = (UserService) enhancer.create();
        service.doSomething();
        System.out.println(" ");
    }
}
