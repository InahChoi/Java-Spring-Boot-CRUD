package inah.springbootmember.member;
// Controller

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // Get Method로 멤버 전체 조회
    @GetMapping
    public List<Member> findMembers() {
        return memberService.findMembers();
    }

    // Get Method로 ID를 URI 인자로 받는 멤버 ID 조회
    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    // Post Method로 멤버 등록
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    // Put Method로 ID를 URI 인자로 받고 Request Body의 값을 통해 멤버 정보 수정
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    // Delete Method로 ID를 URI 인자로 받아 해당 ID 멤버 삭제
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
