package com.company;

import java.util.ArrayList;

public class MySyncList<T> extends ArrayList<T> {
    public void push(T o) {
        add(o);
    }
    public synchronized T pop() {
        return remove(size()-1);
    }

}
