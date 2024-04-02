package springbook.ch1.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		//D사의 독자적인 방법으로 커넥션을 생성하는 코드
		return null;
	}
}
