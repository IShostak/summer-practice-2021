package com.ishostak.tasks.habrexceptionscode;

public class HabrExamples {
    public static void main(String[] args) throws Throwable {
        try {
        } catch (Throwable t) {}

//        Error ref = new Error(); // создаем экземпляр
//        throw ref;               // "бросаем" его
    }

    public static void main2(String[] args) {
        f(null);
    }
    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }

        //RUNTIME ERROR: Exception in thread "main" java.lang.StackOverflowError
    }

    /* sysout vs syserror
    буфер сообщений
                    +----------------+
                 +->| msg2 msg1 msg0 | --> out
                /   +----------------+        \
               /                                 +-> +--------+
ВАШЕ ПРИЛОЖЕНИЕ                                      | КОНСОЛЬ|
               \                                 +-> +--------+
                \                               /
                 +------------------------> err
                 нет буфера, сразу печатаем
     */

    public double sqr(double arg) { // надо double
        int k = 1;                  // есть int
        return k;                   // можно неявно преобразовать int в double
    }

    public static double sqr2(double arg) {
        while (true); // Удивительно, но КОМПИЛИРУЕТСЯ!
    }

    public static double sqr3(double arg) {// согласно объявлению метода ты должен вернуть double
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            return arg * arg;             // ок, вот твой double
        } else if (time % 2 == 1) {

                while (true) ;                 // не, я решил "повиснуть"
            } else{
                throw new RuntimeException(); // или бросить исключение
            }
        }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            return -1; // специальное "неправильное" значение площади
        }
        return width * height;
    }

}
