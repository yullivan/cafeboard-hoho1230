package cafeboard.Post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService SERVICE;

    public PostController(PostService SERVICE) {
        this.SERVICE = SERVICE;
    }
    @PostMapping("/posts")
    public void create(@RequestBody CreatePostRequest request){
        SERVICE.create(request);
    }
    @GetMapping("/posts")
    public List<ReadPostResponse> read(){
        return SERVICE.findAll();
    }
    @GetMapping("/posts/{postId}")
    public PostIdResponse findById(@PathVariable Long postId){
        return SERVICE.findById(postId); 
    }
    @PutMapping("/posts/{postId}")
    public void update(@PathVariable Long postId,@RequestBody updatePostRequest request){
        SERVICE.update(postId,request);
    }
    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable Long postId){
        SERVICE.deleteById(postId);
    }
}
