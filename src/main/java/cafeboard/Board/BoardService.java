package cafeboard.Board;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
