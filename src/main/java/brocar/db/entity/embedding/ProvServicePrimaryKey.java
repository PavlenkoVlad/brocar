package brocar.db.entity.embedding;

import brocar.db.entity.AutoRepairShop;
import brocar.db.entity.ModelCar;
import brocar.db.entity.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProvServicePrimaryKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "bcmd_id")
    @JsonIgnore
    private ModelCar modelCar;

    @ManyToOne
    @JoinColumn(name = "bca_id")
    @JsonIgnore
    private AutoRepairShop ars;

    @ManyToOne
    @JoinColumn(name = "bcs_id")
    @JsonIgnore
    private Service service;

    public ProvServicePrimaryKey() {

    }

    public ProvServicePrimaryKey(ModelCar modelCar, AutoRepairShop ars, Service service) {
        this.modelCar = modelCar;
        this.ars = ars;
        this.service = service;
    }

    public ModelCar getModelCar() {
        return modelCar;
    }

    public void setModelCar(ModelCar modelCar) {
        this.modelCar = modelCar;
    }

    public AutoRepairShop getArs() {
        return ars;
    }

    public void setArs(AutoRepairShop ars) {
        this.ars = ars;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
