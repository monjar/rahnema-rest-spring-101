package abi.mehran.rahnemacollege.domain;

import abi.mehran.rahnemacollege.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
    private String firstName;
    private String lastName;

    public User toUser() {
        return new User(this.getFirstName(), this.getLastName());
    }
}
