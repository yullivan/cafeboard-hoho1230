package cafeboard.Comment;

import cafeboard.Post.Post;
import cafeboard.Post.PostRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CommentService {
    private final CommentRepository repository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }


    public Comment create(CreateCommentRequest request) {
        Post post = postRepository.findById(request.postId())
                .orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다.:" + request.postId()));
       return repository.save(new Comment(request.content(),request.writer(),post));
    }
}
