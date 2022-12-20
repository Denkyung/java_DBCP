package backups;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbConn_221216 {
	
	
	
	private String driver = "org.mariadb.jdbc.Driver";
	private String DB_URL = "jdbc:mariadb://localhost:3306/assignment";
	private String DB_user = "root";
	private String DB_pwd = "1234";
	
	
	Connection conn = null;
	Statement stm = null ;
	ResultSet rs = null;
	
	
	public Connection dbConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL, DB_user, DB_pwd);
			}catch (ClassNotFoundException e) {
				System.out.println("드라이버 로드 실패");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB 접속 실패");
				e.printStackTrace();
			}
		return conn;
	}	//클래스 1로 분해
}
