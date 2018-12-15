package brocar.service;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.MarkCar;
import brocar.db.entity.ModelCar;

import java.util.List;

public interface ModelCarService {

    ModelCar findByBcmdId(int bcmdId);

    ModelCar findByName(String name);

    List<ModelCar> findAll();

    List<ModelCar> findAllOrderByName();

    List<ModelCar> findAllByMarkCar(MarkCar markCar);

    List<ModelCar> findByMarkCarAndAutoRepairShop(MarkCar markCar, AutoRepairShop autoRepairShop);

    void addModelCar(int bcmId, ModelCar modelCar);

    void updateModelCar(int bcmId, ModelCar modelCar);

    void delete(ModelCar modelCar);
}
