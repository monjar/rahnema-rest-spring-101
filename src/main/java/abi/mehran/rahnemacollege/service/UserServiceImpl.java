package abi.mehran.rahnemacollege.service;

import abi.mehran.rahnemacollege.model.User;
import abi.mehran.rahnemacollege.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User add(User user) {
        return this.repository.save(user);
    }

    public void delete(String id) {
        this.repository.deleteById(id);
    }

    public List<User> all() {
        return this.repository.findAll();
    }

    public Optional<User> get(String id) {
        return this.repository.findById(id);
    }
}
