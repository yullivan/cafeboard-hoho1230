package cafeboard.Post;

import cafeboard.Board.Board;

public record CreatePostRequest(
        String title,
        String content,
        String writer,
        Long boardId
) {
}
