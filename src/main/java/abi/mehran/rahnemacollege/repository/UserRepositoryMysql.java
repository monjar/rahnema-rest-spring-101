package abi.mehran.rahnemacollege.repository;

import abi.mehran.rahnemacollege.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryMysql extends CrudRepository<User, Long> {
}
