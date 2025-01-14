package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Board.BoardRepository;
import cafeboard.Board.CreateBoardRequest;
import cafeboard.Comment.ReadCommentResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    private final PostRepository repository;
    private final BoardRepository boardRepository;


    public PostService(PostRepository repository, BoardRepository boardRepository) {
        this.repository = repository;
        this.boardRepository = boardRepository;
    }

    public void create(CreatePostRequest request) {
        Board board = boardRepository.findById(request.boardId()).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다: " + request.boardId()));
        repository.save(new Post(request.title(), request.content(), request.writer(), board));
    }

    public List<ReadPostResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(post -> new ReadPostResponse(
                        post.getId(),
                        post.getTitle(),
                        post.getBoard().getId(),
                        post.getWriter(),
                        post.getCreateTime(),
                        post.getCommentCount()))
                .toList();
    }
    public List<ReadPostResponse> findByboardId(Long boardId) {
        return repository.findAll()
                .stream()
                .filter(post -> post.getBoard().getId()==boardId)
                .map(post -> new ReadPostResponse(
                        post.getId(),
                        post.getTitle(),
                        post.getBoard().getId(),
                        post.getWriter(),
                        post.getCreateTime(),
                        post.getCommentCount()))
                .toList();
    }
    public PostIdResponse findById(Long id) {
        Post post = repository.findById(id).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다. :" + id));
        Board board = boardRepository.findById(post.getBoard().getId()).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다. :" + id));
        return new PostIdResponse(
                post.getId(),
                post.getTitle(),
                post.getContent()
                , new CreateBoardRequest(
                board.getTitle()),
                post.getCreateTime(),
                post.getWriter(),
                post.getCommentList()
                        .stream()
                        .map(comment -> new ReadCommentResponse(
                                comment.getId(),
                                comment.getContent(),
                                comment.getWriter()))
                        .toList());
    }


    @Transactional
    public void update(Long id, updatePostRequest request) {
        Post post = repository.findById(id).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다: " + id));
        if (request.writer().equals(post.getWriter())) {
            Board board = boardRepository.findById(request.boardId()).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다. :" + id));
            post.change(request);
            post.setBoard(board);
        } else throw new RuntimeException("작성자가 동일하지 않습니다");
    }

    @Transactional
    public void deleteById(Long postId, writerRequest request) {
        Post post = repository.findById(postId).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다: " + postId));
        if (request.writer().equals(post.getWriter())) {
            repository.deleteById(postId);
        } else throw new RuntimeException("작성자가 동일하지 않습니다");
    }


}
