//package com.king.aop.jdk.explain;
//
////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//import com.king.aop.jdk.IUserService;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.lang.reflect.UndeclaredThrowableException;
//
//public final class $Proxy0 extends Proxy implements IUserService {
//    private static Method m1;
//    private static Method m0;
//    private static Method m3;
//    private static Method m2;
//
//    public $Proxy0(InvocationHandler var1) throws  {
//        super(var1);
//    }
//
//    public final boolean equals(Object var1) throws  {
//        try {
//            return ((Boolean)super.h.invoke(this, m1, new Object[]{var1})).booleanValue();
//        } catch (RuntimeException | Error var3) {
//            throw var3;
//        } catch (Throwable var4) {
//            throw new UndeclaredThrowableException(var4);
//        }
//    }
//
//    public final int hashCode() throws  {
//        try {
//            return ((Integer)super.h.invoke(this, m0, (Object[])null)).intValue();
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    public final void doSomething() throws  {
//        try {
//            super.h.invoke(this, m3, (Object[])null);
//            //就是调用我们自定义的InvocationHandlerImpl的 invoke方法：
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    public final String toString() throws  {
//        try {
//            return (String)super.h.invoke(this, m2, (Object[])null);
//        } catch (RuntimeException | Error var2) {
//            throw var2;
//        } catch (Throwable var3) {
//            throw new UndeclaredThrowableException(var3);
//        }
//    }
//
//    static {
//        try {
//            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
//            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
//            m3 = Class.forName("com.king.aop.jdk.IUserService").getMethod("doSomething");
//            m2 = Class.forName("java.lang.Object").getMethod("toString");
//        } catch (NoSuchMethodException var2) {
//            throw new NoSuchMethodError(var2.getMessage());
//        } catch (ClassNotFoundException var3) {
//            throw new NoClassDefFoundError(var3.getMessage());
//        }
//    }
//}
