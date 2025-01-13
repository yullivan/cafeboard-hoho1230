package cafeboard.Post;

import cafeboard.Board.CreateBoardRequest;

public record updatePostRequest(
        String title,
        String content,
        Long boardId,
        String writer
        ) {
}
