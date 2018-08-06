package com.king.aop.CGLib;

import org.springframework.stereotype.Component;

public class UserService {

    public void doSomething(){
        System.out.println("CGLib中原有业务逻辑代码");
    }
}
