package brocar.db.repository;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ModelCar;
import brocar.db.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    Service findServiceByBcsId(int bcs);

    Service findServiceByName(String name);

    @Query("select s from Service s order by s.name")
    List<Service> findAllOrderByName();

    @Query("select distinct s from Service s inner join s.provServices pS where pS.bcpId.ars = :ars order by s.name")
    List<Service> findDistinctByAutoRepairShop(@Param("ars") AutoRepairShop ars);

}
