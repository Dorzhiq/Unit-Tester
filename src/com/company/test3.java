package com.company;

public class test3 {
    @MyTest (expected = MyExceptions.class)
    public static void Test3 (){
        System.out.println("Test3");
    }
}