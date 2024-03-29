package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링X 순수 DI 컨테이너")
    void pureContainer() throws Exception {
        //given
        AppConfig appConfig = new AppConfig();
        //when
        MemberService memberService = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        //then
        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService).isNotSameAs(memberService2);
    }
}
