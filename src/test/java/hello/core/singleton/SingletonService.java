package hello.core.singleton;

public class SingletonService {
    //자기 자신 선언 내부에 private, static으로 가짐, 클래스 레벨이라 딱 하나만 존재, 자바 기본
    private static final SingletonService instance = new SingletonService();

    //조회 시 사용
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() {

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
