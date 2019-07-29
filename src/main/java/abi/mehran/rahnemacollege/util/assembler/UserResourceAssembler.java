package abi.mehran.rahnemacollege.util.assembler;

import abi.mehran.rahnemacollege.model.User;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserResourceAssembler {

    public static Resource<User> toResourse(User user) {
        return null;
    }
}
