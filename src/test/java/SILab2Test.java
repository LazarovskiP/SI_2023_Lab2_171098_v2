import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testFunctionByEveryBranch()
    {

        List<User> allUsers = new ArrayList<>();
        User user = new User("pavel", null, "171098@hotmail.com");
        List<User> finalAllUsers = allUsers;
        User finalUser = user;
        assertThrows(RuntimeException.class, () -> SILab2.function(finalUser, finalAllUsers));


        allUsers = new ArrayList<>();
        user = new User(null, "password", "171098@hotmail.com");
        SILab2.function(user, allUsers);
        assertEquals("171098@hotmail.com", user.getUsername());

        allUsers = new ArrayList<>();
        user = new User("pavel", "password", "171098@hotmail.com");
        boolean result = SILab2.function(user, allUsers);
        assertFalse(result);


        allUsers = new ArrayList<>();
        user = new User("pavel", "pass", "171098@hotmail.com");
        result = SILab2.function(user, allUsers);
        assertFalse(result);

        allUsers = new ArrayList<>();
        user = new User("pavel", "pass word", "171098@hotmail.com");
        result = SILab2.function(user, allUsers);
        assertFalse(result);

        allUsers = new ArrayList<>();
        user = new User("pavel", "password!", "171098@hotmail.com");
        result = SILab2.function(user, allUsers);
        assertTrue(result);
    }

    @Test
    void testByMultipleConditon()
    {

        List<User> allUsers = new ArrayList<>();
        User user = null;
        User finalUser = user;
        List<User> finalAllUsers = allUsers;
        assertThrows(RuntimeException.class, () -> SILab2.function(finalUser, finalAllUsers));


        allUsers = new ArrayList<>();
        user = new User("pavel", null, "171098@test.com");
        User finalUser1 = user;
        List<User> finalAllUsers1 = allUsers;
        assertThrows(RuntimeException.class, () -> SILab2.function(finalUser1, finalAllUsers1));


        allUsers = new ArrayList<>();
        user = new User("pavel", "password", null);
        User finalUser2 = user;
        List<User> finalAllUsers2 = allUsers;
        assertThrows(RuntimeException.class, () -> SILab2.function(finalUser2, finalAllUsers2));

        allUsers = new ArrayList<>();
        user = new User("pavel", "password", "171098@test.com");
        boolean result = SILab2.function(user, allUsers);
        assertFalse(result);
    }
}