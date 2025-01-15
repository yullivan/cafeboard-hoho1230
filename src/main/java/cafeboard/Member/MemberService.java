package cafeboard.Member;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MemberService {
    private final MemberRespository memberRespository;

    public MemberService(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    public void create(CreateMemberRequest request) {
        memberRespository
                .save(new Member(
                request.id(),
                request.passWord(),
                request.name(),
                request.nickname()));

    }

    public MemberResponse findById(String memberId) {
        Member member = memberRespository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다." + memberId));
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getNickname());
    }

}
