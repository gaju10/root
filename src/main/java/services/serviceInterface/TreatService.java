package services.serviceInterface;

import entity.Treat;

import java.util.List;

public interface TreatService {
    Treat createTreat(Treat treat);
    Treat getTreat(int id);
    List<Treat> getAll();
}
