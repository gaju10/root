package services.serviceImpl;

import dao.mysql.DiagnosisDAOImpl;
import entity.Diagnosis;
import services.serviceInterface.DiagnosisService;
import transaction.TransactionManager;

import java.util.List;

public class DiagnosisServiceImpl implements DiagnosisService {
    private DiagnosisDAOImpl diagnosisDAO;
    private TransactionManager manager;

    public DiagnosisServiceImpl(DiagnosisDAOImpl diagnosisDAO, TransactionManager manager) {
        this.diagnosisDAO = diagnosisDAO;
        this.manager = manager;
    }

    @Override
    public Diagnosis createDiagnosis(Diagnosis diagnosis) {
        return manager.execute(()->diagnosisDAO.create(diagnosis));
    }

    @Override
    public Diagnosis getDiagnosis(int id) {
       return manager.execute(()->diagnosisDAO.get(id));
    }

    @Override
    public List<Diagnosis> getAll() {
        return manager.execute(()->diagnosisDAO.getAll());
    }
}
