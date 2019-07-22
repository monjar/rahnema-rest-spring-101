package ind.amirali.Repository;

import ind.amirali.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDAO {
    private  List <User> list = new ArrayList<>();

    public UserDAO(){}

    public  List<User> getList() {
        return list;
    }

    public  void add(User user){
        list.add(user);



    }

    public  User get(String fisrtName, String lastName){
        for (User user: list)
            if (user.getFirstName().equals(fisrtName) && user.getLastName().equals(lastName))
                return user;
        return null;
    }

    public  void delete(String fisrtName, String lastName) {
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i).getFirstName().equals(fisrtName) && list.get(i).getLastName().equals(lastName)) {
                list.remove(i);
                break;
            }


        }
    }
    public  void delete(int i) {
        list.remove(i);
    }
    public  void update(int index, String fisrtName, String lastName){
        list.get(index).setFirstName(fisrtName);
        list.get(index).setLastName(lastName);
    }

}
