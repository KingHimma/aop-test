package com.king.aop.CGLib.Custom;

public class TargetObject {
    public String method1(String params) {
        return params;
    }
    public int method2(int count) {
        return count;
    }
    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }
}
