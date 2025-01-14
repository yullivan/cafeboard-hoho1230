package cafeboard.Comment;

public record ReadCommentResponse(
        Long id,
        String content,
        String writer
) {
}
