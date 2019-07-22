package ind.amirali.Repository;

import ind.amirali.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<User, String> {
    public List<User> findByBalanceGreaterThan(Double balance);

    public List<User> findByBalanceIsGreaterThan(Double balance);

}
