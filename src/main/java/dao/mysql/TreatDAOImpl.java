package dao.mysql;

import constants.QueryConstants;
import dao.TreatDAO;
import dao.mapper.TreatMapper;
import dao.mapper.UserMapper;
import entity.Treat;
import transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatDAOImpl implements TreatDAO {
    @Override
    public Treat create(Treat entity) {

        TreatMapper mapper = new TreatMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement= connection.prepareStatement(QueryConstants.TREAT_CREATE, Statement.RETURN_GENERATED_KEYS)){
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
    public Treat get(int id) {

        TreatMapper mapper = new TreatMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        Treat treat = null;
        try(PreparedStatement statement = connection.prepareStatement(QueryConstants.TREAT_GET)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            treat = mapper.map(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treat;
    }

    @Override
    public List<Treat> getAll() {

        TreatMapper mapper = new TreatMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        List<Treat> treats = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.TREAT_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                treats.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treats;
    }

    @Override
    public void update(Treat entity) {
        TreatMapper mapper = new TreatMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.TREAT_UPDATE)) {
            int index = mapper.unMap(statement, entity);
            statement.setInt(++index, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Treat entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueryConstants.TREAT_DELETE)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
