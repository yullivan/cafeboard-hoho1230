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


    public void update(String memberId,UpdateMemberRequest request) {
        Member member = memberRespository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다." + memberId));
        if(request.passWord().equals(member.getPassWord())){
            member.update(request);
        }else throw new IllegalArgumentException("비밀번호가 다릅니다");
    }
    public void delete(String memberId,UpdateMemberRequest request) {
        Member member = memberRespository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다." + memberId));
        if(request.passWord().equals(member.getPassWord())){
            memberRespository.deleteById(memberId);
        }else throw new IllegalArgumentException("비밀번호가 다릅니다");
    }

}
