package dao.mysql;

import constants.QueryConstants;
import dao.DiagnosisDAO;
import dao.mapper.DiagnosisMapper;
import dao.mapper.PersonalMapper;
import entity.Diagnosis;
import transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisDAOImpl implements DiagnosisDAO {
    @Override
    public Diagnosis create(Diagnosis entity) {
        DiagnosisMapper mapper = new DiagnosisMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement= connection.prepareStatement(QueryConstants.DIAGNOSIS_CREATE, Statement.RETURN_GENERATED_KEYS)){
            mapper.unMap(statement,entity);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;

    }

    @Override
    public Diagnosis get(int id) {
        DiagnosisMapper mapper = new DiagnosisMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        Diagnosis diagnosis = null;
        try(PreparedStatement statement = connection.prepareStatement(QueryConstants.DIAGNOSIS_GET)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            diagnosis = mapper.map(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosis;
    }

    @Override
    public List<Diagnosis> getAll() {
        DiagnosisMapper mapper = new DiagnosisMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        List<Diagnosis> diagnoses = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.DIAGNOSIS_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                diagnoses.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnoses;
    }

    @Override
    public void update(Diagnosis entity) {
        DiagnosisMapper mapper = new DiagnosisMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.DIAGNOSIS_UPDATE)) {
            int index = mapper.unMap(statement, entity);
            statement.setInt(++index, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Diagnosis entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.DIAGNOSIS_DELETE)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
