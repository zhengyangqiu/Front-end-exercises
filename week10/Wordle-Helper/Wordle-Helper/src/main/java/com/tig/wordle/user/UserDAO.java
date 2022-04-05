package com.tig.wordle.user;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(Integer id);
    Integer addUserToTable(User user);
    Integer deleteUserById(Integer id);
    Integer updateUserById(Integer userId, User updatedUser);
}
