package cafeboard.Post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/posts")
    public void create(@RequestBody CreatePostRequest request){
        postService.create(request);
    }

    @GetMapping("/posts")
    public List<ReadPostResponse> read(@RequestParam(required = false) Long boardId){
        if(boardId!=null){
            return postService.findByboardId(boardId);
        }
            return postService.findAll();
    }

    @GetMapping("/posts/{postId}")
    public PostDetailResponse findById(@PathVariable Long postId){
        return postService.findById(postId);
    }

    @PutMapping("/posts/{postId}")
    public void update(@PathVariable Long postId,@RequestBody UpdatePostRequest request){
        postService.update(postId,request);
    }
    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable Long postId,@RequestBody WriterRequest request){
        postService.deleteById(postId,request);
    }
}
