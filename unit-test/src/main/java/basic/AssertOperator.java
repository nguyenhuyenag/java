package basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertOperator {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals(true, true);
        assertArrayEquals(new int[]{1, 1, 3}, new int[]{1, 1, 3});
        assertIterableEquals(List.of(1, 2, 3), List.of(1, 2, 3));
    }

    /**
     * Kiểm tra nhiều điều kiện khác nhau trong một test case
     */
    @Test
    void testMultipleAssertions() {
        String firstName = "John";
        String lastName = "Doe";
        assertAll("name",
                () -> assertEquals("John", firstName),
                () -> assertEquals("Doe", lastName)
        );
    }

    /**
     * Kiểm tra xem 2 list có khớp nhau hay không với regex
     */
    @Test
    void linesMatchPositive() {
        List<String> expected = Arrays.asList("Java", "\\d+", ".*");
        List<String> actual = Arrays.asList("Java", "11", "JUnit");
        assertLinesMatch(expected, actual);
    }

}
