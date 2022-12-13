package com.socialmedia.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.socialmedia.model.User;

public class JdbcUserRepository implements UserRepository {

    private final Connection connection;
    private static final String FIND_USER_SQL = "select login, password from users";
    private static final String GET_USER_SQL = "select login, password from users where login = ?";
    private static final String CREATE_USER_SQL = "insert into users (login, password) values (?, ?)";
    private static final String FIND_USER_STARTS_WITH_SQL =
            "select login, password from users where login like concat('%', ?, '%')";

    public JdbcUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findUsers() {
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(FIND_USER_SQL);
            final List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(buildUser(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> getUser(String login) {
        try (PreparedStatement statement = connection.prepareStatement(GET_USER_SQL)){
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.of(buildUser(rs));
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(String login, String password) {
        try(PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL)) {
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User buildUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("login"),
                rs.getString("password")
        );
    }

    public List <User> findUsersStartWith (String login) {
        try(PreparedStatement statement = connection.prepareStatement(FIND_USER_STARTS_WITH_SQL)){
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            final List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(buildUser(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
