package cafeboard.Board;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/boards")
    public List<ReadBoardResponse> read(){
        return SERVICE.findAll();
    }
    @PutMapping("/boards/{boardId}")
    public Board update(@PathVariable Long boardId,@RequestBody CreateBoardRequest request){
        return SERVICE.update(boardId,request);
    }

}
