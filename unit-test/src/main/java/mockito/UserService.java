package mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, List<User>> findAndGroupUserByName(String tx) {
        List<User> users = userRepository.findAll();

        List<User> filter = new ArrayList<>();
        for (User user: users) {
            if (user.getName().startsWith(tx)) {
                filter.add(user);
            }
        }

        return filter.stream().collect(Collectors.groupingBy(User::getName));
    }
}
