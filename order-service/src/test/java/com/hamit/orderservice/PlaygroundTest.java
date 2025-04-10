package com.hamit.orderservice;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PlaygroundTest {
    @Test
    public void test() {
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> intList = List.of(intArr);
        System.out.println(intList);
    }
}
