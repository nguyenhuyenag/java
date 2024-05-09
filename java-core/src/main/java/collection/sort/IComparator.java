package collection.sort;

import common.object.User;
import common.util.ListData;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * naturalOrder(): Comparator tự nhiên của dữ liệu (Kiểu String là thứ tự trên chữ cái,...)
 */
public class IComparator {

    public static List<User> list = ListData.users();

    public static void show() {
        for (User u : list) {
            System.out.println(u);
        }
    }

    public static void compare() {
        // Collections.sort(list, new Comparator<User>() {
        //      @Override
        //      public int compare(User u1, User u2) {
        //           return u1.getAge() - u2.getAge();
        //      }
        // });

        // Sort kiểu int tăng dần, giảm dần
        Collections.sort(list, (u1, u2) -> u1.getAge() - u2.getAge());
        // Collections.sort(list, (u1, u2) -> u2.getAge() - u1.getAge());

        // Sort kiểu String tăng dần, giảm dần
        // Collections.sort(list, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        // Collections.sort(list, (u1, u2) -> u2.getName().compareTo(u1.getName()));

        show();
    }

    // comparing(Function<>, Comparator<>)
    public static void comparing() {
        // So sánh thuận
        // Collections.sort(list, Comparator.comparing(User::getAge));

        // So sánh ngược
        Collections.sort(list, Comparator.comparing(User::getAge).reversed());
        // Collections.sort(list, Comparator.comparing(User::getName, Comparator.reverseOrder()));

        // Tổng quát: So sánh name và tiêu chí của name (độ dài, thứ tự tự nhiên,...)
        Comparator<User> userNameComparator
                = Comparator.comparing(u -> u.getName(), (s1, s2) -> {
                    return s2.compareTo(s1);
                });
        // Collections.sort(list, userNameComparator);

        show();
    }

    // Tương tự cho Long, Double
    public static void comparingInt() {
        List<String> words = Arrays.asList("is2", "Thi1s", "T4est", "3a");
        System.out.println("Before: " + String.join(" ", words));
        Collections.sort(words, Comparator.comparingInt(s -> {
            String intNumber = s.replaceAll("\\D", "");
            return intNumber.isEmpty() ? 0 : Integer.parseInt(intNumber);
        }));
        System.out.println("After: " + String.join(" ", words));
    }

    /**
     * Sắp xếp, nếu có giá trị null thì đẩy lên đầu
     *
     * Tương tự có nullsLast()
     */
    public static void nullsFirst() {
        List<String> strings = Arrays.asList("apple", "orange", null, "banana", null, "grape");
        strings.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(strings);
    }

    /**
     * reversed(): Đảo ngược comparator hiện tại (trả về 1 Comparator mới)
     *
     * reverseOrder(): Trả về một comparator đảo ngược lại so với thứ tự tự nhiên của chúng
     *
     * => Điểm khác: reversed() cần phải có 1 Comparator có sẵn còn reverseOrder() thì không cần
     */
    public static void reversedAndreverseOrder() {
        List<String> strings = Arrays.asList("apple", "orange", "banana", "grape");

        // reversed()
        Comparator<String> naturalOrder = Comparator.naturalOrder();
        Comparator<String> reversedComparator = naturalOrder.reversed();
        strings.sort(reversedComparator);

        // reverseOrder(): Sắp xếp chuỗi theo thứ tự ngược lại
        strings.sort(Comparator.reverseOrder());

        System.out.println(strings);
    }

    /**
     * Sắp xếp theo nhiều tiêu chí
     *
     * thenComparing(Function, Comparator)
     */
    public static void thenComparing() {
        // Sắp xếp theo tuổi, nếu tuổi bằng nhau, sắp xếp theo tên
        Comparator<User> comparator = Comparator.comparing(User::getAge)
                                                .thenComparing(User::getName);
        list.sort(comparator);
        show();
    }

    public static void main(String[] args) {
        // comparingInt();
        // compare();
        // comparing();
        // nullsFirst();
        // reversedAndreverseOrder();
        thenComparing();
    }

}
