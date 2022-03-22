package hello.core.order;

import hello.core.Member.Member;

public interface OrderService {

   Order createOrder(Long memberId, String itemName, int itemPrice);

}


