package cafeboard.Member;

import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("/members")
    public void create(@RequestBody CreateMemberRequest request){
        memberService.create(request);
    }
    @GetMapping("/members/{memberId}")
    public MemberResponse read(@PathVariable String memberId){
        return memberService.findById(memberId);
    }

}
