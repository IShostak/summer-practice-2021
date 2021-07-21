package com.ishostak.tasks.lec12_collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountElements {
    /*Есть ArrayList<Integer> - ов. За один проход подсчитать количество повторений каждого элемента.

        Т.е., если мы имеем массив с элементами:

        4,5,-6,4,5,3,4,2,4,5,7

        То получим структуру:

        -6 – 1

        2 – 1

        3 – 1

        4 – 4

        5 – 3

      7 – 1 */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,-6,4,5,3,4,2,4,5,7);

        Map<Integer, Integer> unique = countUniqueStreamToMap(list);

        for (Map.Entry<Integer, Integer> entry : unique.entrySet()) {
            System.out.println(entry);
        }

    }

    public static Map<Integer, Integer> countUnique(List<Integer> integers) {
        Map<Integer, Integer> result = new HashMap<>();

        for (Integer integer : integers) {
            result.computeIfPresent(integer, (x,y) -> y += 1);
            result.putIfAbsent(integer, 1);
        }

        return result;
    }

    public static Map<Integer, Long> countUniqueStream(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));
    }


    public static Map<Integer, Integer> getNumbersCount(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toMap(Function.identity(), num -> 1, (x, y) -> x + 1, HashMap::new));
    }

    public static Map<Integer, Integer> countUniqueStreamToMap(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, (x,y) -> y + 1));
    }
}
