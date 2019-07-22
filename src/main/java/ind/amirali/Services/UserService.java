package ind.amirali.Services;

import ind.amirali.Repository.PersonRepository;
import ind.amirali.Repository.UserDAO;
import ind.amirali.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final PersonRepository repository;
    public UserService(PersonRepository repository) {
        this.repository = repository;
    }

    public void add(User user){
        this.repository.save(user);
    }
    public List<User> getAll(){
        return this.repository.findAll();
    }

    public  User get(String id){
//         return this.repository.findOne(Example.of(new User(id))).get();
        if (this.repository.findById(id).isPresent())
            return this.repository.findById(id).get();
        else
            return null;
    }

    public List<User> getByBalance(Double balance){
        return this.repository.findByBalanceGreaterThan(balance);
//        return this.repository.findByBalanceIsGreaterThan(balance);

    }

    public  void delete(String fisrtName, String lastName) {
        String id = this.repository.findOne(Example.of(new User(fisrtName, lastName))).get().getId();
        this.repository.deleteById(id);
    }
    /*public  void delete(int i) {
        this.userDAO.delete(i);
    }
    public  void update(int index, String fisrtName, String lastName){
        this.userDAO.update(index, fisrtName, lastName);
    }*/
}
