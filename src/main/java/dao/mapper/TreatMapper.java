package dao.mapper;

import constants.FieldsConstants;
import entity.Treat;
import entity.TreatType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreatMapper implements EntityMapper<Treat> {
    @Override
    public Treat map(ResultSet resultSet) throws SQLException {
        return new Treat()
                .setId(resultSet.getInt(FieldsConstants.TREAT_ID))
                .setName(resultSet.getString(FieldsConstants.TREAT_NAME))
                .setCost(resultSet.getInt(FieldsConstants.TREAT_COST))
                .setDescribe(resultSet.getString(FieldsConstants.TREAT_DESCRIBE))
                .setType(TreatType.valueOf(resultSet.getString(FieldsConstants.TREAT_TYPE)));
    }

    @Override
    public int unMap(PreparedStatement statement, Treat entity) throws SQLException {
        int index = 0;
        statement.setString(index++,entity.getName());
        statement.setInt(index++,entity.getCost());
        statement.setString(index++,entity.getDescribe());
        statement.setString(index++,String.valueOf(entity.getType()));
        return index;
    }
}
