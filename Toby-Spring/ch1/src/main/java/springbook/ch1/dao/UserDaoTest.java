package springbook.ch1.dao;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao dao = new DaoFactory().userDao();
	}
}
