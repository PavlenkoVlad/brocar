package brocar.db.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {

    @Column(name = "bcs_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bcsId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bcs_id")
    Set<ProvService> provServices;

    public Service() {

    }

    public Service(String name, Set<ProvService> provServices) {
        this.name = name;
        this.provServices = provServices;
    }

    public int getBcsId() {
        return bcsId;
    }

    public void setBcsId(int bcsId) {
        this.bcsId = bcsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProvService> getProvServices() {
        return provServices;
    }

    public void setProvServices(Set<ProvService> provServices) {
        this.provServices = provServices;
    }
}
