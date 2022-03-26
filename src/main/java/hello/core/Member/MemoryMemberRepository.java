package hello.core.Member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

/*
MemoryMemberRepository에 store를 static 변수로 선언하셨는데요.

그 이유가 현재, MemoryServiceImpl과 OrderServiceImpl 에서 생성하는
 MemoryMemberRepository가 singleton이 아니기 때문에 datasource를
  static 메모리에 올려 같이 사용하도록 한 것인가요??

만약 스프링을 사용하여 빈을 주입하면 싱글톤이기 때문에 static 변수로
선언하지 않고 사용할 수 있는건가요?? 답은 ok.

*/

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member)
    {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId)
    {
        return store.get(memberId);
    }
}

