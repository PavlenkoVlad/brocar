package brocar.db.repository;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ModelCar;
import brocar.db.entity.ProvService;
import brocar.db.entity.embedding.ProvServicePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvServiceRepository extends JpaRepository<ProvService, ProvServicePrimaryKey> {

    @Query(value = "select * from prov_service where bca_id = ?1 and bcmd_id = ?2 and bcs_id = ?3", nativeQuery = true)
    ProvService findProvServiceByBcaIdAndBcmdIdAndBcsId(int bcaId, int bcmdId, int bcsId);

    @Query("select distinct pS from ProvService pS where pS.bcpId.modelCar = :modelCar and pS.bcpId.ars = :ars")
    List<ProvService> findDistinctByModelCarAndAutoRepairShop(@Param("modelCar")ModelCar modelCar, @Param("ars")AutoRepairShop autoRepairShop);

}
