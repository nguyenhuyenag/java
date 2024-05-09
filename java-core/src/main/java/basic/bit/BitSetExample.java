package basic.bit;

import java.util.*;

public class BitSetExample {

    public static void main(String[] args) {
        // Khởi tạo một BitSet với kích thước 8 bit
        BitSet bitSet1 = new BitSet(8);

        // Thiết lập các bit tại các vị trí cụ thể
        bitSet1.set(1);
        bitSet1.set(3);
        bitSet1.set(5);

        // Hiển thị các bit đã được thiết lập
        System.out.println("BitSet1: " + bitSet1); // BitSet1: {1, 3, 5}

        // Khởi tạo một BitSet khác và thực hiện các phép toán bitwise
        BitSet bitSet2 = new BitSet(8);
        bitSet2.set(2);
        bitSet2.set(4);
        bitSet2.set(6);

        // AND
        bitSet1.and(bitSet2);
        System.out.println("BitSet1 AND BitSet2: " + bitSet1); // BitSet1 AND BitSet2: {}

        // OR
        bitSet1.or(bitSet2);
        System.out.println("BitSet1 OR BitSet2: " + bitSet1); // BitSet1 OR BitSet2: {2, 4, 6}

        // XOR
        bitSet1.xor(bitSet2);
        System.out.println("BitSet1 XOR BitSet2: " + bitSet1); // BitSet1 XOR BitSet2: {2, 4, 6}
    }

}
