package hello.core.Member;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class MemberServiceTest {

    MemberService memberService;
    @Test
    void join(){
        //회원가입. 회원조회

        //given
        Member member = new Member(1L, Grade.VIP,"남아연");

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }



}
