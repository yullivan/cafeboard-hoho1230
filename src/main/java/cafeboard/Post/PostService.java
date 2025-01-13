package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Board.BoardRepository;
import cafeboard.Board.CreateBoardRequest;
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
        Board board = boardRepository.findById(request.boardId()).orElseThrow(()->new NoSuchElementException("id를 찾을 수 없습니다: "+request.boardId()));
        repository.save(new Post(request.title(),request.content(), request.writer(), board));
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
    public PostIdResponse findById(Long id){
        Post post = repository.findById(id).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다. :" + id));
        Board board = boardRepository.findById(post.getBoard().getId()).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다. :" + id));
        return new PostIdResponse(post.getId(),post.getTitle(),post.getContent()
                ,new CreateBoardRequest(board.getTitle()),post.getCreateTime(),post.getWriter(),post.getCommentList());
    }
}
