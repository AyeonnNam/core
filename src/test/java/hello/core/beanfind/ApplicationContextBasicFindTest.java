package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        assertThat(orderService).isInstanceOf(OrderServiceImpl.class);

    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        OrderService orderService = ac.getBean(OrderService.class);
        assertThat(orderService).isInstanceOf(OrderServiceImpl.class);
    }


    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2(){
        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        assertThat(bean).isInstanceOf(OrderServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회x")
    void findByNameX(){
        //Object xxxx = ac.getBean("xxx");
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxx")) ;

    }

}
