package hello.Bulletin_board.controller;

import hello.Bulletin_board.dto.PostDto;
import hello.Bulletin_board.repository.PostRepository;
import hello.Bulletin_board.service.PostWriteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private PostRepository postRepository;
    private PostWriteService postWriteService;

    public PostController(PostWriteService postWriteService) {
        this.postWriteService = postWriteService;
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "안녕하세요";
    }

    @PostMapping("/api/write")
    public PostDto createPost(@RequestBody PostDto postdto) {
        return postWriteService.create(postdto);
    }

    @PostMapping("/api/update")
    public PostDto updatePost(@RequestBody PostDto postdto) {
        return postWriteService.update(postdto);
    }

    @DeleteMapping("/api/delete/{title}")
    public void deletePost(@PathVariable String title) {
        postWriteService.delete(title);
    }
}
