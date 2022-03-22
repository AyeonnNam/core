package hello.core.Member;

public class Member {

    private Long id;
    private Grade grade;
    private String name;

    /*인스턴스 변수의 초기화
        클래스를 가지고 객체를 생성하면, 해당 객체는 메모리에 즉시 생성됩니다.
        하지만 이렇게 생성된 객체는 모든 인스턴스 변수가 아직 초기화되지 않은 상태입니다.
        자바에서 클래스 변수와 인스턴스 변수는 별도로 초기화하지 않으면, 다음 값으로 자동 초기화됩니다.
    * 하지만 사용자가 원하는 값으로 인스턴스 변수를 초기화하려면, 일반적인 초기화 방식으로는 초기화할 수 없습니다.
        인스턴스 변수 중에는 private 변수도 있으며, 이러한 private 변수에는
         사용자나 프로그램이 직접 접근할 수 없기 때문입니다.
        따라서 private 인스턴스 변수에도 접근할 수 있는 초기화만을 위한 public 메소드가 필요해집니다.
        이러한 초기화만을 위한 메소드는 객체가 생성된 후부터 사용되기 전까지
        반드시 인스턴스 변수의 초기화를 위해 호출되어야 합니다.

        생성자(constructor)
    자바에서는 객체의 생성과 동시에 인스턴스 변수를 원하는 값으로
    초기화할 수 있는 생성자(constructor)라는 메소드를 제공합니다.

    자바에서 생성자(constructor)의 이름은 해당 클래스의 이름과 같아야 합니다.
        즉, Car 클래스의 생성자의 이름은 Car가 됩니다.

        이러한 생성자는 다음과 같은 특징을 가집니다.
    1. 생성자는 반환값이 없지만, 반환 타입을 void형으로 선언하지 않습니다.
    2. 생성자는 초기화를 위한 데이터를 인수로 전달받을 수 있습니다.
    3. 객체를 초기화하는 방법이 여러 개 존재할 경우에는 하나의 클래스가 여러 개의 생성자를 가질 수 있습니다.
            즉, 생성자도 하나의 메소드이므로, 메소드 오버로딩이 가능하다는 의미입니다.
    * */
    public Member(Long id, Grade grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    /*getter setter는 객체의 데이터에 직접 접근하지 않고 메소드를 통해 데이터에 접근,변경한다.

    setter
    외부에서 메소드를 통해 데이터에 접근하면, 메소드는 매개값을 검증해서 유효한 값만 데이터로 저장할 수 있다.

    getter
    데이터 복사본을 던져주기 때문에 원래 객체의 데이터를 손상시키지 않는다.
    따라서 원본 데이터는 안전하다. 간단하게 생성자를 통해서만 데이터를 넣어줄 수 있고
    getter 메소드만 있다면( 물론 인스턴스 변수가 기본 자료형이나
    String인 경우) 외부에서는 객체의 원본 데이터를 변경할 수 없게 된다.


    *
    * */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
