package abi.mehran.rahnemacollege.util.assembler;

import abi.mehran.rahnemacollege.controller.PostController;
import abi.mehran.rahnemacollege.domain.PostOutputLite;
import abi.mehran.rahnemacollege.model.Post;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PostResourceAssembler {
    public Resource<PostOutputLite> assemble(Post post) {
        return new Resource<>(PostOutputLite.fromPost(post),
                linkTo(methodOn(PostController.class).one(post.getId())).withSelfRel(),
                linkTo(methodOn(PostController.class).all()).withRel("all")
        );
    }
}
