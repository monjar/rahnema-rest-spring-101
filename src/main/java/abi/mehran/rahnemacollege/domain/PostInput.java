package abi.mehran.rahnemacollege.domain;

import abi.mehran.rahnemacollege.model.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostInput {
    private String title;
    private String body;

    public static PostInput fromPost(Post post) {
        PostInput dto = new PostInput();
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        return dto;
    }

    public Post toPost() {
        Post post = new Post();
        post.setTitle(this.getTitle());
        post.setBody(this.getBody());
        return post;
    }
}
