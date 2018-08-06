package com.king.aop.aspectj;

public class UserService {
    public int addUser(){
        System.out.println("模拟添加用户的方法。");
        return 20;
    }
    public void validateLogin(){
        System.out.println("验证用户登录。");
    }
}
