package abi.mehran.rahnemacollege.domain;

import abi.mehran.rahnemacollege.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInput {
    private String firstName;
    private String lastName;

    public static UserInput fromUser(User user) {
        UserInput dto = new UserInput();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }

    public User toUser() {
        User user = new User();
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        return user;
    }
}
