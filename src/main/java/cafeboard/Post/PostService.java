package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Board.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    private final PostRepository Repository;
    private final BoardRepository boardRepository;


    public PostService(PostRepository repository, BoardRepository boardRepository) {
        Repository = repository;
        this.boardRepository = boardRepository;
    }

    public void create(CreatePostRequest request) {
        Board board = boardRepository.findById(request.boardId()).orElseThrow(()->new NoSuchElementException("id를 찾을 수 없습니다: "+request.boardId()));
        Repository.save(new Post(request.title(),request.content(), request.writer(), board));
    }

    public List<ReadPostResponse> findAll() {

        return Repository.findAll()
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
}
