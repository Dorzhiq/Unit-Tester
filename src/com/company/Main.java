package com.company;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyThread extends Thread {
    MyThread(String name){
        super(name);
    }
    public void run()
    {
        try {
            Class<?> clazz = Class.forName(Main.list.pop());
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Method[] methods = clazz.getMethods();

            for (Method i : methods) {
                if (i.isAnnotationPresent(MyBefore.class)){
                    i.invoke(obj);
                }
            }
            for (Method i : methods) {
                if (i.isAnnotationPresent(MyTest.class)){
                    MyTest test = i.getAnnotation(MyTest.class);
                    Class expected = test.expected();
                    try {
                        i.invoke(obj);
                    }
                    catch (MyExceptions e){
                        if (MyExceptions.class != expected) {
                            System.out.println("Not expected result");
                        }
                    }
                }
            }
            for (Method i : methods) {
                if (i.isAnnotationPresent(MyAfter.class)){
                    i.invoke(obj);
                }
            }

        } catch (ClassNotFoundException ex){
            System.out.println(ex.toString()+" Net takogo testa");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
public class Main {
    public static MySyncList<String> list = new MySyncList<>();
    public static void main(String[] args) {

        for (String arg : args){
            list.add(arg);
        }
        //some changes
//        list.add("com.company.test1");
//        list.add("com.company.test2");
//        list.add("com.company.test3");
        Thread[] threads = new Thread[4];
        while (list.size()!= 0) {
            for (int i = 1; i <= 2; i++) {
                if (list.size()!=0) {
                    threads[i - 1] = new MyThread("MyThread " + i);
                    threads[i - 1].start();
                    try {
                        threads[i - 1].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("No more tests");
                }
            }
        }
    }
}
