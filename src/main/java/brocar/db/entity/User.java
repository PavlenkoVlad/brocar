package brocar.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @Column(name = "bcu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bcuId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "role")
    private String role;

    public User() {

    }

    public User(String username, String password, boolean active, String role) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public int getBcuId() {
        return bcuId;
    }

    public void setBcuId(int bcuId) {
        this.bcuId = bcuId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
