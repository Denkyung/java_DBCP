package pack;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn_2
{
	
	
		private static BasicDataSource dataSource;

		static BasicDataSource getDataSource()
		{

				if (dataSource == null)
				{
						BasicDataSource ds = new BasicDataSource();
						ds.setUrl("jdbc:mysql://localhost/assignment");
						ds.setDriverClassName("org.mariadb.jdbc.Driver");
						ds.setUsername("root");
						ds.setPassword("1234");
						ds.setMinIdle(5);
						ds.setMaxIdle(10);
						ds.setMaxOpenPreparedStatements(100);
						dataSource = ds;
				}
				return dataSource;
		}
		
//		private String driver = "org.mariadb.jdbc.Driver";
//		private String DB_URL = "jdbc:mariadb://localhost:3306/assignment";
//		private String DB_user = "root";
//		private String DB_pwd = "1234";
		
		
		Connection conn = null;
		Statement stm = null ;
		ResultSet rs = null;
//		
//		
//		public Connection dbConnection() {
//			try {
//				Class.forName(driver);
//				conn = DriverManager.getConnection(DB_URL, DB_user, DB_pwd);
//				}catch (ClassNotFoundException e) {
//					System.out.println("드라이버 로드 실패");
//					e.printStackTrace();
//				} catch (SQLException e) {
//					System.out.println("DB 접속 실패");
//					e.printStackTrace();
//				}
//			return conn;
//		}	//클래스 1로 분해
}