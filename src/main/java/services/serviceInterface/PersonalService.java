package services.serviceInterface;

import entity.Personal;

import java.util.List;

public interface PersonalService {
    Personal createPersonal(Personal personal);
    Personal getPersonal(int id);
    List<Personal> getAll();
}
