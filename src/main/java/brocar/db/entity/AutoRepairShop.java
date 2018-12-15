package brocar.db.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "auto_repair_shop")
public class AutoRepairShop {

    @Id
    @Column(name = "bca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bcaId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "phone_1", unique = true, nullable = false)
    private String phone1;

    @Column(name = "phone_2", unique = true)
    private String phone2;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Timetable timetable;

    @OneToMany(mappedBy = "bcpId.ars", fetch = FetchType.EAGER)
    private Set<ProvService> provServices;

    public AutoRepairShop() {

    }

    public AutoRepairShop(String name, String phone1, String phone2, String address, String email, String description,
                          Timetable timetable, Set<ProvService> provServices) {
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
        this.email = email;
        this.description = description;
        this.timetable = timetable;
        this.provServices = provServices;
    }

    public int getBcaId() {
        return bcaId;
    }

    public void setBcaId(int bcaId) {
        this.bcaId = bcaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public Set<ProvService> getProvServices() {
        return provServices;
    }

    public void setProvServices(Set<ProvService> provServices) {
        this.provServices = provServices;
    }
}
