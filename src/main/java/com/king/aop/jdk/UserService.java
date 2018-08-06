package com.king.aop.jdk;

public class UserService implements IUserService{
    @Override
    public void doSomething() {
        System.out.println("userService中原有业务逻辑");
    }
}
