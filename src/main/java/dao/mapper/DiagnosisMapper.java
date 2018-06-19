package dao.mapper;

import constants.FieldsConstants;
import entity.Diagnosis;
import entity.DiagnosisStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisMapper implements EntityMapper<Diagnosis> {
    @Override
    public Diagnosis map(ResultSet resultSet) throws SQLException {
        return new Diagnosis()
                .setId(resultSet.getInt(FieldsConstants.DIAGNOSIS_ID))
                .setName(resultSet.getString(FieldsConstants.DIAGNOSIS_NAME))
                .setTips(resultSet.getString(FieldsConstants.DIAGNOSIS_TIP));
    }

    @Override
    public int unMap(PreparedStatement statement, Diagnosis entity) throws SQLException {
        int index = 0;
        statement.setString(++index,entity.getName());
        statement.setString(++index,entity.getTips());
        return index;
    }
}
