package ind.amirali.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data @AllArgsConstructor @NoArgsConstructor
@Document(collection = "person")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Double balance;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id){
        this.id = id;
    }
}
