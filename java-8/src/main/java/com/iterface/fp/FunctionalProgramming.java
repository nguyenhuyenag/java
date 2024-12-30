package com.iterface.fp;

/*-
 	Lập trình hướng hàm là đưa hành vi vào hàm. Hay nói cách khác là đưa thêm
 	các đoạn code vào hàm như là một parameter.
 */
public class FunctionalProgramming {

    @FunctionalInterface
    interface NumberFunction {

        // Hàm sẽ thực hiện công việc gì đó với 2 số được truyền vào
        int process(int a, int b);

    }

    public static int doAction(int a, int b, NumberFunction function) {
        return function.process(a, b);
    }

    public static void main(String[] args) {
        int a = 3, b = 4;

        // Cộng 2 số
        int sum = doAction(a, b, (x, y) -> x + y);
        System.out.println(a + " + " + b + " = " + sum);

        // Nhân 2 số
        int product = doAction(a, b, (x, y) -> x * y);
        System.out.println(a + " * " + b + " = " + product);

        // Tìm max(a,b)
        int max = doAction(a, b, Math::max);
        System.out.println("max(" + a + ", " + b + ") = " + max);
    }

}
