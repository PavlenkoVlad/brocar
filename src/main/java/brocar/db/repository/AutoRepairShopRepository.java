package brocar.db.repository;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.MarkCar;
import brocar.db.entity.ModelCar;
import brocar.db.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutoRepairShopRepository extends JpaRepository<AutoRepairShop, Integer> {

    AutoRepairShop findAutoRepairShopByBcaId(int bcaId);

    List<AutoRepairShop> findAutoRepairShopsByNameOrPhone1OrPhone2OrEmail(String name, String phone1, String phone2, String email);

    @Query("select ars from AutoRepairShop ars order by ars.name")
    List<AutoRepairShop> findAllOrderByName();

    @Query("select distinct ars from AutoRepairShop ars inner join ars.provServices pS inner join pS.bcpId.modelCar mdC where mdC.markCar = :markCar order by ars.name")
    List<AutoRepairShop> findDistinctByMarkCar(@Param("markCar") MarkCar markCar);

    @Query("select distinct ars from AutoRepairShop ars inner join ars.provServices pS where pS.bcpId.modelCar = :modelCar order by ars.name")
    List<AutoRepairShop> findDistinctByModelCar(@Param("modelCar") ModelCar modelCar);

    @Query("select distinct ars from AutoRepairShop ars inner join ars.provServices pS where pS.bcpId.service = :service order by ars.name")
    List<AutoRepairShop> findDistinctByService(@Param("service") Service service);

    @Query("select distinct ars from AutoRepairShop ars inner join ars.provServices pS inner join pS.bcpId.modelCar mdC where mdC.markCar = :markCar and pS.bcpId.service = :service order by ars.name")
    List<AutoRepairShop> findDistinctByMarkCarAndService(@Param("markCar") MarkCar markCar, @Param("service") Service service);

    @Query("select distinct ars from AutoRepairShop ars inner join ars.provServices pS where pS.bcpId.modelCar = :modelCar and pS.bcpId.service = :service order by ars.name")
    List<AutoRepairShop> findDistinctByModelCarAndService(@Param("modelCar") ModelCar modelCar, @Param("service") Service service);

}
