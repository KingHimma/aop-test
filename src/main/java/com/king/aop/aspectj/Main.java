package com.king.aop.aspectj;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.addUser();
        userService.validateLogin();
        BookService bookService = new BookService();
        bookService.addBook("Spring4.0实战开发",45);
    }
}
