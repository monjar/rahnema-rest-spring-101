package abi.mehran.rahnemacollege;

import abi.mehran.rahnemacollege.model.Post;
import abi.mehran.rahnemacollege.model.User;
import abi.mehran.rahnemacollege.repository.PostRepositoryMysql;
import abi.mehran.rahnemacollege.repository.UserRepositoryMysql;
import com.github.javafaker.Faker;
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

        for (int i = 0; i < 10; i++) {
            Faker faker1 = new Faker();
            User user = new User();
            user.setFirstName(faker1.name().firstName());
            user.setLastName(faker1.name().lastName());
            userRepository.save(user);
            for (int j = 0; j < 10; j++) {
                Faker faker2 = new Faker();
                Post post = new Post();
                post.setTitle(faker2.book().title());
                post.setBody(faker2.lorem().paragraph());
                post.setUser(user);
                postRepository.save(post);
            }
        }
    }
}
