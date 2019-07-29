package ind.amirali.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity @Data @Table(name="deli") @NoArgsConstructor
public class DeliveryGuy {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;

    public DeliveryGuy(String name){
        this.name = name;
    }
     @OneToMany(mappedBy="deli")
    private
            Set<Order> orders;


}
