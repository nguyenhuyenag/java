package instance;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class OrderUnitTest {

    @Test
    @Order(2)
    void firstTest() {
        System.out.println("22222");
    }

    @Test
    @Order(1)
    void secondTest() {
    	System.out.println("11111");
    }

}
