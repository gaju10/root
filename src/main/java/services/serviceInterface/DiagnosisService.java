package services.serviceInterface;

import entity.Diagnosis;

import java.util.List;

public interface DiagnosisService {
    Diagnosis createDiagnosis(Diagnosis diagnosis);
    Diagnosis getDiagnosis(int id);
    List<Diagnosis> getAll();
}
