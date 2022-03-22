package hello.core;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {


    public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        // MemberService memberService = new MemberServiceImpl(memberRepository);
       // OrderService orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());




        long memberId = 1L;
        Member member = new Member(memberId, Grade.VIP, "SKADKDUS");
        memberService.join(member);

        Order order1 = orderService.createOrder(memberId, "snack", 10000);

        System.out.println("order" +  order1);



    }
}
