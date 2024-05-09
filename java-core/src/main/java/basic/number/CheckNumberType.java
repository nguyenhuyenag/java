package basic.number;

import java.util.List;

public class CheckNumberType {

    public static void checkIntergerType() {
        final List<Object> list = List.of(1, 2, "aasf", "1", "123", 123);
        for (Object obj : list) {
            System.out.println("%s -> %s".formatted(obj, Integer.class.isInstance(obj)));
        }
    }

    public static void main(String[] args) {
        checkIntergerType();
    }

}
