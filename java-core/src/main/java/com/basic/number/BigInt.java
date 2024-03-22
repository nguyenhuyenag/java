package com.basic.number;

import java.math.BigInteger;
import java.util.Arrays;

/*-
 *  abs(): Giá trị tuyệt đối
 *  negate(): Số đối
 *  nextProbablePrime(): Số nguyên tố gần nhất >= x
 *  bitCount(): Đếm số bit 1 trong biểu diễn nhị phân
 */
public class BigInt {

    public static void main(String[] args) {
        BigInteger n1 = new BigInteger("987654321");
        BigInteger n2 = new BigInteger("123456789");

        // Cộng
        BigInteger sum = n1.add(n2);
        System.out.println("Cộng: "+sum);

        // Trừ
        BigInteger subtract = n1.subtract(n2);
        System.out.println("Trừ: " + subtract);

        // Nhân
        BigInteger multiply = n1.multiply(n1);
        System.out.println("Nhân: " + multiply);

        // Chia thường

        // Chia nguyên (n1 / n2)
        BigInteger divide = n1.divide(n2);
        System.out.println("Divide: " + divide);

        // Chia dư (n1 % n2)
        BigInteger mod = n1.mod(n2);
        System.out.println("Mod: " + mod);

        // Tương tự mod() nhưng áp dụng cho cả số âm
        BigInteger remainder = n1.remainder(n2);
        System.out.println("Remainder: " + remainder);

        // Kết quả = [phần nguyên, phần dư]
        BigInteger[] divmod = n1.divideAndRemainder(n2);
        System.out.println("DivMod = " + Arrays.toString(divmod));

        // Lũy thừa
        BigInteger pow = n1.pow(2);
        System.out.println("Pow: " + pow);

    }

}
