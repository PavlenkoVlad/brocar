package brocar.service;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.MarkCar;

import java.util.List;

public interface MarkCarService {

    MarkCar findByBcmId(int bcmId);

    MarkCar findByName(String name);

    List<MarkCar> findAll();

    List<MarkCar> findAllOrderByName();

    List<MarkCar> findByAutoRepairShop(AutoRepairShop ars);

    void addAndUpdateMarkCar(MarkCar markCar);

    void delete(MarkCar markCar);

}
