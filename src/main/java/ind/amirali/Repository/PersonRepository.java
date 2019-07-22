package ind.amirali.Repository;

import ind.amirali.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<User, String> {
    public List<User> findByBalanceGreaterThan(Double asd);

    public List<User> findByBalanceIsGreaterThan(Double balance);

    @Query("{lastName : {$regex : ?0}}")
    public List<User> finfByRegex(String lastNameRegEx);

}
