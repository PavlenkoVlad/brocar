package brocar.service.impl;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.MarkCar;
import brocar.db.entity.ModelCar;
import brocar.db.repository.MarkRepository;
import brocar.service.MarkCarService;
import brocar.service.ModelCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MarkCarServiceImpl implements MarkCarService {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private ModelCarService modelCarService;

    @Override
    public MarkCar findByBcmId(int bcmId) {
        return markRepository.findMarkCarByBcmId(bcmId);
    }

    @Override
    public MarkCar findByName(String name) {
        return markRepository.findMarkCarByName(name);
    }

    @Override
    public List<MarkCar> findAll() {
        return markRepository.findAll();
    }

    @Override
    public List<MarkCar> findAllOrderByName() {
        return markRepository.findAllOrderByName();
    }

    @Override
    public List<MarkCar> findByAutoRepairShop(AutoRepairShop ars) {
        return markRepository.findDistinctByAutoRepairShop(ars);
    }

    @Override
    public void addAndUpdateMarkCar(MarkCar markCar) {
        markRepository.save(markCar);
    }

    @Override
    public void delete(MarkCar markCar) {
        Set<ModelCar> modelCars = markCar.getModelCars();
        for(ModelCar m : modelCars) {
            modelCarService.delete(m);
        }
        markRepository.delete(markCar);
    }
}
