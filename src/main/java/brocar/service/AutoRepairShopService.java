package brocar.service;

import brocar.db.entity.*;

import java.util.List;
import java.util.Map;

public interface AutoRepairShopService {

    AutoRepairShop findByBcaId(int bcaId);

    List<AutoRepairShop> findAutoRepairShopsByNameOrPhone1OrPhone2OrEmail(String name, String phone1, String phone2, String email);

    List<AutoRepairShop> findAll();

    List<AutoRepairShop> findAllOrderByName();

    List<AutoRepairShop> findByMarkCar(MarkCar markCar);

    List<AutoRepairShop> findByModelCar(ModelCar modelCar);

    List<AutoRepairShop> findByService(Service service);

    List<AutoRepairShop> findByMarkCarAndService(MarkCar markCar, Service service);

    List<AutoRepairShop> findByModelCarAndService(ModelCar modelCar, Service service);

    Map<AutoRepairShop, String[]> findAllWithMarkCarsAndServices();

    Map<AutoRepairShop, String[]> findByMarkCarWithMarkCarsAndServices(MarkCar markCar);

    Map<AutoRepairShop, String[]> findByModelCarWithMarkCarsAndServices(ModelCar modelCar);

    Map<AutoRepairShop, String[]> findByServiceWithMarkCarsAndServices(Service service);

    Map<AutoRepairShop, String[]> findByMarkCarAndServiceWithMarkCarsAndServices(MarkCar markCar, Service service);

    Map<AutoRepairShop, String[]> findByModelCarAndServiceWithMarkCarsAndServices(ModelCar modelCar, Service service);

    Map<Map<String, Integer>, Map<String, List<ProvService>>> getAllInfoAboutProvServices(AutoRepairShop ars);

    void addAndUpdateAutoRepairShop(AutoRepairShop autoRepairShop);

    void delete(AutoRepairShop autoRepairShop);
}
