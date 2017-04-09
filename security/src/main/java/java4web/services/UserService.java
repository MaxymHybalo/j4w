package java4web.services;

import java4web.entity.User;

public interface UserService {
    void save(User user);
    User getByName(String name);
    String findRole(String name);
}
