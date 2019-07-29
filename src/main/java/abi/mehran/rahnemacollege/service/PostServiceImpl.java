package abi.mehran.rahnemacollege.service;

import abi.mehran.rahnemacollege.model.Post;
import abi.mehran.rahnemacollege.repository.PostRepositoryMysql;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepositoryMysql repository;

    public PostServiceImpl(PostRepositoryMysql repository) {
        this.repository = repository;
    }

    public Post add(Post user) {
        return this.repository.save(user);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<Post> all() {
        return Lists.newArrayList(this.repository.findAll());
    }

    public Optional<Post> get(Long id) {
        return this.repository.findById(id);
    }
}
