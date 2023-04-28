package application.service;

import application.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(long id);
}
