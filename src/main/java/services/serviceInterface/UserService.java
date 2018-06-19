package services.serviceInterface;

import entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(int id);
    List<User> getAll();
}
