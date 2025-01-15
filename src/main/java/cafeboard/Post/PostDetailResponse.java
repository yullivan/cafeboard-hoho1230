package cafeboard.Post;

import cafeboard.Board.CreateBoardRequest;
import cafeboard.Comment.ReadCommentResponse;

import java.time.LocalDateTime;
import java.util.List;

public record PostDetailResponse(
        Long id,
        String title,
        String content,
        CreateBoardRequest board,
        LocalDateTime createdTime,
        String writerNickname,
        List<ReadCommentResponse> commentList
){
}
