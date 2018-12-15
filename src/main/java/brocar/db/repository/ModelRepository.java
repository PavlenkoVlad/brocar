package brocar.db.repository;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.MarkCar;
import brocar.db.entity.ModelCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<ModelCar, Integer> {

    ModelCar findModelCarByBcmdId(int bcmdId);

    ModelCar findModelCarByName(String name);

    @Query("select mdC from ModelCar mdC order by mdC.name")
    List<ModelCar> findAllOrderByName();

    @Query("select mdC from ModelCar mdC where mdC.markCar = :markCar order by mdC.name")
    List<ModelCar> findAllByMarkCarOrderByName(@Param("markCar")MarkCar markCar);

    @Query("select distinct mdC from ModelCar mdC inner join mdC.provServices pS where mdC.markCar = :markCar and pS.bcpId.ars = :ars order by mdC.name")
    List<ModelCar> findDistinctByMarkCarAndAutoRepairShop(@Param("markCar")MarkCar markCar, @Param("ars")AutoRepairShop autoRepairShop);

}
