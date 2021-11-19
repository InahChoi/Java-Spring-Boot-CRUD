package inah.springbootmember.member;

import org.springframework.data.jpa.repository.JpaRepository;

// interface
public interface MemberRepository extends JpaRepository<Member, Long> {
}
