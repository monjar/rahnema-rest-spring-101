package ind.amirali.Controllers.apilevelexception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String id) {
        super(id + "Not Found");
    }
}
