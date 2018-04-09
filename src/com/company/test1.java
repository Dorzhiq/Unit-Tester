package com.company;

public class test1 {

    @MyTest (expected = MyExceptions.class)
    public static void Test1 (){
        System.out.println("Test1");
    }

}
