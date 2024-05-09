package collection.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Stack (ngăn xếp): Hoạt động theo cơ chế LIFO (last in first out)
 *
 * Các phương thức của Stack
 *
 * push()		-> 	Thêm phần từ vào đầu stack
 * peek() 		-> 	Lấy ra nhưng không xóa phần từ ở đầu stack
 * pop() 		-> 	Lấy ra và xóa phần từ ở đầu stack
 * search()	->	Trả về vị trí của phần từ cần tìm hoặc -1 nếu không có
 * empty()		->	Kiểm tra stack rỗng
 */
public class StackApi {

    // Duyệt stack từ dưới lên (trái -> phải)
    public static void forLoop() {
        Stack<Integer> stack = new Stack<>();
        Collections.addAll(stack, 0, 1, 2, 5, 3, 4, 5);
        stack.forEach(System.out::println);
    }

    public static void stackApi() {
        Stack<Integer> stack = new Stack<>();
        Collections.addAll(stack, 0, 1, 2, 5, 3, 4, 5);

        System.out.println("Stack: " + stack);

        // Duyệt stack từ dưới lên
        // forLoop();

        // Thêm phần tử vào đỉnh
        stack.push(0); // stack.add(1)

        // Insert at index
        stack.add(0, 1000);

        // Lấy giá trị của phần tử ở đỉnh
        stack.peek();

        // Lấy & xóa phần tử ở đỉnh, EmptyStackException nếu stack rỗng
        stack.pop();

        // Kiểm tra stack rỗng
        stack.empty();

        // Tìm vị trí tính từ đỉnh (bắt đầu từ 1) của phần tử cần tìm. Trả về -1 nếu không tìm thấy
        int keySearch = 5;
        System.out.println("Search: " + stack.search(keySearch));

        stack.add(1);

    }

    public static void main(String[] args) {
        stackApi();
    }

}
