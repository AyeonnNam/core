package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class prototypeTest {

   @Test
   void prototypeBeanFind(){
       AnnotationConfigApplicationContext ac =
               new AnnotationConfigApplicationContext(prototypeBean.class);

       System.out.println("find prototypeBean1");
       prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);

       System.out.println("find prototypeBean2");
       prototypeBean prototypeBean2=  ac.getBean(prototypeBean.class);
       System.out.println("prototypeBean1 = " + prototypeBean1);
       System.out.println("prototypeBean2 = " + prototypeBean2);
       Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
       ac.close();
   }

    @Scope("prototype")
    //component scan없어도 바로 스프링 빈에 등록함.
    static class prototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototypeBean.destroy");
        }

    }
}
