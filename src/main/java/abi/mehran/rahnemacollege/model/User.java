package abi.mehran.rahnemacollege.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
