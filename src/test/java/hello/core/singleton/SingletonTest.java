package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService = " + memberService );

        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }
}
