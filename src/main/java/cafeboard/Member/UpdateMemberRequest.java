package cafeboard.Member;

public record UpdateMemberRequest(
        String password,
        String name,
        String nickname
) {
}
