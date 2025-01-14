package cafeboard.Comment;

import cafeboard.Post.WriterRequest;
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
    public void update(@PathVariable Long commentId,@RequestBody UpdateCommnetRequest request){
        service.update(commentId,request);
    }
    @DeleteMapping("/comments/{commentId}")
    public void delete(@PathVariable Long commentId, @RequestBody WriterRequest request){
        service.deleteById(commentId,request);
    }
}
