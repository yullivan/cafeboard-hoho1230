package cafeboard.Board;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    private final BoardService SERVICE;

    public BoardController(BoardService SERVICE) {
        this.SERVICE = SERVICE;
    }
    @PostMapping("/boards")
    public Board create(@RequestBody CreateBoardRequest request){
        return SERVICE.create(request);
    }

}
