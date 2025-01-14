package cafeboard.Comment;

public record CreateCommentRequest(
        String content,
        Long postId,
        String writer
) {
}
