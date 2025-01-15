package cafeboard.Board;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board create( CreateBoardRequest request) {
        return boardRepository.save(new Board(request.title()));
    }

    public List<ReadBoardResponse> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(board -> new ReadBoardResponse(
                        board.getId(),
                        board.getTitle(),
                        board.getCreateTime()))
                .toList();

    }
@Transactional
    public Board update(Long boardId, CreateBoardRequest request) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다.: " + boardId));
        board.updateAll(request.title());
        return  board;
    }

    public void deleteById(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
