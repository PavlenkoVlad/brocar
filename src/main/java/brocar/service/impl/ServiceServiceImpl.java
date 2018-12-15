package brocar.service.impl;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ModelCar;
import brocar.db.entity.ProvService;
import brocar.db.repository.ServiceRepository;
import brocar.service.ProvServiceService;
import brocar.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProvServiceService provServiceService;

    @Override
    public brocar.db.entity.Service findByBcsId(int bcs) {
        return serviceRepository.findServiceByBcsId(bcs);
    }

    @Override
    public brocar.db.entity.Service findByName(String name) {
        return serviceRepository.findServiceByName(name);
    }

    @Override
    public List<brocar.db.entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<brocar.db.entity.Service> findAllOrderByName() {
        return serviceRepository.findAllOrderByName();
    }

    @Override
    public List<brocar.db.entity.Service> findByAutoRepairShop(AutoRepairShop ars) {
        return serviceRepository.findDistinctByAutoRepairShop(ars);
    }

    @Override
    public void addAndUpdateService(brocar.db.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(brocar.db.entity.Service service) {
        Set<ProvService> provServices = service.getProvServices();
        for(ProvService p : provServices) {
            provServiceService.delete(p);
        }
        serviceRepository.delete(service);
    }
}
