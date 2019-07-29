package abi.mehran.rahnemacollege.controller;

import abi.mehran.rahnemacollege.domain.UserInput;
import abi.mehran.rahnemacollege.model.User;
import abi.mehran.rahnemacollege.service.UserServiceImpl;
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

    private final UserServiceImpl service;
    private final UserResourceAssembler assembler;

    public UserController(UserServiceImpl service, UserResourceAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/users")
    public Resources<Resource<User>> all() {
        List<Resource<User>> users = service.all().stream()
                .map(this.assembler::assemble)
                .collect(Collectors.toList());
        return new Resources<>(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @PostMapping("/users")
    public Resource<User> add(@RequestBody UserInput userInput) {
        User user = userInput.toUser();
        return this.assembler.assemble(user);
    }

    @GetMapping("/user/{id}")
    public Resource<User> one(@PathVariable String id) {
        Optional<User> optionalUser = service.get(id);
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException(id));
        return this.assembler.assemble(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
