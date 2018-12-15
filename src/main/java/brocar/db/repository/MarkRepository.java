package brocar.db.repository;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.MarkCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends JpaRepository<MarkCar, Integer> {

    MarkCar findMarkCarByBcmId(int bcmId);

    MarkCar findMarkCarByName(String name);

    @Query("select mC from MarkCar mC order by mC.name")
    List<MarkCar> findAllOrderByName();

    @Query("select distinct mC from MarkCar mC inner join mC.modelCars mdC inner join mdC.provServices pS where pS.bcpId.ars = :ars order by mC.name")
    List<MarkCar> findDistinctByAutoRepairShop(@Param("ars") AutoRepairShop ars);

}
