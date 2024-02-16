package com.stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.util.User;

public class StreamMethod {

    static int i = 0;

    // skip(): Bỏ qua k phần tử đầu tiên
    public static void skip(List<User> list) {
        list.stream().skip(5).forEach(System.out::println);
    }

    // limit(): Giới hạn k phần tử đầu tiên
    public static void limit(List<User> list) {
        list.stream().limit(2).forEach(System.out::println);
    }

    // map()
    public static void map(List<User> list) {
        list.stream()
                .filter(u -> u.getName().startsWith("A")) //
                .map(u -> u.getName().toUpperCase()) //
                .forEach(System.out::println);
    }

    // reverse list
    public static void reverse(List<User> list) {
        Collections.reverse(list);
        System.out.println(list);
    }

    // Sort
    public static void sort(List<User> list) {
        Comparator<User> comparing = Comparator.comparing(User::getName) //
                .thenComparing(User::getAge);
        list.sort(comparing); // Self sort
        // list.stream().sorted(comparing); // <- Return a new list
        list.forEach(System.out::println);
    }

    // allMatch(), anyMatch(), noneMatch()
    public static void match(List<User> list) {
        // Tất cả các phần tử đều thỏa điều kiện test
        boolean allMatch = list.stream().allMatch(u -> u.getAge() >= 5);
        System.out.println("allMatch: " + allMatch);

        // Có ít nhất 1 phần tử thỏa mãn điều kiện test
        boolean anyMatch = list.stream().anyMatch(u -> u.getName().startsWith("A"));
        System.out.println("anyMatch:  " + anyMatch);

        // Không có phần tử nào thỏa mãn điều kiện test
        boolean noneMatch = list.stream().noneMatch(u -> u.getAge() > 100);
        System.out.println("noneMatch: " + noneMatch);
    }

    // distinct(): Loại bỏ các phần tử trùng lặp trong Stream
    public static void distinct() {
        List<Integer> list = List.of(1, 1, 2, 2, 3, 3);
        List<Integer> distinct = list.stream().distinct().toList();
        System.out.println("distinct: " + distinct);
    }

    /**
     * Java 9+
     * dropWhile(): Bỏ qua các phần tử từ đầu Stream cho đến khi điều kiện test thành FALSE
     * (hoặc giữa lại các phần tử từ vị trí thỏa mãn điều kiện test)
     *
     * [_______Skip_______dropWhile(test=false)_______Get_______]
     */
    public static void dropWhile() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Loại bỏ những phần tử < 5 tính từ đầu Stream
        List<Integer> filter = numbers.stream().dropWhile(t -> t < 5).toList();
        System.out.println("dropWhile: " + filter);
    }

    /**
     * takeWhile(): Lấy các phần tử từ đầu Stream cho đến phần tử không thỏa điều kiện test.
     * Khi điều kiện test thành FALSE hàm takeWhile() sẽ dừng và trả về luồng chứa các phần
     * từ thỏa mãn điều kiện trước đó
     *
     * [_______Get_______takeWhile(test=false)_______Skip_______]
     */
    public static void takeWhile() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, -4, -5, 6, 7);
        // Lấy ra các số nguyên dương đầu tiên
        List<Integer> filter = numbers.takeWhile(t -> t > 0).toList();
        System.out.println("takeWhile: " + filter);
    }

    // filter(): Lọc dữ liệu
    public static void filter(List<User> list) {
        list.stream()
                .filter(u -> u.getName().startsWith("A"))
                .forEach(System.out::println);
    }

    // filter() + findAny() + findFist()
    public static void find(List<User> list) {
        // Filter
        List<User> filter = list.stream()
                .filter(user -> user.getName().startsWith("A"))
                .toList();
        // findAny
        Optional<User> findAny = filter.stream().findAny();
        // findFirst
        Optional<User> findFirst = filter.stream().findFirst();
        System.out.println("filter: " + filter);
        findAny.ifPresent(user -> System.out.println("findAny: " + user));
        findFirst.ifPresent(user -> System.out.println("findFirst: " + user));
    }

    public static void map() {
        int[] arr = {1, 2, 3, 4};
        List<Integer> list = List.of(1, 2, 3, 4);

        // mapToInt(): Chuyển Stream<Integer> -> IntStream
        int[] array = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // min(), max(): Tìm phần tử nhỏ nhất, lớn nhất trong Stream theo tiêu chí nào đó
    public static void min_max(List<User> list) {
        Optional<User> min = list.stream().min(Comparator.comparingInt(User::getAge));
        Optional<User> max = list.stream().max(Comparator.comparingInt(User::getAge));
        min.ifPresent(u -> System.out.println("Min by Age: " + u));
        max.ifPresent(u -> System.out.println("Max by Age: " + u));
    }

    /**
     * peek(): Thực hiện 1 hành động lên phần tử của Stream mà không làm ảnh hướng đến Stream.
     * Hàm này thường dùng để giám sát hoặc debuggìng
     */
    public static void peek() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        // Sử dụng peek để in ra mỗi phần tử và chuyển đổi thành số bình phương
        Stream<Integer> squaredNumbers = numbers
                .peek(num -> System.out.println("Original: " + num)) // Hàm này thì không
                .map(num -> num * num) // Hàm này thay đổi dữ liệu của Stream
                .peek(squaredNum -> System.out.println("Squared: " + squaredNum));
        // Kết quả: In ra mỗi số bình phương
        squaredNumbers.forEach(System.out::println);
    }

    /**
     * Có 2 loại
     */
    public static void reduce() {
        // Không có giá trị khởi tạo
        List<String> strings = List.of("one", "two", "three", "four", "five");
        Optional<String> reduceds = strings.stream()
                .reduce((acc, item) -> {
                    System.out.println(++i);
                    System.out.println("acc = " + acc);
                    System.out.println("item = " + item);
                    return acc + "-" + item;
                });
        System.out.println("reduceds: " + reduceds.get());

        // Có giá trị khởi tạo
        String reduce = strings.stream()
                .reduce("", (acc, item) -> {
                    System.out.println("acc = " + acc);
                    System.out.println("item = " + item);
                    return acc + " | " + item;
                });
        System.out.println("reduce: " + reduce);
    }

    public static void main(String[] args) {
        // reverse(list);

        List<User> list = User.sampleUsers();
        // filter(list);
        // find(list);
        // skip(list);
        // limit(list);
        // map(list);
        // sort(list);
        // match(list);
        // distinct();
        // dropWhile();
        takeWhile();
        // map();
        // min_max(list);
        // peek();
        // reduce();


//		// Stream.reduce()
//		Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "_" + s2);
//		reduced.ifPresent(out);
//
//		List<Integer> listInt = new ArrayList<Integer>();
//		for (int i = 1; i < 10; i++) {
//			listInt.add(i);
//		}

        // Here creating a parallel stream
//		Integer[] evenNumbers = listInt.stream().filter(t -> t % 2 == 0).toArray(Integer[]::new);
        // System.out.print(Arrays.stream(evenNumbers).collect(Collectors.toList()));
        // Stream.of(evenNumbers).forEach(out);
    }

    // count(): Đếm số phần tử trong Stream
//    public static void count(List<User> list) {
//        long count = list.stream().count();
//        System.out.println("count: " + count);
//    }

}
