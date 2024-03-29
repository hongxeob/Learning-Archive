package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
    @Test
    @DisplayName("싱글톤 패턴 적용")
    void singletonServiceTest() throws Exception {
        //given
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();
        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
        assertThat(instance1).isSameAs(instance2);
        instance1.logic();
    }
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService).isSameAs(memberService2);

        //when

        //then

    }
}
