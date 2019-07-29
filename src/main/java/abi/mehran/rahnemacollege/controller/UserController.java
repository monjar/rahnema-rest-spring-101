package abi.mehran.rahnemacollege.controller;

import abi.mehran.rahnemacollege.domain.UserOutput;
import abi.mehran.rahnemacollege.model.User;
import abi.mehran.rahnemacollege.service.UserService;
import abi.mehran.rahnemacollege.util.assembler.UserResourceAssembler;
import abi.mehran.rahnemacollege.util.exception.EntityNotFoundException;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserService service;
    private final UserResourceAssembler assembler;

    public UserController(UserService service, UserResourceAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/users")
    public Resources<Resource<UserOutput>> all() {
        List<Resource<UserOutput>> users = service.all().stream()
                .map(this.assembler::assemble)
                .collect(Collectors.toList());
        return new Resources<>(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @PostMapping("/users")
    public Resource<UserOutput> add(@RequestBody UserOutput userDTO) {
        User user = this.service.add(userDTO.toUser());
        return this.assembler.assemble(user);
    }

    @GetMapping("/user/{id}")
    public Resource<UserOutput> one(@PathVariable Long id) {
        Optional<User> optionalUser = service.get(id);
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException(id));
        return this.assembler.assemble(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
