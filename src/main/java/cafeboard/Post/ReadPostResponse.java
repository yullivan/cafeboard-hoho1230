package cafeboard.Post;

import cafeboard.Board.Board;

import java.time.LocalDateTime;

public record ReadPostResponse(
        Long id,
        String title,
        Long boardId,
        String writerNickname,
        LocalDateTime createdTime,
        int commentCount
) {
}
