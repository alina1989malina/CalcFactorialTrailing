package com.factorial.calcFactorialTrailing.service;

import java.util.stream.LongStream;

public class FactorialService {

    public static Long getFactorialTrail(Long number) {
        if (number < 5) return 0L;
        return LongStream.range(5, number + 1).map(FactorialService::countDegreeOfFive).reduce(Long::sum).getAsLong();
    }

    private static Long countDegreeOfFive(Long number) {
        Long count = 0L;
        while (number % 5 == 0) {
            number /= 5;
            ++count;
        }
        return count;
    }
}
