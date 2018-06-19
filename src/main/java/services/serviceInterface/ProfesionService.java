package services.serviceInterface;

import entity.Profesion;

import java.util.List;

public interface ProfesionService {
    Profesion createProfesion(Profesion profesion);
    Profesion getProfesion(int id);
    List<Profesion> getAll();
}
