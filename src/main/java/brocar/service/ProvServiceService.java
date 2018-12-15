package brocar.service;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ModelCar;
import brocar.db.entity.ProvService;

import java.util.List;

public interface ProvServiceService {

    ProvService findByBcaIdAndBcmdIdAndBcsId(int bcaId, int bcmdId, int bcsId);

    List<ProvService> findAll();

    List<ProvService> findByModelCarAndAutoRepairShop(ModelCar modelCar, AutoRepairShop autoRepairShop);

    void addProvService(int bcaId, int bcmdId, int bcsId, ProvService provService);

    void updateProvService(int bcaId, int bcmdId, int bcsId, ProvService provService);

    void delete(ProvService provService);

}
