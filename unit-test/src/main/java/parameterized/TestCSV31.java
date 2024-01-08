package parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/525f4206b73515bffb000b21
 *
 * Cộng, trừ 2 số lớn
 *
 * Xem thêm: SumStringsAsNumbers.java
 */
public class TestCSV31 {

    public static String leftPad(String str, int maxLen) {
        int numZeros = Math.max(0, maxLen - str.length());
        return "0".repeat(numZeros) + str;
    }

    public static int[] toStringArray(String numStr) {
        return numStr.chars().map(Character::getNumericValue).toArray();
    }

    public static String add(String x, String y) {
        int maxLen = Math.max(x.length(), y.length());

        int[] A = toStringArray(leftPad(x, maxLen));
        int[] B = toStringArray(leftPad(y, maxLen));

        int carry = 0; // Số nhớ
        StringBuilder ans = new StringBuilder();

        for (int i = maxLen - 1; i >= 0; i--) {
            int sum = (A[i] + B[i]) + carry;
            carry = sum / 10;       // sum < 10 thì carry = 0, sum >= 10 thì carry = 1
            ans.append(sum % 10);   // Chèn 9 vào
        }

        // Nếu ở cuối vòng lặp mà vẫn còn nhớ
        if (carry > 0) {
            ans.append(carry);
        }

        // Xóa số 0 vô nghĩa ở đầu số 0123 -> 123
        String result = ans.reverse().toString().replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }

    /**
     * Trừ hai số a - b với a > b
     */
    public static String subtract(String x, String y) {
        int maxLen = Math.max(x.length(), y.length());

        int[] A = toStringArray(leftPad(x, maxLen));
        int[] B = toStringArray(leftPad(y, maxLen));

        // System.out.println("arr1 = " + Arrays.toString(A));
        // System.out.println("arr2 = " + Arrays.toString(B));

        int borrow = 0; // Số mượn
        StringBuilder ans = new StringBuilder();

        for (int i = maxLen - 1; i >= 0; i--) {
            A[i] -= borrow; // Nếu bước phía trước có mượn thì trừ vào số hiện tại
            int sub = A[i] >= B[i] ? A[i] - B[i] : 10 + A[i] - B[i];
            ans.append(sub);
            borrow = A[i] < B[i] ? 1 : 0; // Nếu số nhỏ - số lớn thì mượn 1
        }

        String result = ans.reverse().toString().replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "1,     1,      2",
        "123,   456,    579",
        "888,   222,    1110",
        "1372,  69,     1441",
        "12,    456,    468",
        "100,   101,    201",
        "63829983432984289347293874, 90938498237058927340892374089, 91002328220491911630239667963"
    })
    @DisplayName("Test add()")
    public void addTest(String a, String b, String expected) {
        assertEquals(expected, add(a, b));
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
        "1,     1,      0",
        "456,   123,    333",
        "888,   222,    666",
        "1372,  69,     1303",
        "456,    12,    444",
        "101,   100,    1",
        "90938498237058927340892374089, 63829983432984289347293874, 90874668253625943051545080215"
    })
    @DisplayName("Test subtract()")
    public void subtractTest(String a, String b, String expected) {
        assertEquals(expected, subtract(a, b));
    }

}
