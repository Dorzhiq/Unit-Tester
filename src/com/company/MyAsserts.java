package com.company;

public class MyAsserts {
    public void MyAsssertEquals(Object i, Object j){
        if (i.equals(j)){
        }else {
            throw new MyExceptions();
        }
    }
    public void MyAssertTrue(boolean i){
        if (i!=true){
            throw new MyExceptions();
        }
    }
    public void MyAssertFalse(boolean i){
        if (i!=false){
            throw new MyExceptions();
        }
    }
    public void MyAssertArrayEquals(byte[] i, byte[] j){
        if(i.equals(j)){
        }else {
            throw new MyExceptions();
        }
    }
}
