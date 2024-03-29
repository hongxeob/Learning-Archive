package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
	@Test
	void statefulServiceSingleton() throws Exception {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService = ac.getBean("statefulService", StatefulService.class);
		StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

		//threadA
		int userA = statefulService.order("userA", 1000);
		int userB = statefulService2.order("userB", 2000);
		System.out.println("userA = " + userA);
//        assertThat(statefulService.getPrice()).isEqualTo(2000);

	}

	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
