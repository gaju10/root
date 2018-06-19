package dao.mapper;

import constants.FieldsConstants;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements EntityMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        return new User()
                .setId(resultSet.getInt(FieldsConstants.USER_ID))
                .setLogin(resultSet.getString(FieldsConstants.USER_LOGIN))
                .setPassword(resultSet.getString(FieldsConstants.USER_PASSWORD))
                .setName(resultSet.getString(FieldsConstants.USER_NAME))
                .setBirthday(resultSet.getString(FieldsConstants.USER_BIRTHDAY))
                .setEmail(resultSet.getString(FieldsConstants.USER_EMAIL))
                .setGender(resultSet.getString(FieldsConstants.USER_GENDER))
                .setPhone(resultSet.getString(FieldsConstants.USER_PHONE));
    }

    @Override
    public int unMap(PreparedStatement statement, User entity) throws SQLException {
        int index = 0;
        statement.setString(index++,entity.getBirthday());
        statement.setString(index++,entity.getEmail());
        statement.setString(index++,entity.getGender());
        statement.setString(index++,entity.getLogin());
        statement.setString(index++,entity.getName());
        statement.setString(index++,entity.getPassword());
        statement.setString(index++,entity.getPhone());
        return index;
    }
}
