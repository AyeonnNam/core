package hello.core.singleton;

public class StatefulService {

//지역변수로 바꿔버리기
   // private int price; //상태를 유지하는 필드

    public int order(String name, int price){

        System.out.println("name = " + name + ",price = " + price) ;
       // this.price = price;
        return price;

    }

//    public int getPrice(){
//        return price;
//    }
}
