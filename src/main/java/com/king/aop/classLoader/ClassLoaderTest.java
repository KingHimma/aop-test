package com.king.aop.classLoader;

import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest test = new ClassLoaderTest();
//        test.bootStrapClassLoadeLoadPath();
        test.printClassLoader();
    }

    /**
     * BootStrap ClassLoader：
     *      启动类加载器，是java中最顶层的类加载器
     *      底层由C++编写，已嵌入到了JVM内核当中，当JVM启动后，Bootstrap ClassLoader也随着启动，负责加载完核心类库后，并构造Extension ClassLoader和App ClassLoader类加载器。
     * 得到BootStrap ClassLoader类加载器从哪些地方加载了相关的jar或class文件：
     *
     * 该类加载器主要负责加载JDK中的核心类库
     */
    private void bootStrapClassLoadeLoadPath(){
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }

    /**
     * 打印ClassLoader的层次结构
     */
    private void printClassLoader(){
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();    //获得加载ClassLoaderTest.class这个类的类加载器
        while(loader != null) {
            System.out.println(loader);
            loader = loader.getParent();    //获得父类加载器的引用
        }
        System.out.println(loader);

        /**
         * 第一行结果说明：ClassLoaderTest的类加载器是AppClassLoader。
         第二行结果说明：AppClassLoader的类加器是ExtClassLoader，即parent=ExtClassLoader。
         第三行结果说明：ExtClassLoader的类加器是Bootstrap ClassLoader，因为Bootstrap ClassLoader不是一个普通的Java类，
         所以ExtClassLoader的parent=null，所以第三行的打印结果为null就是这个原因。
         */
    }
}
