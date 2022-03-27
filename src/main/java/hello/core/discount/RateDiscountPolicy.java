package hello.core.discount;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.annotation.MainDiscountPolicy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int DiscountRate = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price/100*DiscountRate;
        }else{return 0;}
    }

}
