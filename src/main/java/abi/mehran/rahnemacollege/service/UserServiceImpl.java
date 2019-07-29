package abi.mehran.rahnemacollege.service;

import abi.mehran.rahnemacollege.model.User;
import abi.mehran.rahnemacollege.repository.UserRepositoryMysql;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryMysql repository;

    public UserServiceImpl(UserRepositoryMysql repository) {
        this.repository = repository;
    }

    public User add(User user) {
        return this.repository.save(user);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<User> all() {
        return Lists.newArrayList(this.repository.findAll());
    }

    public Optional<User> get(Long id) {
        return this.repository.findById(id);
    }
}
