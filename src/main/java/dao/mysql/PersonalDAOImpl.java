package dao.mysql;

import constants.QueryConstants;
import dao.PersonalDAO;
import dao.mapper.PersonalMapper;
import dao.mapper.TreatMapper;
import entity.Personal;
import transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDAOImpl implements PersonalDAO {
    @Override
    public Personal create(Personal entity) {
        PersonalMapper mapper = new PersonalMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement= connection.prepareStatement(QueryConstants.PERSONAL_CREATE, Statement.RETURN_GENERATED_KEYS)){
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
    public Personal get(int id) {
        PersonalMapper mapper = new PersonalMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        Personal personal = null;
        try(PreparedStatement statement = connection.prepareStatement(QueryConstants.PERSONAL_GET)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            personal = mapper.map(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personal;
    }

    @Override
    public List<Personal> getAll() {
        PersonalMapper mapper = new PersonalMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        List<Personal> personals = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.PERSONAL_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                personals.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personals;
    }

    @Override
    public void update(Personal entity) {
        PersonalMapper mapper = new PersonalMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.PERSONAL_UPDATE)) {
            int index = mapper.unMap(statement, entity);
            statement.setInt(++index, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Personal entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.PERSONAL_DELETE)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
