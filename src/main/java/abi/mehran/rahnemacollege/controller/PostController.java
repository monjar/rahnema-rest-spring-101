package abi.mehran.rahnemacollege.controller;

import abi.mehran.rahnemacollege.domain.PostOutputComplete;
import abi.mehran.rahnemacollege.domain.PostOutputLite;
import abi.mehran.rahnemacollege.model.Post;
import abi.mehran.rahnemacollege.service.PostService;
import abi.mehran.rahnemacollege.util.assembler.PostResourceAssembler;
import abi.mehran.rahnemacollege.util.exception.EntityNotFoundException;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PostController {

    private final PostService service;
    private final PostResourceAssembler assembler;

    public PostController(PostService service, PostResourceAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/posts")
    public Resources<Resource<PostOutputLite>> all() {
        List<Resource<PostOutputLite>> posts = service.all().stream()
                .map(this.assembler::assemble)
                .collect(Collectors.toList());
        return new Resources<>(posts, linkTo(methodOn(PostController.class).all()).withSelfRel());
    }

    @PostMapping("/posts")
    public Resource<PostOutputLite> add(@RequestBody PostOutputComplete postDTO) {
        Post post = this.service.add(postDTO.toPost());
        return this.assembler.assemble(post);
    }

    @GetMapping("/post/{id}")
    public Resource<PostOutputLite> one(@PathVariable Long id) {
        Optional<Post> optionalPost = service.get(id);
        Post post = optionalPost.orElseThrow(() -> new EntityNotFoundException(id));
        return this.assembler.assemble(post);
    }

    @DeleteMapping("/post/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
