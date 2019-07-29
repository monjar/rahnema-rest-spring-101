package abi.mehran.rahnemacollege.domain;

import abi.mehran.rahnemacollege.model.Post;
import abi.mehran.rahnemacollege.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserOutput {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Post> posts;

    public static UserOutput fromUser(User user) {
        UserOutput dto = new UserOutput();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPosts(user.getPosts());
        return dto;
    }

    public User toUser() {
        User user = new User();
        user.setId(this.getId());
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setPosts(this.getPosts());
        return user;
    }
}
