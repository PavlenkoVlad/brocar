package brocar.db.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(strategy = "foreign", name = "generator",
            parameters = @Parameter(name = "property", value = "ars"))
    @Column(name = "bca_id")
    private int bcaId;

    @OneToOne(mappedBy = "timetable", fetch = FetchType.EAGER)
    private AutoRepairShop ars;

    @Column(name = "monday")
    private String monday;

    @Column(name = "tuesday")
    private String tuesday;

    @Column(name = "wednesday")
    private String wednesday;

    @Column(name = "thursday")
    private String thursday;

    @Column(name = "friday")
    private String friday;

    @Column(name = "saturday")
    private String saturday;

    @Column(name = "sunday")
    private String sunday;

    public Timetable() {

    }

    public Timetable(AutoRepairShop ars, String monday, String tuesday, String wednesday, String thursday,
                     String friday, String saturday, String sunday) {
        this.ars = ars;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public int getBcaId() {
        return bcaId;
    }

    public void setBcaId(int bcaId) {
        this.bcaId = bcaId;
    }

    public AutoRepairShop getArs() {
        return ars;
    }

    public void setArs(AutoRepairShop ars) {
        this.ars = ars;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }
}
