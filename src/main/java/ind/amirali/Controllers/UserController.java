package ind.amirali.Controllers;

import ind.amirali.Controllers.apilevelexception.EntityNotFoundException;
import ind.amirali.Services.UserService;
import ind.amirali.domain.UserDTO;
import ind.amirali.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/users")
    public UserDTO postForm(@RequestBody UserDTO userDto){
        User user = userDto.toUser();
        user.setBalance(Math.random() * 100);
        userService.add(user);
        return userDto;
    }
    @DeleteMapping("/users/{firstName}/{lastName}")
    public void delete(@PathVariable String firstName, @PathVariable String lastName){
        userService.delete(firstName, lastName);
    }
    @GetMapping("/users")
    public List<User> show() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getOne(@PathVariable String id){
        Optional<User> userOptional =  userService.get(id);
        return userOptional.orElseThrow(()-> new EntityNotFoundException(id));

    }

    @GetMapping("/users/balance/{amount}")
    public List<User> getBalance(@PathVariable Double amount){
        return this.userService.getByBalance(amount);
    }
    @GetMapping("/a")
    public void a() {
        throw new ArithmeticException();
    }


   /*
    @PutMapping("/users/{id}")
    public void update(@PathVariable Integer id, @RequestBody UserDTO userDto){
        User user = userDto.toUser();
        userService.update(id, user.getFirstName(), user.getLastName());
    }*/
}
