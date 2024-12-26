package com.iterface.fi;

/*-
    Functional Interface là một interface chỉ có duy nhất một phương thức trừu
    tượng (abstract method ~ abstract function) hoặc single abstract method
    (SAM). Ví dụ Predicate, Function, Runnable, Callable,...
 */
public class FunctionInterface {

    @FunctionalInterface
    interface MyStringUtils {

        // Hàm sẽ thực hiện công việc gì đó với chuỗi truyền vào
        int process(String s);

        // int process2(String s); // Đóng/mở để thấy sự khác biệt

    }

    public static int doAction(String input, MyStringUtils processor) {
        return processor.process(input);
    }

    public static int withoutLambda() { // <- anonymous function
        return doAction("Hello Java", new MyStringUtils() {
            @Override
            public int process(String s) {
                return s.length();
            }
        });
    }

    public static int useLambda() {
        return doAction("Use lambda", s -> s.length());
    }

    public static int methodReference() {
        return doAction("Method reference", String::length);
    }

    public static void main(String[] args) {
        System.out.println("useLambda(): " + useLambda());
        System.out.println("withoutLambda(): " + withoutLambda());
        System.out.println("methodReference(): " + methodReference());

    }

}
