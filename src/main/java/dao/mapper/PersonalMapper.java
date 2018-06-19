package dao.mapper;

import constants.FieldsConstants;
import entity.Personal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalMapper implements EntityMapper<Personal> {
    @Override
    public Personal map(ResultSet resultSet) throws SQLException {
        return new Personal()
                .setId(resultSet.getInt(FieldsConstants.PERSONAL_ID))
                .setEmail(resultSet.getString(FieldsConstants.PERSONAL_EMAIL))
                .setLogin(resultSet.getString(FieldsConstants.PERSONAL_LOGIN))
                .setName(resultSet.getString(FieldsConstants.PERSONAL_NAME))
                .setPassword(resultSet.getString(FieldsConstants.PERSONAL_PASSWORD))
                .setPhone(resultSet.getString(FieldsConstants.PERSONAL_PHONE))
                .setProf_id(resultSet.getInt(FieldsConstants.PERSONAL_PROF_ID));
    }

    @Override
    public int unMap(PreparedStatement statement, Personal entity) throws SQLException {
        int index = 0;
        statement.setString(++index,entity.getName());
        statement.setString(++index,entity.getEmail());
        statement.setString(++index,entity.getLogin());
        statement.setString(++index,entity.getPassword());
        statement.setString(++index,entity.getPhone());
        statement.setInt(++index,entity.getProf_id());
        return index;
    }
}
