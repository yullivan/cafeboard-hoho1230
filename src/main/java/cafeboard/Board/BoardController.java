package cafeboard.Board;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    @PostMapping("/boards")
    public void create(@RequestBody CreateBoardRequest request){
         boardService.create(request);
    }
    @GetMapping("/boards")
    public List<ReadBoardResponse> read(){
        return boardService.findAll();
    }
    @PutMapping("/boards/{boardId}")
    public void update(@PathVariable Long boardId,@RequestBody CreateBoardRequest request){
         boardService.update(boardId,request);
    }
    @DeleteMapping("/boards/{boardId}")
    public void delete(@PathVariable Long boardId){
         boardService.deleteById(boardId);
    }

}
