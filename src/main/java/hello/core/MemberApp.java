package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //회원가입
    public static void main(String[] args) {
     //이게 핵심인듯 내가 memberServiceImpl도 알아야함
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        // MemberService memberService = new MemberServiceImpl(memberRepository);
        //왜 id값에 L도 같이 표시해줘야 하나
        Member member = new Member(1L, Grade.VIP,"남아연");

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member : " +  member.getName() + member.getGrade()+ member.getId());

        System.out.println("findMember : " + findMember.getGrade() + findMember.getName());
    }
}
