package ua.kpi.tef;

import java.util.HashMap;
import java.util.TreeMap;

public class temp {

    public static void main(String[] args) {
        A.printText("text");
        B.printText("textt");

        TreeMap<String, String> mp = new TreeMap<>();

        mp.put("1", "1");
        mp.put("2", "2");

    }
}

class Terp  implements A,B{

}

interface A {
    static void printText(String text) {
        System.out.println("text in a: " + text);
    }
}

interface B {
    static void printText(String text) {
        System.out.println("text in b: " + text);
    }
}
