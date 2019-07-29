package ind.amirali.Controllers;

import ind.amirali.Controllers.apilevelexception.EntityNotFoundException;
import ind.amirali.Services.UserService;
import ind.amirali.domain.UserDTO;
import ind.amirali.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class UserController {

    private final UserService userService;
    private final ResourceAssembler assmbler;
    public UserController(UserService userService, ResourceAssembler assemler) {
        this.assmbler = assemler;
        this.userService = userService;
    }


    @PostMapping("/users")
    public Resource<UserDTO> postForm(@RequestBody UserDTO userDto) {
        User user = userDto.toUser();
        user.setBalance(Math.random() * 100);
        userService.add(user);
        return assmbler.assmble(user);
    }

    @DeleteMapping("/users/{firstName}/{lastName}")
    public Resource<UserDTO> delete(@PathVariable String firstName, @PathVariable String lastName) {
        userService.delete(firstName, lastName);
        User userDto = new User(firstName, lastName);
        return assmbler.assmble(userDto);
    }

    @GetMapping("/users")
    public Resources<Resource<UserDTO>> show() {
        List<Resource<UserDTO>> users = userService.getAll().stream()
                .map(user -> assmbler.assmble(user))
                .collect(Collectors.toList());
        return new Resources<>(users, linkTo(methodOn(UserController.class).show()).withSelfRel());
    }

    @GetMapping("/users/{id}")
    public Resource<UserDTO> getOne(@PathVariable String id) {
        Optional<User> userOptional = userService.get(id);
        User user = userOptional.orElseThrow(() -> new EntityNotFoundException(id));
        return assmbler.assmble(user);
    }

//    @GetMapping("/users/balance/{amount}")
//    public List<User> getBalance(@PathVariable Double amount){
//        return this.userService.getByBalance(amount);
//    }


    @PutMapping("/users/{id}")
    public Resource<UserDTO> update(@PathVariable String id, @RequestBody UserDTO userDto) {
        User user = userDto.toUser();
//        userService.update(id, user.getFirstName(), user.getLastName());
        return assmbler.assmble(user);
    }


}
