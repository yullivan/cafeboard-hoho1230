package cafeboard.Board;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BoardService {
    private final BoardRepository REPOSITORY;

    public BoardService(BoardRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    public Board create( CreateBoardRequest request) {
        return REPOSITORY.save(new Board(request.title()));
    }

    public List<ReadBoardResponse> findAll() {
        return REPOSITORY.findAll()
                .stream()
                .map(board -> new ReadBoardResponse(
                        board.getId(),
                        board.getTitle(),
                        board.getCreateTime()))
                .toList();

    }

    public Board update(Long boardId, CreateBoardRequest request) {
        Board board = REPOSITORY.findById(boardId).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다.: " + boardId));
        board.updateAll(request.title());
        REPOSITORY.save(board);
        return  board;
    }

    public void deleteById(Long boardId) {
        REPOSITORY.deleteById(boardId);
    }
}
