package ind.amirali.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @NoArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String details;
    private Date date;

    public Order(String details, Date date) {
        this.details = details;
        this.date = date;
    }

    @ManyToOne @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    DeliveryGuy deliveryGuy;
}
