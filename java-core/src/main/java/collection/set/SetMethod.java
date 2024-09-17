package collection.set;

import java.util.*;

import common.util.RandomUtils;
import org.apache.commons.collections4.CollectionUtils;

public class SetMethod {

    static List<Integer> list = RandomUtils.getListInteger(5, 0, 5);

    public static void iSet() {
        System.out.println("List:\t\t" + Arrays.toString(list.toArray()));

        Set<Integer> set = new HashSet<>(list); // không thứ tự
        System.out.println("Set:\t\t" + set);

        Set<Integer> treeSet = new TreeSet<>(list); // tự động tăng
        System.out.println("TreeSet:\t" + treeSet);

        // Collections.reverseOrder()
        Set<Integer> tree = new TreeSet<>(Comparator.reverseOrder()); // đảo ngược
        tree.addAll(list);
        System.out.println("Reverse:\t" + tree);

        Set<Integer> linked = new LinkedHashSet<>(list); // theo thứ tự chèn
        System.out.println("LinkedHashSet:\t" + linked);
    }

    /**
     * Các phép toán trên tập hợp
     */
    public void setOperator() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // Create copies of both sets
        Set<String> uncommon = new HashSet<>(set1);
        Set<String> temp = new HashSet<>(set2);

        // Remove common elements from both sets
        uncommon.removeAll(set2);
        temp.removeAll(set1);

        // Add remaining elements from temp to uncommon
        uncommon.addAll(temp);

        System.out.println(uncommon);

    }

    public static void findUncommon1() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // Tim phan tu chung
        Set<String> common = new HashSet<>(set1);
        common.retainAll(set2); // Find common elements

        // Remove common elements from both sets
        set1.removeAll(common);
        set2.removeAll(common);

        // Add all remaining elements together
        set1.addAll(set2);
    }

    private <T> Set<T> findUncommon2(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        for (T element : b) {
            // .add() returns false if element already exists
            if (!result.add(element)) {
                result.remove(element);
            }
        }
        return result;
    }

    public static void findUncommon3() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Collection<String> disjunction = CollectionUtils.disjunction(set1, set2);
        System.out.println(disjunction);
    }

    public static void main(String[] args) {
        // iSet();
        findUncommon1();
    }
}
