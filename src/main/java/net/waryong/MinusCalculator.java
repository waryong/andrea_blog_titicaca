package net.waryong;

import org.springframework.stereotype.Component;

/**
 * Created by waryong on 2016. 1. 2..
 */


public class MinusCalculator implements Calculator {

    @Override
    public int calc(int a, int b) {
        return (a - b);
    }
}
