package springbook.ch1.dao;

public class UserDaoTest {

	public static void main(String[] args) {
		DConnectionMaker connectionMaker = new DConnectionMaker();

		UserDao dao = new UserDao(connectionMaker);
	}
}
