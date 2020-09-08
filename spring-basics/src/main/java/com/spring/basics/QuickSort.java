package com.spring.basics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSort implements Sort {
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
