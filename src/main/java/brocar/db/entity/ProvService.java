package brocar.db.entity;

import brocar.db.entity.embedding.ProvServicePrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prov_service")
public class ProvService {

    @EmbeddedId
    @JsonIgnore
    private ProvServicePrimaryKey bcpId;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description")
    private String description;

    public ProvService() {

    }

    public ProvService(ProvServicePrimaryKey bcpId, double price, String description) {
        this.bcpId = bcpId;
        this.price = price;
        this.description = description;
    }

    public ProvServicePrimaryKey getBcpId() {
        return bcpId;
    }

    public void setBcpId(ProvServicePrimaryKey bcpId) {
        this.bcpId = bcpId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
