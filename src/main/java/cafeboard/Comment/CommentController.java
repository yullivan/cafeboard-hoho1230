package cafeboard.Comment;

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
}
