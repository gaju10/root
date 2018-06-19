package dao.mysql;

import constants.QueryConstants;
import dao.ProfesionDAO;
import dao.mapper.ProfesionMapper;
import entity.Profesion;
import transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesionDAOImpl implements ProfesionDAO {
    @Override
    public Profesion create(Profesion entity) {
        ProfesionMapper mapper = new ProfesionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement= connection.prepareStatement(QueryConstants.PROFESION_CREATE, Statement.RETURN_GENERATED_KEYS)){
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
    public Profesion get(int id) {
        ProfesionMapper mapper = new ProfesionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        Profesion profesion = null;
        try(PreparedStatement statement = connection.prepareStatement(QueryConstants.PROFESION_GET)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            profesion = mapper.map(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesion;

    }

    @Override
    public List<Profesion> getAll() {
        ProfesionMapper mapper = new ProfesionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        List<Profesion> profesions = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.PROFESION_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                profesions.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesions;
    }

    @Override
    public void update(Profesion entity) {
        ProfesionMapper mapper = new ProfesionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.PROFESION_UPDATE)) {
            int index = mapper.unMap(statement, entity);
            statement.setInt(++index, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Profesion entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.PROFESION_DELETE)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
