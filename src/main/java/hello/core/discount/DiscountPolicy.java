package hello.core.discount;

import hello.core.Member.Member;

public interface DiscountPolicy {

    /* @return 할인 대상 금액
    *
    * */

    //구현을 하지는 않는다 {}가 필요없다 , 리턴타입, 메소드명, 파라미터값까지만 설정
    int discount(Member member, int price);
}
