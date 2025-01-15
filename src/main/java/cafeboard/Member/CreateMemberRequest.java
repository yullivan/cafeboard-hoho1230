package cafeboard.Member;

public record CreateMemberRequest(
        String id,
        String passWord,
        String name,
        String nickname
) {
}
