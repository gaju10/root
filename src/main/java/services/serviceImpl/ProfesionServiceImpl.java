package services.serviceImpl;

import dao.mysql.ProfesionDAOImpl;
import entity.Profesion;
import services.serviceInterface.ProfesionService;
import transaction.TransactionManager;

import java.util.List;

public class ProfesionServiceImpl implements ProfesionService {
    private ProfesionDAOImpl profesionDAO;
    private TransactionManager manager;

    public ProfesionServiceImpl(ProfesionDAOImpl profesionDAO, TransactionManager manager) {
        this.profesionDAO = profesionDAO;
        this.manager = manager;
    }

    @Override
    public Profesion createProfesion(Profesion profesion) {
        return manager.execute(()->profesionDAO.create(profesion));
    }

    @Override
    public Profesion getProfesion(int id) {
        return manager.execute(()->profesionDAO.get(id));
    }

    @Override
    public List<Profesion> getAll() {
        return manager.execute(()->profesionDAO.getAll());
    }
}
