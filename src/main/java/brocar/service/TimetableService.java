package brocar.service;

import brocar.db.entity.Timetable;

import java.util.List;

public interface TimetableService {

    Timetable findByBcaId(int bcaId);

    List<Timetable> findAll();

    List<Timetable> findAllOrderByBcaId();

    void addTimetable(Timetable timetable);

    void updateTimetable(Timetable timetable);

    void delete(Timetable timetable);

}
