package com.smarttested.qa.smartutils.jdk8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrey.vorobyov on 03/04/14.
 */
public class LambdasMapTest {

    @Test
    public void addLambdaToMap() {
        Map<String, Operate> map = new HashMap<>();
        map.put("plus", (int a, int b) -> a + b);
        map.put("minus", (int a, int b) -> a - b);
        map.put("multiply", (int a, int b) -> a * b);

        map.forEach((String key, Operate value) -> {
            System.out.println(key + ": " + value.apply(1, 2));
        });
    }

    public static interface Operate {
        int apply(int a, int b);
    }
}
