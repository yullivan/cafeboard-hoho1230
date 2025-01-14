package cafeboard.Comment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
