package cafeboard.Member;

public record CreateMemberRequest(
        String id,
        String password,
        String name,
        String nickname
) {
}
