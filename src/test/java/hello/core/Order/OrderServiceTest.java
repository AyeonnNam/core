package hello.core.Order;

import hello.core.AppConfig;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    //beforeEach 왜 쓰는 지
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig  = new AppConfig();
         orderService = appConfig.orderService();
         memberService = appConfig.memberService();
    }
   // MemberService memberService = new MemberServiceImpl(memberRepository);
   // OrderService orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());

    @Test
    void createOrder(){
        long memberId = 1L;

        Member member = new Member(memberId, Grade.VIP,"남아연");

        memberService.join(member);

        Order order = orderService.createOrder(memberId,"snack",20000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);

        System.out.println("order = " + order);

         }

}
