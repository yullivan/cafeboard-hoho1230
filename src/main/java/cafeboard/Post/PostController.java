package cafeboard.Post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
