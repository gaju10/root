package services.serviceImpl;

import dao.mysql.TreatDAOImpl;
import entity.Treat;
import services.serviceInterface.TreatService;
import transaction.TransactionManager;

import java.util.List;

public class TreatServiceImpl implements TreatService {
    private TreatDAOImpl treatDAO;
    private TransactionManager manager;

    public TreatServiceImpl(TreatDAOImpl treatDAO, TransactionManager manager) {
        this.treatDAO = treatDAO;
        this.manager = manager;
    }

    @Override
    public Treat createTreat(Treat treat) {
        return manager.execute(()->treatDAO.create(treat));
    }

    @Override
    public Treat getTreat(int id) {
        return manager.execute(()->treatDAO.get(id));
    }

    @Override
    public List<Treat> getAll() {
        return manager.execute(()->treatDAO.getAll());
    }
}
