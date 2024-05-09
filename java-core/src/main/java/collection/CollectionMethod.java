package collection;

import java.util.*;

/**
 * binarySearch()
 */
public class CollectionMethod {

    private static List<Integer> list = new ArrayList<>(List.of(1, 2, 1, 4, 1, 5));

    // addAll(): Thêm mới phần tử
    public static void addAll() {
        Collections.addAll(list, 5, 6, 7);
        System.out.println("addAll: " + Arrays.toString(list.toArray()));
    }

    // Kiểm tra 2 collection có phần tử chung hay không?
    public static void disjoint() {
        List<Integer> list2 = Arrays.asList(1, 2, 4, 6);
        System.out.println("disjoint: " + Collections.disjoint(list, list2));
    }

    // fill(): Tương tự Arrays.fill()
    public static void fill() {
        Collections.fill(list, 0);
        System.out.println("fill: " + Arrays.toString(list.toArray()));
    }

    // frequency(): Đếm số lần xuất hiện của một phần tử trong Collections
    public static void frequency() {
        Collections.frequency(list, 1);
    }

    // Tìm phần tử lớn nhất, nhỏ nhất của Collections (có thể sử dụng Comparator)
    public static void min_max() {
        Collections.min(list);
        Collections.min(list, Comparator.naturalOrder());
        Collections.max(list);
    }

    // Tạo List bằng cách copy N lần giá trị cho trước
    public static void nCopies() {
        List<String> newList = Collections.nCopies(5, "X");
        System.out.println("newList: " + Arrays.toString(newList.toArray()));
    }

    // Thay thế toàn bộ giá trị bằng một giá trị khác
    public static void replaceAll() {
        System.out.println("Before: " + Arrays.toString(list.toArray()));
        Collections.replaceAll(list, 1, -1);
        System.out.println("replaceAll: " + Arrays.toString(list.toArray()));
    }

    // Đảo ngược Collections
    public static void reverse() {
        Collections.reverse(list);
    }

    // Xoay Collections
    public static void rotate() {
        Collections.rotate(list, -1);   // Xoay thuận (dời đầu về cuối)
        Collections.rotate(list, 1);    // Xoay ngược (dời cuối lên đầu)
    }

    // Trộn mảng
    public static void shuffle() {
        Collections.shuffle(list);
    }

    // Sắp xếp
    public static void sort() {
        Collections.sort(list);
        Collections.sort(list, Comparator.naturalOrder());
    }

    // Đổi chỗ 2 giá trị bằng index
    private static void swap() {
        Collections.swap(list, 0, 1);
    }

    // Tạo Collections đồng bộ, an toàn với đa luồng
    private static void synchronizedCollections() {
        Collections.synchronizedList(list);
        // Collections.synchronizedMap(null);
        // Collections.synchronizedSet(null);
        // Collections.synchronizedCollection(list);
    }

    // Tạo collection read-only
    public static void unmodifiableCollection() {
        // Tương tự cho: Set, List, Map
        List<String> src = Collections.nCopies(5, "Java");
        Collection<String> collection = Collections.unmodifiableCollection(src);
        collection.add("A"); // => UnsupportedOperationException
    }

    public static void main(String[] args) {
        // addAll();
        // disjoint();
        // fill();
        // frequency();
        // min_max();
        // nCopies();
        // replaceAll();
        // reverse();
        // rotate();
        // rotate();
        // shuffle();
        // sort();
        // swap();
        // synchronized
        // synchronizedCollections();
        unmodifiableCollection();
    }

}
