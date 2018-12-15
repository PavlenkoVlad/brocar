package brocar.service.impl;

import brocar.db.entity.*;
import brocar.db.repository.AutoRepairShopRepository;
import brocar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AutoRepairShopServiceImpl implements AutoRepairShopService {

    @Autowired
    private AutoRepairShopRepository autoRepairShopRepository;

    @Autowired
    private MarkCarService markCarService;

    @Autowired
    private ModelCarService modelCarService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ProvServiceService provServiceService;

    @Autowired
    private TimetableService timetableService;

    @Override
    public AutoRepairShop findByBcaId(int bcaId) {
        return autoRepairShopRepository.findAutoRepairShopByBcaId(bcaId);
    }

    @Override
    public List<AutoRepairShop> findAutoRepairShopsByNameOrPhone1OrPhone2OrEmail(String name, String phone1, String phone2, String email) {
        return autoRepairShopRepository.findAutoRepairShopsByNameOrPhone1OrPhone2OrEmail(name, phone1, phone2, email);
    }

    @Override
    public List<AutoRepairShop> findAll() {
        return autoRepairShopRepository.findAll();
    }

    @Override
    public List<AutoRepairShop> findAllOrderByName() {
        return autoRepairShopRepository.findAllOrderByName();
    }

    @Override
    public List<AutoRepairShop> findByMarkCar(MarkCar markCar) {
        return autoRepairShopRepository.findDistinctByMarkCar(markCar);
    }

    @Override
    public List<AutoRepairShop> findByModelCar(ModelCar modelCar) {
        return autoRepairShopRepository.findDistinctByModelCar(modelCar);
    }

    @Override
    public List<AutoRepairShop> findByService(brocar.db.entity.Service service) {
        return autoRepairShopRepository.findDistinctByService(service);
    }

    @Override
    public List<AutoRepairShop> findByMarkCarAndService(MarkCar markCar, brocar.db.entity.Service service) {
        return autoRepairShopRepository.findDistinctByMarkCarAndService(markCar, service);
    }

    @Override
    public List<AutoRepairShop> findByModelCarAndService(ModelCar modelCar, brocar.db.entity.Service service) {
        return autoRepairShopRepository.findDistinctByModelCarAndService(modelCar, service);
    }

    @Override
    public Map<AutoRepairShop, String[]> findAllWithMarkCarsAndServices() {
        List<AutoRepairShop> autoRepairShops = this.findAllOrderByName();
        Map<AutoRepairShop, String[]> autoRepairShopMap = new HashMap<>();
        for(AutoRepairShop ars : autoRepairShops) {
            String[] marksServices = {getMarksForAutoRepairShop(ars), getServicesForAutoRepairShop(ars)};
            autoRepairShopMap.put(ars, marksServices);
        }
        return autoRepairShopMap;
    }

    @Override
    public Map<AutoRepairShop, String[]> findByMarkCarWithMarkCarsAndServices(MarkCar markCar) {
        List<AutoRepairShop> autoRepairShops = this.findByMarkCar(markCar);
        Map<AutoRepairShop, String[]> autoRepairShopMap = new HashMap<>();
        for(AutoRepairShop ars : autoRepairShops) {
            String[] marksServices = {getMarksForAutoRepairShop(ars), getServicesForAutoRepairShop(ars)};
            autoRepairShopMap.put(ars, marksServices);
        }
        return autoRepairShopMap;
    }

    @Override
    public Map<AutoRepairShop, String[]> findByModelCarWithMarkCarsAndServices(ModelCar modelCar) {
        List<AutoRepairShop> autoRepairShops = this.findByModelCar(modelCar);
        Map<AutoRepairShop, String[]> autoRepairShopMap = new HashMap<>();
        for(AutoRepairShop ars : autoRepairShops) {
            String[] marksServices = {getMarksForAutoRepairShop(ars), getServicesForAutoRepairShop(ars)};
            autoRepairShopMap.put(ars, marksServices);
        }
        return autoRepairShopMap;
    }

    @Override
    public Map<AutoRepairShop, String[]> findByServiceWithMarkCarsAndServices(brocar.db.entity.Service service) {
        List<AutoRepairShop> autoRepairShops = this.findByService(service);
        Map<AutoRepairShop, String[]> autoRepairShopMap = new HashMap<>();
        for(AutoRepairShop ars : autoRepairShops) {
            String[] marksServices = {getMarksForAutoRepairShop(ars), getServicesForAutoRepairShop(ars)};
            autoRepairShopMap.put(ars, marksServices);
        }
        return autoRepairShopMap;
    }

    @Override
    public Map<AutoRepairShop, String[]> findByMarkCarAndServiceWithMarkCarsAndServices(MarkCar markCar, brocar.db.entity.Service service) {
        List<AutoRepairShop> autoRepairShops = this.findByMarkCarAndService(markCar, service);
        Map<AutoRepairShop, String[]> autoRepairShopMap = new HashMap<>();
        for(AutoRepairShop ars : autoRepairShops) {
            String[] marksServices = {getMarksForAutoRepairShop(ars), getServicesForAutoRepairShop(ars)};
            autoRepairShopMap.put(ars, marksServices);
        }
        return autoRepairShopMap;
    }

    @Override
    public Map<AutoRepairShop, String[]> findByModelCarAndServiceWithMarkCarsAndServices(ModelCar modelCar, brocar.db.entity.Service service) {
        List<AutoRepairShop> autoRepairShops = this.findByModelCarAndService(modelCar, service);
        Map<AutoRepairShop, String[]> autoRepairShopMap = new HashMap<>();
        for(AutoRepairShop ars : autoRepairShops) {
            String[] marksServices = {getMarksForAutoRepairShop(ars), getServicesForAutoRepairShop(ars)};
            autoRepairShopMap.put(ars, marksServices);
        }
        return autoRepairShopMap;
    }

    @Override
    public Map<Map<String, Integer>, Map<String, List<ProvService>>> getAllInfoAboutProvServices(AutoRepairShop ars) {
        Map<Map<String, Integer>, Map<String, List<ProvService>>> infoAboutProvService = new HashMap<>();
        List<MarkCar> markCars = markCarService.findByAutoRepairShop(ars);
        for(MarkCar markCar : markCars) {
            List<ModelCar> modelCars = modelCarService.findByMarkCarAndAutoRepairShop(markCar, ars);
            Map<String, List<ProvService>> modelCarServices = new HashMap<>();
            int numOfProvServices = 0;
            for(ModelCar modelCar : modelCars) {
                List<ProvService> namesServices = provServiceService.findByModelCarAndAutoRepairShop(modelCar, ars);
                numOfProvServices += namesServices.size();
                modelCarServices.put(modelCar.getName(), namesServices);
            }
            Map<String, Integer> markInfo = new HashMap<>();
            markInfo.put(markCar.getName(), numOfProvServices);
            infoAboutProvService.put(markInfo, modelCarServices);
        }
        return infoAboutProvService;
    }

    private String getMarksForAutoRepairShop(AutoRepairShop ars) {
        List<MarkCar> markCars = markCarService.findByAutoRepairShop(ars);
        String markCarsStr = "";
        for(MarkCar markCar : markCars) {
            markCarsStr += markCar.getName() + "; ";
        }
        return markCarsStr;
    }

    private String getServicesForAutoRepairShop(AutoRepairShop ars) {
        List<brocar.db.entity.Service> services = serviceService.findByAutoRepairShop(ars);
        String servicesStr = "";
        for(brocar.db.entity.Service service : services) {
            servicesStr += service.getName() + "; ";
        }
        return servicesStr;
    }

    @Override
    public void addAndUpdateAutoRepairShop(AutoRepairShop autoRepairShop) {
        autoRepairShopRepository.save(autoRepairShop);
    }

    @Override
    public void delete(AutoRepairShop autoRepairShop) {
        Timetable timetable = autoRepairShop.getTimetable();
        if(timetable != null) {
            timetableService.delete(timetable);
        }
        Set<ProvService> provServices = autoRepairShop.getProvServices();
        if(provServices.size() != 0) {
            for(ProvService provService : provServices) {
                provServiceService.delete(provService);
            }
        }
        autoRepairShopRepository.delete(autoRepairShop);
    }
}
