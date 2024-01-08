package order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Thực thi các test method theo tên, lưu ý là nó ( phân biệt chữ hoa và chữ thường, nên các ký tự hoa sẽ ưu tiên chạy trước ký tự thường
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class AlphaNumeric {

    private static StringBuilder output = new StringBuilder();

    @Test
    public void aTest() {
        output.append("a");
    }

    @Test
    public void bTest() {
        output.append("b");
    }

    @Test
    public void cTest() {
        output.append("c");
    }

    @AfterAll
    public static void assertOutput() {
        assertEquals(output.toString(), "abc");
    }

}
