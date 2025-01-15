package cafeboard.Post;

import cafeboard.Member.ReadMemberResponse;

public record UpdatePostRequest(
        String title,
        String content,
        Long boardId,
        String writerNickname
        ) {
}
