package net.waryong;

import org.springframework.stereotype.Component;

/**
 * Created by waryong on 2015. 12. 28..
 */

@Component
public class AddCalculator implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a+b;
    }


}
