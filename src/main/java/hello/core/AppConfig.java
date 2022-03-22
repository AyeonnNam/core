package hello.core;

import hello.core.Member.MemberRepository;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//순수 자바 코드에서 스프링으로 전환하기
@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService(){
       return new MemberServiceImpl( memberRepository());

   }


    @Bean
    public OrderService orderService(){
       return new OrderServiceImpl(memberRepository(),
               discountPolicy());
   }


 @Bean
    public MemberRepository memberRepository(){
     return new MemoryMemberRepository();
   }

 @Bean
    public DiscountPolicy discountPolicy(){
     return new RateDiscountPolicy();
   }
}
