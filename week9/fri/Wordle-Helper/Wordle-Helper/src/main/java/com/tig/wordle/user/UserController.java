package com.tig.wordle.user;

import com.tig.wordle.words.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers () {
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getUserByID(@PathVariable("userId") Integer userId){
        return userService.selectUserByID(userId);
    }

    @PostMapping
    public Integer addUserToTable(@RequestBody User user) {
        return userService.addUserToTable(user);
    }

    @DeleteMapping("{userId}")
    public Integer deleteUserByID(@PathVariable("userId") Integer userId){
        return userService.deleteUserById(userId);
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User updatedUser) {
        userService.updateUserByID(userId, updatedUser);
    }
}
