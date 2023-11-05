package com.api.ProjectJDBC.domain.db.repository;

import com.api.ProjectJDBC.domain.db.DB;
import com.api.ProjectJDBC.domain.db.DbIntegrityException;
import com.api.ProjectJDBC.domain.entities.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;


    public void save(User user) {
        try {
            connection = DB.getConnection();
            String sql = "INSERT INTO tuser (name, email, password) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
    }

    public User update(User user) {
        try {
            connection = DB.getConnection();
            String sql = "UPDATE tuser SET name = ?, email = ?, password = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());

            statement.executeUpdate();

            return user;
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
    }


    public List<User> getAll() {
        try {
            connection = DB.getConnection();
            statement = connection.prepareStatement("SELECT * FROM tuser");

            resultSet = statement.executeQuery();

            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("name");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("password");
                new User(id, nome, email, senha);
                userList.add(new User(id, nome, email, senha));
            }

            return userList;

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }

    public User getById(Long id) {
        try {
            connection = DB.getConnection();
            statement = connection.prepareStatement(String.format("SELECT * FROM tuser  WHERE id = %d", id));

            resultSet = statement.executeQuery();
            resultSet.next();

            int userId = resultSet.getInt("id");
            String nome = resultSet.getString("name");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("password");

            return new User(userId, nome, email, senha);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }
    public void deleteById(long id) {
        try {
            connection = DB.getConnection();
            statement = connection.prepareStatement(String.format("DELETE FROM tuser  WHERE Id = %d", id));

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
    }

}
