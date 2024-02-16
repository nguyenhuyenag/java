package com.stream.generate;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class Generate {

    /**
     * Tạo ra một Stream vô hạn chứa các phần tử được sinh ra bởi một Supplier:
     */
    public static void generate() {
        Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();
        Stream.generate(uuidSupplier) //
                .limit(10) //
                .forEach(System.out::println);
    }

    /**
     * Tạo ra một Stream (sequence) có thứ bậc, trong đó mỗi phần tử được tạo
     * bởi phần tử trước đó thông qua hàm chuyển đổi
     */
    public static void iterate() {
        // Bắt đầu từ 0, mỗi phần tử tiếp theo sẽ bằng phần tử trước + 2
        List<Integer> list = Stream.iterate(0, t -> t + 2).limit(5).toList();
        System.out.println("iterate: " + list);
    }

    public static void main(String[] agrs) {
        // generate();
        iterate();
    }

}
