package by.ttre16.enterprise.service.util;

import by.ttre16.enterprise.model.Role;
import by.ttre16.enterprise.model.User;

import java.util.*;

import static by.ttre16.enterprise.util.RoleUtil.getRoleAdmin;
import static by.ttre16.enterprise.util.RoleUtil.getRoleUser;

public class UserTestData extends TestData {
    public static final Map<Integer, User> USERS = new HashMap<>();
    public static final String NOT_FOUND_EMAIL = "mail@mail.com";
    public static final Role ROLE_USER = getRoleUser();
    public static final Role ROLE_ADMIN = getRoleAdmin();

    static {
        USERS.put(USER_ID, new User(1, "simple_user", "test@gmail.com",
                "password", true, Collections.singletonList(ROLE_USER)));

        USERS.put(ADMIN_ID, new User(2, "admin", "admin@mail.com",
                "password88-2", true, Arrays.asList(ROLE_USER, ROLE_ADMIN)));
    }

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", false,
                new Date(), Collections.singletonList(ROLE_USER), 1230);
    }

    public static User getUpdated(Integer id) {
        User updated = new User(USERS.get(id));
        updated.setName("UpdatedName");
        updated.setCaloriesPerDay(330);
        return updated;
    }

    public static void assertMatch(User expected, User actual) {
        AssertUtil.assertMatch(expected, actual, "roles", "registered");
    }

    public static void assertMatch(Iterable<User> expected,
            Iterable<User> actual) {
        AssertUtil.assertMatch(expected, actual, "registered", "roles");
    }
}

