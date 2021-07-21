package com.ishostak.tasks.lec13_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtils {

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4,-5,5,6,7,8,0);

        System.out.println("Average: " + average(list));
        System.out.println("Min " + findMinAndIndex(list));
        System.out.println("Count of \"0\" " + zeroCounter(list));
        System.out.println("Count of \">0\" " + positiveCounter(list));

        System.out.println("\nMultiplier example: \n");
        System.out.println("Original list: " + list);
        System.out.println("Multiplied list: " + multiplier(list, 2));
    }

    public static double average(List<Integer> integers) {
        return integers.stream()
                .mapToInt(i->i)
                .average()
                .getAsDouble();
    }

    public static String findMinAndIndex(List<Integer> integers) {
        int min = integers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
        return min +  " and index: " + integers.indexOf(min);
    }

    public static long zeroCounter(List<Integer> integers) {
        return integers.stream()
                .filter(x -> x == 0)
                .count();
    }

    public static long positiveCounter(List<Integer> integers) {
        return integers.stream()
                .filter(x -> x > 0)
                .count();
    }

    public static List<Integer> multiplier(List<Integer> integers, int mult) {
        return integers.stream()
                .map(x-> x * mult)
                .collect(Collectors.toList());
    }
}
