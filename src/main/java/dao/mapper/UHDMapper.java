package dao.mapper;

import constants.FieldsConstants;
import entity.DiagnosisStatus;
import entity.UserHasDiagnosis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UHDMapper implements EntityMapper<UserHasDiagnosis> {
    @Override
    public UserHasDiagnosis map(ResultSet resultSet) throws SQLException {
        return new UserHasDiagnosis()
                .setUser_id(resultSet.getInt(FieldsConstants.UHD_USER_ID))
                .setDiagnosis_id(resultSet.getInt(FieldsConstants.UHD_DIAGNOSIS_ID))
                .setDate(resultSet.getString((FieldsConstants.UHD_DATE)))
                .setStatus(DiagnosisStatus.valueOf(resultSet.getString((FieldsConstants.UHD_STATUS))))
                .setTreat_id(resultSet.getInt(FieldsConstants.UHD_TREAT_ID));
    }

    @Override
    public int unMap(PreparedStatement statement, UserHasDiagnosis entity) throws SQLException {
        int index = 0;
        statement.setInt(index++,entity.getUser_id());
        statement.setInt(index++,entity.getDiagnosis_id());
        statement.setString(index++,entity.getDate());
        statement.setString(index++,String.valueOf(entity.getStatus()));
        statement.setInt(index++,entity.getTreat_id());
        return index;
    }
}
