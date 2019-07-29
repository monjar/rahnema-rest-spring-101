package abi.mehran.rahnemacollege.service;

import abi.mehran.rahnemacollege.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);

    void delete(String id);

    List<User> all();

    Optional<User> get(String id);
}
