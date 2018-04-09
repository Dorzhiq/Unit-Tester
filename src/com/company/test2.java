package com.company;

public class test2 {
    @MyTest (expected = MyExceptions.class)
    public static void Test2 (){
        System.out.println("Test2");
    }
}
