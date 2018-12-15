package brocar.service.impl;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.MarkCar;
import brocar.db.entity.ModelCar;
import brocar.db.entity.ProvService;
import brocar.db.repository.ModelRepository;
import brocar.service.MarkCarService;
import brocar.service.ModelCarService;
import brocar.service.ProvServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ModelCarServiceImpl implements ModelCarService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private MarkCarService markCarService;

    @Autowired
    private ProvServiceService provServiceService;

    @Override
    public ModelCar findByBcmdId(int bcmdId) {
        return modelRepository.findModelCarByBcmdId(bcmdId);
    }

    @Override
    public ModelCar findByName(String name) {
        return modelRepository.findModelCarByName(name);
    }

    @Override
    public List<ModelCar> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public List<ModelCar> findAllOrderByName() {
        return modelRepository.findAllOrderByName();
    }

    @Override
    public List<ModelCar> findAllByMarkCar(MarkCar markCar) {
        return modelRepository.findAllByMarkCarOrderByName(markCar);
    }

    @Override
    public List<ModelCar> findByMarkCarAndAutoRepairShop(MarkCar markCar, AutoRepairShop autoRepairShop) {
        return modelRepository.findDistinctByMarkCarAndAutoRepairShop(markCar, autoRepairShop);
    }

    @Override
    public void addModelCar(int bcmId, ModelCar modelCar) {
        MarkCar markCar = markCarService.findByBcmId(bcmId);
        modelCar.setMarkCar(markCar);
        modelRepository.save(modelCar);
    }

    @Override
    public void updateModelCar(int bcmId, ModelCar modelCar) {
        ModelCar oldModelCar = modelRepository.findModelCarByBcmdId(modelCar.getBcmdId());
        MarkCar oldMarkCar = oldModelCar.getMarkCar();
        oldMarkCar.getModelCars().remove(oldModelCar);
        oldModelCar.setName(modelCar.getName());
        oldModelCar.setMarkCar(markCarService.findByBcmId(bcmId));
        modelRepository.save(oldModelCar);
    }

    @Override
    public void delete(ModelCar modelCar) {
        Set<ProvService> provServices = modelCar.getProvServices();
        for(ProvService p : provServices) {
            provServiceService.delete(p);
        }
        modelRepository.delete(modelCar);
    }
}
