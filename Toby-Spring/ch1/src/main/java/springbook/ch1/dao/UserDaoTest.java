package springbook.ch1.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

		UserDao userDao = context.getBean("userDao", UserDao.class);
		UserDao userDao2 = context.getBean("userDao", UserDao.class);

		System.out.println("userDao = " + userDao);
		System.out.println("userDao2 = " + userDao2);
		DaoFactory factory = new DaoFactory();
		UserDao dao1 = factory.userDao();
		UserDao dao2 = factory.userDao();

		System.out.println("dao1 = " + dao1);
		System.out.println("dao2 = " + dao2);
	}
}
