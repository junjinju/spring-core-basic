package hello.core_self_practice.member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);

}
