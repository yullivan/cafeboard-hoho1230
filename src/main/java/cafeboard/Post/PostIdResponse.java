package cafeboard.Post;

import cafeboard.Board.CreateBoardRequest;
import cafeboard.Comment.Comment;
import cafeboard.Comment.ReadCommentResponse;

import java.time.LocalDateTime;
import java.util.List;

public record PostIdResponse (
        Long id,
        String title,
        String content,
        CreateBoardRequest board,
        LocalDateTime createdTime,
        String writer,
        List<ReadCommentResponse> commentList
){
}
