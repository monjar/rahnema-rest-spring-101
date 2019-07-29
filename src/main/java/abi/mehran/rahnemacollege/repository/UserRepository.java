package abi.mehran.rahnemacollege.repository;

import abi.mehran.rahnemacollege.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
