package abi.mehran.rahnemacollege.util.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super("Entity with id " + id + " not found");
    }
}
