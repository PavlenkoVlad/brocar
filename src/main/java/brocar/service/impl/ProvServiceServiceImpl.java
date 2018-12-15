package brocar.service.impl;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ModelCar;
import brocar.db.entity.ProvService;
import brocar.db.entity.embedding.ProvServicePrimaryKey;
import brocar.db.repository.ProvServiceRepository;
import brocar.service.AutoRepairShopService;
import brocar.service.ModelCarService;
import brocar.service.ProvServiceService;
import brocar.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProvServiceServiceImpl implements ProvServiceService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ProvServiceRepository provServiceRepository;

    @Autowired
    private ModelCarService modelCarService;

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @Autowired
    private ServiceService serviceService;

    @Override
    public ProvService findByBcaIdAndBcmdIdAndBcsId(int bcaId, int bcmdId, int bcsId) {
        return provServiceRepository.findProvServiceByBcaIdAndBcmdIdAndBcsId(bcaId, bcmdId, bcsId);
    }

    @Override
    public List<ProvService> findAll() {
        return provServiceRepository.findAll();
    }

    @Override
    public List<ProvService> findByModelCarAndAutoRepairShop(ModelCar modelCar, AutoRepairShop autoRepairShop) {
        return provServiceRepository.findDistinctByModelCarAndAutoRepairShop(modelCar, autoRepairShop);
    }

    @Override
    public void addProvService(int bcaId, int bcmdId, int bcsId, ProvService provService) {
        provService.setBcpId(new ProvServicePrimaryKey(
                modelCarService.findByBcmdId(bcmdId),
                autoRepairShopService.findByBcaId(bcaId),
                serviceService.findByBcsId(bcsId)
        ));
        provServiceRepository.save(provService);
    }

    @Override
    @Transactional
    public void updateProvService(int bcaId, int bcmdId, int bcsId, ProvService provService) {
        ProvService oldProvService = provServiceRepository.findProvServiceByBcaIdAndBcmdIdAndBcsId(bcaId, bcmdId, bcsId);
        oldProvService.setPrice(provService.getPrice());
        oldProvService.setDescription(provService.getDescription());
        provServiceRepository.save(oldProvService);
    }

    @Override
    public void delete(ProvService provService) {
        provServiceRepository.delete(provService);
    }
}
