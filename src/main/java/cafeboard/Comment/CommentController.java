package cafeboard.Comment;

import cafeboard.Post.writerRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }
    @PostMapping("/comments")
    public void create(@RequestBody CreateCommentRequest request){
        service.create(request);
    }
    @PutMapping("/comments/{commentId}")
    public void update(@PathVariable Long commentId,@RequestBody updateCommnetRequest request){
        service.update(commentId,request);
    }
    @DeleteMapping("/comments/{commentId}")
    public void delete(@PathVariable Long commentId, @RequestBody writerRequest request){
        service.deleteById(commentId,request);
    }
}
