package com.tig.wordle.user;

import com.tig.wordle.words.WordDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;


    public UserService(@Qualifier("user") UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    //loops through all the users and sees if there is a user matching the given id
    public boolean doesUserWithIdExists(Integer id) {
        return userDAO
                .getAllUsers()
                .stream()
                .anyMatch(p -> p.getId().equals(id));  // returns boolean
    }

    public User selectUserByID(Integer userId) {
        boolean exists = doesUserWithIdExists(userId);
        if (exists == false) {
            throw new UserNotFoundException("User with ID " + userId + " does not exist");
        }
        User user = userDAO.getUserById(userId);
        return user;
    }

    public List<User> getAllUsers() {
        if(userDAO.getAllUsers().size() == 0) {
            throw new UserNotFoundException("No users found");
        }
        else return userDAO.getAllUsers();
    }

    public Integer addUserToTable(User user) {
        if (user.getName() != null
                && user.getUserName() != null
                && user.getEmail() != null
                && user.getName() != ""
                && user.getUserName() != ""
                && user.getEmail() != "") {
            return userDAO.addUserToTable(user);
        } else {
            throw new InputMissingException("Invalid entry. Fields cannot be empty");
        }
    }

    public Integer deleteUserById(Integer userId) {
        boolean exists = doesUserWithIdExists(userId);
        if (exists == false) {
            throw new UserNotFoundException("User with ID " + userId + " does not exist");
        }
        int result = userDAO.deleteUserById(userId);
        return result;
    }


    public Integer updateUserByID(Integer userId, User updatedUser) {
        boolean exists = doesUserWithIdExists(userId);
        if (exists == false) {
            throw new UserNotFoundException("User with ID " + userId + " does not exist");
        }
        if (updatedUser.getName() != null
                && updatedUser.getEmail() != null
                && updatedUser.getUserName() != null
                && updatedUser.getName() != ""
                && updatedUser.getEmail() != ""
                && updatedUser.getUserName() != "") {
            return userDAO.updateUserById(userId, updatedUser);
        } else throw new InputMissingException("Invalid entry. Fields cannot be empty");

    }
}
