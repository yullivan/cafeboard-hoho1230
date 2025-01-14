package cafeboard.Comment;

import cafeboard.Post.Post;
import cafeboard.Post.PostRepository;
import cafeboard.Post.WriterRequest;
import jakarta.transaction.Transactional;
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
        return repository.save(new Comment(request.content(), request.writer(), post));
    }

    @Transactional
    public void update(Long commentId, UpdateCommnetRequest request) {
        Comment comment = repository.findById(commentId).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다.:" + commentId));
        if (request.writer().equals(comment.getWriter())) {
            comment.update(request);
        } else throw new RuntimeException("작성자가 일치하지 않습니다.");

    }

    @Transactional
    public void deleteById(Long commentId, WriterRequest request) {

        if (request.writer().equals(repository.findById(commentId).orElseThrow().getWriter())) {
            repository.deleteById(commentId);
        } else throw new RuntimeException("작성자가 일치하지 않습니다.");
    }
}
