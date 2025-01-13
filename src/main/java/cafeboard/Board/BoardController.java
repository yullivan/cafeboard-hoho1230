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
    public void create(@RequestBody CreateBoardRequest request){
         SERVICE.create(request);
    }
    @GetMapping("/boards")
    public List<ReadBoardResponse> read(){
        return SERVICE.findAll();
    }
    @PutMapping("/boards/{boardId}")
    public void update(@PathVariable Long boardId,@RequestBody CreateBoardRequest request){
         SERVICE.update(boardId,request);
    }
    @DeleteMapping("/boards/{boardId}")
    public void delete(@PathVariable Long boardId){
         SERVICE.deleteById(boardId);
    }

}
