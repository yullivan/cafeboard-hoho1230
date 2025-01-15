package cafeboard.Member;

public record UpdateMemberRequest(
        String passWord,
        String name,
        String nickname
) {
}
