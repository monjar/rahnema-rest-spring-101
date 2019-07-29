package abi.mehran.rahnemacollege.util.assembler;

import abi.mehran.rahnemacollege.controller.UserController;
import abi.mehran.rahnemacollege.domain.UserOutput;
import abi.mehran.rahnemacollege.model.User;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class UserResourceAssembler {
    public Resource<UserOutput> assemble(User user) {
        return new Resource<>(UserOutput.fromUser(user),
                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("all")
        );
    }
}
