package com.king.aop.CGLib.Custom;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 目标对象拦截器，实现MethodInterceptor
 * 定义一个拦截器。在调用目标方法时，CGLib会回调MethodInterceptor接口方法拦截，
 * 来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口。
 */
public class TargetInterceptor implements MethodInterceptor {
    /**
     * 重写方法拦截在方法前和方法后加入业务
     * @param o  CGLib动态代理类实例
     * @param method   Method为上文中实体类所调用的被代理的方法引用
     * @param objects    参数值列表
     * @param methodProxy MethodProxy为生成的代理类对方法的代理引用
     * @return 从代理实例的方法调用返回的值。
     * @throws Throwable
     *
     *   其中，proxy.invokeSuper(obj,arg)：
     *   调用代理类实例上的proxy方法的父类方法（即实体类TargetObject中对应的方法）
     *   在这个示例中，只在调用被代理类方法前后各打印了一句话，当然实际编程中可以是其它复杂逻辑。
     *
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------------调用前-------------");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("-------------调用后-------------"+result);
        return result;
    }


}
