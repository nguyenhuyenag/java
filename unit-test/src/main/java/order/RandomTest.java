package order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Thực thi ngẫu nhiên các test method ở mỗi lần chạy
 */
@TestMethodOrder(MethodOrderer.Random.class)
public class RandomTest {

    @Test
    void test5() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test2() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test4() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test3() {
        assertEquals(2, 1 + 1);
    }

}
