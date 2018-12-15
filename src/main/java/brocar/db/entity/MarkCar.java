package brocar.db.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mark")
public class MarkCar {

    @Column(name = "bcm_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bcmId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "markCar", fetch = FetchType.EAGER)
    private Set<ModelCar> modelCars;

    public MarkCar() {

    }

    public MarkCar(String name, Set<ModelCar> modelCars) {
        this.name = name;
        this.modelCars = modelCars;
    }

    public int getBcmId() {
        return bcmId;
    }

    public void setBcmId(int bcmId) {
        this.bcmId = bcmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ModelCar> getModelCars() {
        return modelCars;
    }

    public void setModelCars(Set<ModelCar> modelCars) {
        this.modelCars = modelCars;
    }
}
