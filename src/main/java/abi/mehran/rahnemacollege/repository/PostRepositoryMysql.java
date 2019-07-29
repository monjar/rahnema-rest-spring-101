package abi.mehran.rahnemacollege.repository;

import abi.mehran.rahnemacollege.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepositoryMysql extends CrudRepository<Post, Long> {
}
