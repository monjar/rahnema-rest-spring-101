package abi.mehran.rahnemacollege;

import abi.mehran.rahnemacollege.model.Post;
import abi.mehran.rahnemacollege.model.User;
import abi.mehran.rahnemacollege.repository.PostRepositoryMysql;
import abi.mehran.rahnemacollege.repository.UserRepositoryMysql;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class App implements CommandLineRunner {
    private final UserRepositoryMysql userRepository;
    private final PostRepositoryMysql postRepository;

    public App(UserRepositoryMysql userRepository, PostRepositoryMysql postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User user = new User();
        user.setFirstName("Mehran");
        user.setLastName("Abghari");

        userRepository.save(user);

        Post post = new Post();
        post.setTitle("Salam");
        post.setBody("This is a greeting post!");
        post.setUser(user);

        postRepository.save(post);
    }
}
