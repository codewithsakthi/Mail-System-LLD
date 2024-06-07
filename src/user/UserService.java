package user;

import java.util.*;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public boolean signUp(String email, String password, String name) {
        if (users.containsKey(email)) {
            return false;
        }
        String userId = generateUserId();
        User user = new User(userId, email, password, name);
        users.put(email, user);
        return true;
    }

    private String generateUserId() {
        return "user" + (users.size() + 1);
    }

    public boolean signIn(String email, String password) {
        User user = users.get(email);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

}
