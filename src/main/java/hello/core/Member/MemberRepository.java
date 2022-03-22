package hello.core.Member;

public interface MemberRepository {

     void save(Member member);

     Member findById(Long memberId);
     //객체로 반환한다는 얘기일까?

}
