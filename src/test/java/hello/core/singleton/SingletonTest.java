package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService = " + memberService );

        assertThat(memberService).isNotSameAs(memberService1);
    }

    @Test
    @DisplayName("싱글톤패턴적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService instance = SingletonService.getInstance();

        SingletonService instance1 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance = " + instance);

        //isEqualTo(자바equals), isSameAs (참조비교)
        assertThat(instance1).isSameAs(instance);
    }
}
