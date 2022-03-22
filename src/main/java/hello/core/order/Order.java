package hello.core.order;

public class Order {


    private Long memberId; //멤버 아이디 (vip확인용)
    private String itemName; //구매 아이템
    private int itemPrice; //아이템 가격
    private int discountPrice; //

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itemPrice - discountPrice;
    }


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }


    /*toString () 은 객체의 문자열 / 텍스트 표현을 반환합니다.
    디버깅, 로깅 등과 같은 진단 목적으로 일반적으로 사용되는
    toString () 메서드는 객체에 대한 의미있는 세부 정보를 읽는 데 사용됩니다.
    *
    * */
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';

    }
}
