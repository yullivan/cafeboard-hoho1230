package cafeboard.Board;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BoardService {
    private final BoardRepository REPOSITORY;

    public BoardService(BoardRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    public Board create( CreateBoardRequest request) {
        return REPOSITORY.save(new Board(request.title()));
    }
}
