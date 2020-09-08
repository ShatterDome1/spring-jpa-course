package com.spring.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch{

    @Autowired
    private Sort sort;

    public int binarySearch(int[] numbers, int no) {
        // Use sorting algorithm
        int[] sorted = sort.sort(numbers);
        System.out.println(sort);

        // search
        return 3;
    }
}
