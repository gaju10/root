package dao.mapper;

import constants.FieldsConstants;
import entity.PersonalHasUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PHUMapper implements EntityMapper<PersonalHasUser> {
    @Override
    public PersonalHasUser map(ResultSet resultSet) throws SQLException {
        return new PersonalHasUser()
                .setPersonal_id(resultSet.getInt(FieldsConstants.PHS_PERSONAL_ID))
                .setUser_id(resultSet.getInt(FieldsConstants.PHS_USER_ID))
                .setDate(resultSet.getString((FieldsConstants.PHS_DATE)));
    }

    @Override
    public int unMap(PreparedStatement statement, PersonalHasUser entity) throws SQLException {
        int index = 0;
        statement.setInt(index++,entity.getPersonal_id());
        statement.setInt(index++,entity.getUser_id());
        statement.setString(index++,entity.getDate());
        return index;
    }
}
