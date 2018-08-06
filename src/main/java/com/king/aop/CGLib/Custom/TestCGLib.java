package com.king.aop.CGLib.Custom;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class TestCGLib {

    /**
     * 这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展，以后会经常看到它。
     首先将被代理类TargetObject设置成父类，然后设置拦截器TargetInterceptor，
     最后执行enhancer.create()动态生成一个代理类，并从Object强制转型成父类型TargetObject。
     * @param args
     */
    public static void main(String args[]) {
        //将动态代理生成class文件并存储到C:/Users/Administrator/Desktop/aop/下
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:/Users/Administrator/Desktop/aop/");
        TestCGLib test = new TestCGLib();

//        test.test1();

        test.test2();
    }

    private void test1(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2=(TargetObject)enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("King"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }

    private void test2(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        Callback noopCb= NoOp.INSTANCE;//这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
        Callback callback1=new TargetInterceptor();//方法拦截器
        Callback fixedValue=new TargetResultFixed();//表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
        Callback[] cbarray=new Callback[]{callback1,noopCb,fixedValue};
        //enhancer.setCallback(new TargetInterceptor());
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(callbackFilter);
        TargetObject targetObject2=(TargetObject)enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("King"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(100));
        System.out.println(targetObject2.method3(200));
    }
}
