package abi.mehran.rahnemacollege.controller;

import abi.mehran.rahnemacollege.domain.UserInput;
import abi.mehran.rahnemacollege.model.User;
import abi.mehran.rahnemacollege.service.UserServiceImpl;
import abi.mehran.rahnemacollege.util.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> all() {
        return service.all();
    }

    @PostMapping("/users")
    public User add(@RequestBody UserInput userInput) {
        User user = userInput.toUser();
        return service.add(user);
    }

    @GetMapping("/user/{id}")
    public User one(@PathVariable String id) {
        Optional<User> optionalUser = service.get(id);
        return optionalUser.orElseThrow(() -> new EntityNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
