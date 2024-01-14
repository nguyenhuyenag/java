package common.util;

import common.object.User;

import java.util.ArrayList;
import java.util.List;

public class ListData {

    public static List<User> users() {
        List<User> list = new ArrayList<>();
        list.add(new User("Huyen", 25));
        list.add(new User("Tran", 27));
        list.add(new User("Nguyet", 22));
        list.add(new User("Trang", 21));
        list.add(new User("Lac", 26));
        return list;
    }
}
