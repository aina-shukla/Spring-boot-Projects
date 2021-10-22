package com.utils;

import com.demo.exceptions.SomeException;

public class Calculator {

    public int add(int... nums){
        int result = 0;
        for(int n : nums){
            result+=n;
        }
        return result;
    }

    public int div(int a, int b) throws SomeException{
        try{
            return a/b;
        } catch(ArithmeticException e){
            throw new SomeException(e);
        }
    }
    
}