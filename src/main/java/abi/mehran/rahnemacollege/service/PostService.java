package abi.mehran.rahnemacollege.service;

import abi.mehran.rahnemacollege.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post add(Post user);

    void delete(Long id);

    List<Post> all();

    Optional<Post> get(Long id);
}
