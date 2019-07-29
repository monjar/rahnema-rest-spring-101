package abi.mehran.rahnemacollege.domain;

import abi.mehran.rahnemacollege.model.Post;
import abi.mehran.rahnemacollege.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostOutputComplete {
    private Long id;
    private String title;
    private String body;
    private User user;

    public static PostOutputComplete fromPost(Post post) {
        PostOutputComplete dto = new PostOutputComplete();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setUser(post.getUser());
        return dto;
    }

    public Post toPost() {
        Post post = new Post();
        post.setId(this.getId());
        post.setTitle(this.getTitle());
        post.setBody(this.getBody());
        post.setUser(this.getUser());
        return post;
    }
}
