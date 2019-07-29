package ind.amirali.Controllers;

import ind.amirali.domain.UserDTO;
import ind.amirali.model.User;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class ResourceAssembler {

    public Resource<UserDTO> assmble(User user) {
        return new Resource<>(UserDTO.fromUser(user),
                linkTo(methodOn(UserController.class).getOne(UserDTO.fromUser(user).getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).show()).withRel("all"),
                linkTo(methodOn(UserController.class).delete(user.getFirstName(), user.getLastName())).withRel("Delete"),
                linkTo(methodOn(UserController.class).update(user.getId() ,UserDTO.fromUser(user))).withRel("put")
        );

    }
}
