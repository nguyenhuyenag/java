package mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserService(userRepository);

    @BeforeEach
    public void beforeEach() {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "Hai"));
        users.add(new User("2", "Hieu"));
        users.add(new User("3", "oanh"));
        users.add(new User("4", "Hai"));
        Mockito.when(userRepository.findAll()).thenReturn(users);
    }

    @Test
    public void findAndGroupUserByNameTest() {
        Map<String, List<User>> map = userService.findAndGroupUserByName("H");
        Assertions.assertNotNull(map);
        Assertions.assertEquals(map.size(), 2);
        Assertions.assertEquals(map.get("Hai").size(), 2);
        Assertions.assertEquals(map.get("Hieu").size(), 1);
    }
}


