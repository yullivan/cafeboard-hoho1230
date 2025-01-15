package cafeboard.Member;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static cafeboard.SecurityUtils.sha256EncryptHex2;

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
                sha256EncryptHex2(request.password()),
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

    @Transactional
    public void update(String memberId,UpdateMemberRequest request) {
        Member member = memberRespository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다." + memberId));
        if(sha256EncryptHex2(request.password()).equals(member.getPassword())){
            member.update(request);
        }else throw new IllegalArgumentException("비밀번호가 다릅니다");
    }
    @Transactional
    public void deleteById(String memberId,PasswordRequset request) {
        Member member = memberRespository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("id를 찾을 수 없습니다." + memberId));
        if(sha256EncryptHex2(request.password()).equals(member.getPassword())){
            memberRespository.deleteById(sha256EncryptHex2(memberId));
        }else throw new IllegalArgumentException("비밀번호가 다릅니다");
    }

}
