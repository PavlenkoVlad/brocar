package brocar.db.repository;

import brocar.db.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {

    Timetable findTimetableByBcaId(int bcaId);

    @Query("select t from Timetable t order by t.bcaId")
    List<Timetable> findAllOrderByBcaId();
}
