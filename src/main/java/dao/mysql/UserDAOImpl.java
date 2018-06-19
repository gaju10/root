package dao.mysql;

import constants.QueryConstants;
import dao.UserDAO;
import dao.mapper.UserMapper;
import entity.User;
import transaction.ThreadLocalHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User create(User entity) {
        UserMapper userMapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_CREATE, PreparedStatement.RETURN_GENERATED_KEYS)){
            userMapper.unMap(statement,entity);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) entity.setId(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public User get(int id) {
        UserMapper userMapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_GET)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = userMapper.map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        UserMapper userMapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(userMapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User entity) {
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_UPDATE)) {
            int index = mapper.unMap(statement, entity);
            statement.setInt(++index, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.USER_DELETE)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
