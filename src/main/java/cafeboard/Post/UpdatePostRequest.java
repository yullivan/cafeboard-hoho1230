package cafeboard.Post;

public record UpdatePostRequest(
        String title,
        String content,
        Long boardId,
        String writer
        ) {
}
