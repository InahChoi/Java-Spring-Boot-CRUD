package inah.springbootmember.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// Service CRUD class
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 멤버 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 멤버 id 조회
//    public Optional<Member> getMember(Long id) {
//        Optional<Member> member = memberRepository.findById(id);
//        if(!member.isPresent()) throw new RuntimeException("findById, not found :" + id);
//        return memberRepository.findById(id);
    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    // 멤버 등록
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // 멤버 삭제
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    // 멤버 정보 수정
    @Transactional
    public Member updateMember(Long id, Member member) {
        Member memberData = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        memberData.update(member.getName(), member.getAddress());
        return memberData;
    }
}
