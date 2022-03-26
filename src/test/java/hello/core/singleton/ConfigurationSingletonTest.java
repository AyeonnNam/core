package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        //같은 인스턴스 조회
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean);

        //bean = hello.core.AppConfig$$EnhancerBySpringCGLIB$$ee4ff54b@52d645b1
        /* 클래스명 이외에도 이상한게 있음
         * hello.core.AppConfig = 순수한 클래스 명
         * bean = hello.core.AppConfig$$EnhancerBySpringCGLIB$$ee4ff54b@52d645b1
         * 다른걸 빈으로 등록 (내가 만든게 아니라 바이트코드를 스프링이 조작해 appconfig를 상속받은 임의의 클래스를 등록한 것.)
         * 내가 만든 건 사라지고 appconfig란 이름으로 다른 임의의 개체가 싱글톤이 될 수 있도록 보장해주는 것.
         * */
    }
}
