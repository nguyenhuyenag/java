package trick;

import common.object.User;

import java.util.function.Consumer;

public class SetIfNotNull {

    private static <T> void setIfNotNull(Consumer<T> setter, T value) {
        if (value != null) {
            setter.accept(value);
        }
    }

    public static void main(String[] args) {
        User user = new User();
        setIfNotNull(user::setName, null);
        System.out.println(user);
        setIfNotNull(user::setName, "Java");
        System.out.println(user);
    }

}
