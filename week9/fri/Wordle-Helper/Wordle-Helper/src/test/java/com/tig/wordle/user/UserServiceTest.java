package com.tig.wordle.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserServiceTest {
    private UserService underTest;
    private UserDAO userDAO;

    @BeforeEach
    void setUp(){
        this.userDAO = Mockito.mock(UserDAO.class);
        this.underTest = new UserService(userDAO);
    }

    @Test
    void canGetAllUsers () {
    // Given
        User user1 = new User(1,"user1","user1email", "user1name");
        User user2 = new User(2,"user2","user2email", "user2name");
        User user3 = new User(3,"user3","user3email", "user3name");
        User user4 = new User(4,"user4","user4email", "user3name");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        given(userDAO.getAllUsers()).willReturn(userList);
    // When
        List <User> actual = underTest.getAllUsers();

    //Then
        List <User> expected = userList;
        assertThat(actual).isEqualTo(expected);


    }

//need to test exceptions for this!!!!
    @Test
    void canGetUserById () {
        // Given
        User user1 = new User(1,"user1","user1email", "user1name");
        User user2 = new User(2,"user2","user2email", "user2name");
        User user3 = new User(3,"user3","user3email", "user3name");
        User user4 = new User(4,"user4","user4email", "user4name");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        given(userDAO.getAllUsers()).willReturn(userList);

        given(userDAO.getUserById(2)).willReturn(user2);
        // When
        User actual = underTest.selectUserByID(2);

        //Then
        User expected = user2;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canThrowExceptionWhenGettingUserWithIdWhichDoesntExist () {
        // Given
        User user1 = new User(1,"user1","user1email", "user1name");
        User user2 = new User(2,"user2","user2email", "user2name");
        User user3 = new User(3,"user3","user3email", "user3name");
        User user4 = new User(4,"user4","user4email", "user4name");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        given(userDAO.getAllUsers()).willReturn(userList);

        assertThatThrownBy(() -> {
            underTest.selectUserByID(20);}
        ).hasMessage("User with ID 20 does not exist");
    }

}


