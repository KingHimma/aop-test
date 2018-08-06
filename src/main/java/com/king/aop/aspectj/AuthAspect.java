//package com.king.aop.aspectj;
//
//public aspect AuthAspect{
//    before():execution(* com.king.aop.aspectj.*Service.*(..)){
//        System.out.println("--------------方法执行开始，模拟记录日志-------------");
//    }
//
//    after():execution(* com.king.aop.aspectj.*Service.*(..)){
//        System.out.println("--------------方法执行结束，模拟删除会话-------------");
//        System.out.println();
//    }
//}
//
//
////表达式格式
//execution(modifiers? ret-type? declaring-type? name(param) throws?)
//
//        以上所有部分除了returning type和name以及paramter之外都是可选的,
//        returning类型决定了匹配的方法必须要有指定的返回类型,可以使用*表示任意返回类型
//        只有当方法返回指定类型时,完全限定的类名才会被匹配,name匹配方法名,可以使用*匹配全部或部分方法名
//        parameters匹配就复杂一下：() 匹配一个无形参的方法,(..)匹配任意数量的形参方法(0~n),(*)匹配带一个任意类型的形参方法
//        (*,String)匹配带两个形参,第一个任意类型,第二个必须是String类型
//
//        execution(public * *(..)):任意public方法
//        execution(* set*(..)):方法名以set开头的任意方法
//        execution(* com.xyz.service.AccountService.*(..))：AccountService 接口下的任意方法
//        execution(* com.xyz.service..(..))：service包下的任意方法
//        execution(* com.xyz.service...(..))：service包或子包下的任意方法
//        execution(public void MyClass.myMethod(String)) :MyClass 类的myMethod方法,方法public访问权限,void返回值,形参只有一个并为String类型
//        execution(void MyClass.myMethod(..)):MyClass 类的myMethod方法,任意访问权限,返回值void,任意形参
//        execution(* MyClass.myMethod(..)):MyClass 类的myMethod方法,任意返回值,任意形参
//        execution(* MyClass.myMethod*(..)):MyClass 类的以myMethod开头的方法,任意返回值,任意形参
//        execution(* MyClass.myMethod*(String,..)):MyClass 类的以myMethod开头的方法,任意返回值,第一个形参类型是String
//        execution(* *.myMethod(..)):任意类下myMethod方法 execution(MyClass.new()):任意MyClass类的无参构造器
//        execution(MyClass.new(..)):任意MyClass类的任意有参构造器 execution(MyClass+.new(..)):任意MyClass或其子类构造器
//        execution(public * com.mycompany..*.*(..)):com.mycompany包下任意子包的所有类的所有public 方法
//
//        Spring AOP只能切方法(也就是任意连接点中的方法),AspectJ可以切任意成员(任意连接点,包括类/对象初始化块,field,方法,构造器)
//        within(com.xyz.service.*)：service包下任意连接点
//        within(com.xyz.service..*)：service包或子包下任意连接点
//        this(com.xyz.service.AccountService)：AccountService接口的代理实现里的任意连接点
//        target(com.xyz.service.AccountService):目标对象实现了AccountService接口的任意连接点
//        args(java.io.Serializable)：只有一个参数且参数在运行时是Serializable类型的任意连接点
//@target(org.springframework.transaction.annotation.Transactional)：目标对象有一个@Transactional注解任意连接点
//@within(org.springframework.transaction.annotation.Transactional)：目标对象的声明类型有一个@Transactional注解任意连接点
//@annotation(org.springframework.transaction.annotation.Transactional)：执行方法有一个@Transactional注解的任意连接点
//@args(com.xyz.security.Classified)：只有一个参数且参数在运行时参数有@Classified注解的任意连接点
//bean(tradeService)：Spring bean 名称是tradeService的任意连接点
//        bean(*Service)：Spring bean的名称以Service结尾的任意连接点
////表达式可以使用|| && !进行组合  在XML下就是 or and not
//        execution(* com.xyz.myapp.service..(..)) and this(service)//xml