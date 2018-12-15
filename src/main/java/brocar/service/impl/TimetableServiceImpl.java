package brocar.service.impl;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.Timetable;
import brocar.db.repository.TimetableRepository;
import brocar.service.AutoRepairShopService;
import brocar.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private AutoRepairShopService autoRepairShopService;

    @Override
    public Timetable findByBcaId(int bcaId) {
        return timetableRepository.findTimetableByBcaId(bcaId);
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public List<Timetable> findAllOrderByBcaId() {
        return timetableRepository.findAllOrderByBcaId();
    }

    @Override
    @Transactional
    public void addTimetable(Timetable timetable) {
        AutoRepairShop autoRepairShop = autoRepairShopService.findByBcaId(timetable.getBcaId());
        timetable.setArs(autoRepairShop);
        timetable.setBcaId(0);
        autoRepairShop.setTimetable(timetable);
        entityManager.persist(timetable);
    }

    @Override
    public void updateTimetable(Timetable timetable) {
        Timetable findTimetable = timetableRepository.findTimetableByBcaId(timetable.getBcaId());
        findTimetable.setMonday(timetable.getMonday());
        findTimetable.setTuesday(timetable.getTuesday());
        findTimetable.setWednesday(timetable.getWednesday());
        findTimetable.setThursday(timetable.getThursday());
        findTimetable.setFriday(timetable.getFriday());
        findTimetable.setSaturday(timetable.getSaturday());
        findTimetable.setSunday(timetable.getSunday());
        timetableRepository.save(findTimetable);
    }

    @Override
    @Transactional
    public void delete(Timetable timetable) {
        AutoRepairShop autoRepairShop = timetable.getArs();
        autoRepairShop.setTimetable(null);
        timetable.setArs(null);
        entityManager.persist(autoRepairShop);
        timetableRepository.delete(timetable);
    }
}
