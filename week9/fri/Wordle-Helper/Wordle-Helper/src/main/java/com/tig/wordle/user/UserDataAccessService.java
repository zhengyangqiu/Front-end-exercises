package com.tig.wordle.user;

import com.tig.wordle.words.Word;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("user")
public class UserDataAccessService implements UserDAO{
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("username")
        );
        return user;
    };
    public UserDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT id,name,email,username FROM users ORDER BY id";
        List <User> userList = jdbcTemplate.query(sql,userRowMapper);
        return userList;
    }

    @Override
    public User getUserById(Integer id) {
        String sql = """
                SELECT id, name, email, username
                FROM users where id=?
                """;
        User userById = jdbcTemplate.query(sql, userRowMapper, id).get(0);
        return userById;
    }

    @Override
    public Integer addUserToTable(User user) {
        String sql = """
                INSERT INTO users(name, email, username)
                VALUES(?,?,?)
                """;

        int rowsAffected = jdbcTemplate.update(
                sql,
                user.getName(),
                user.getEmail(),
                user.getUserName()
        );
        return rowsAffected;
    }

    @Override
    public Integer deleteUserById(Integer id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Integer updateUserById(Integer userId, User updatedUser) {
       String sql = """
               UPDATE users SET (name, email, username) = (?,?,?)
               WHERE id = ?
               """;
        int rowsAffected = jdbcTemplate.update(
                sql,
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getUserName(),
                userId
        );
        return rowsAffected;
    }
}
