package brocar.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "model")
public class ModelCar {

    @Column(name = "bcmd_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bcmdId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bcm_id")
    @JsonIgnore
    private MarkCar markCar;

    @OneToMany(mappedBy = "bcpId.modelCar", fetch = FetchType.EAGER)
    Set<ProvService> provServices;

    public ModelCar() {

    }

    public ModelCar(String name, MarkCar markCar, Set<ProvService> provServices) {
        this.name = name;
        this.markCar = markCar;
        this.provServices = provServices;
    }

    public int getBcmdId() {
        return bcmdId;
    }

    public void setBcmdId(int bcmdId) {
        this.bcmdId = bcmdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MarkCar getMarkCar() {
        return markCar;
    }

    public void setMarkCar(MarkCar markCar) {
        this.markCar = markCar;
    }

    public Set<ProvService> getProvServices() {
        return provServices;
    }

    public void setProvServices(Set<ProvService> provServices) {
        this.provServices = provServices;
    }
}
