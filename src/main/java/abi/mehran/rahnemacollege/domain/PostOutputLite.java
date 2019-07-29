package abi.mehran.rahnemacollege.domain;

import abi.mehran.rahnemacollege.model.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostOutputLite {
    private Long id;
    private String title;
    private String body;
    private Long user_id;

    public static PostOutputLite fromPost(Post post) {
        PostOutputLite dto = new PostOutputLite();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setUser_id(post.getUser().getId());
        return dto;
    }

    public Post toPost() {
        Post post = new Post();
        post.setId(this.getId());
        post.setTitle(this.getTitle());
        post.setBody(this.getBody());
        return post;
    }
}
