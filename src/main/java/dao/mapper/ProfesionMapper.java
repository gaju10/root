package dao.mapper;


import constants.FieldsConstants;
import entity.Profesion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesionMapper implements EntityMapper<Profesion> {
    @Override
    public Profesion map(ResultSet resultSet) throws SQLException {
        return new Profesion()
                .setId(resultSet.getInt(FieldsConstants.PROFESION_ID))
                .setName(resultSet.getString(FieldsConstants.PROFESION_NAME))
                .setType(resultSet.getString((FieldsConstants.PROFESION_TYPE)));
    }

    @Override
    public int unMap(PreparedStatement statement, Profesion entity) throws SQLException {
        int index = 0;
        statement.setString(++index,entity.getName());
        statement.setString(++index,entity.getType());
        return index;
    }
}
