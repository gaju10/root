package dao.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapper<T> {
    T map(ResultSet resultSet) throws SQLException;

    int unMap(PreparedStatement statement, T entity) throws SQLException;
}
