package brocar.service;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ModelCar;
import brocar.db.entity.Service;

import java.util.List;

public interface ServiceService {

    Service findByBcsId(int bcs);

    Service findByName(String name);

    List<Service> findAll();

    List<Service> findAllOrderByName();

    List<Service> findByAutoRepairShop(AutoRepairShop ars);

    void addAndUpdateService(Service service);

    void delete(Service service);

}
