package hello.core.scan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;

class AutoAppConfigTest {

	@Test
	void basicScan() throws Exception {
		//given
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		//when
		MemberService memberService = ac.getBean(MemberService.class);

		//then
		assertThat(memberService).isInstanceOf(MemberService.class);

	}

}
