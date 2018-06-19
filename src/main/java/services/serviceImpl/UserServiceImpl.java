package services.serviceImpl;

import dao.mysql.UserDAOImpl;
import entity.User;
import services.serviceInterface.UserService;
import transaction.TransactionManager;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAOImpl userDAO;
    private TransactionManager manager;

    public UserServiceImpl(UserDAOImpl userDAO, TransactionManager manager) {
        this.userDAO = userDAO;
        this.manager = manager;
    }

    @Override
    public User createUser(User user) {
        return manager.execute(()->userDAO.create(user));
    }

    @Override
    public User getUser(int id) {
        return manager.execute(()->userDAO.get(id));
    }

    @Override
    public List<User> getAll() {
        return manager.execute(()->userDAO.getAll());
    }
}
