package com.company;
import java.lang.annotation.*;
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface MyTest {
    Class expected();
}