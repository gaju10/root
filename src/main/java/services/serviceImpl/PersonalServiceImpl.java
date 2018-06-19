package services.serviceImpl;

import dao.mysql.PersonalDAOImpl;
import entity.Personal;
import services.serviceInterface.PersonalService;
import transaction.TransactionManager;

import java.util.List;

public class PersonalServiceImpl implements PersonalService {
    private PersonalDAOImpl personalDAO;
    private TransactionManager manager;

    public PersonalServiceImpl(PersonalDAOImpl personalDAO, TransactionManager manager) {
        this.personalDAO = personalDAO;
        this.manager = manager;
    }

    @Override
    public Personal createPersonal(Personal personal) {
        return manager.execute(()->personalDAO.create(personal));
    }

    @Override
    public Personal getPersonal(int id) {
        return manager.execute(()->personalDAO.get(id));
    }

    @Override
    public List<Personal> getAll() {
        return manager.execute(()->personalDAO.getAll());
    }
}
