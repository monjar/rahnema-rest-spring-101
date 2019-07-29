package ind.amirali.domain;

import ind.amirali.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserDTO {
    private String firstName,lastName;
    private String id;
    public User toUser(){
        return new User(this.firstName, this.lastName);
    }

    public static UserDTO fromUser(User user){
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getId());
    }
}
