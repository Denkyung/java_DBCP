package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.apache.commons.dbcp2.BasicDataSource;



import javax.sql.DataSource;

public class ResourceDao {

	PreparedStatement pstmt = null;
	Statement stm = null;
	ResultSet rs = null;
	//DbConn_2 dc = new DbConn_2();
	//Connection conn = dc.dbConnection();
	

	

////////////DBCP를 위해 추가함 ////////////////
//	private static ResourceDao instance;
//	private DataSource ds;
//	
//	
//
//	public static ResourceDao getInstance() {
//		synchronized (ResourceDao.class) {
//			if (instance == null) {
//				instance = new ResourceDao();
//			}
//		}
//		return instance;
//	}
///////////////////////////////////

	public List<ResourceDto> retrieveResource() {
		ResourceDto rt = null;
		// conn = dc.dbConnection();
		List<ResourceDto> list = new ArrayList<ResourceDto>();
		
		
		
		try(BasicDataSource dataSource = DbConn_2.getDataSource(); 
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM resources");){

			//stm = conn.createStatement();
			rs = stmt.executeQuery("select * from resources");
			while (rs.next()) {
				rt = new ResourceDto();
				rt.setCITIES(rs.getString(1));
				rt.setMulti_num(rs.getInt(2));
				rt.setMulti_num_mem(rs.getInt(3));
				rt.setMul_indi(rs.getInt(4));
				rt.setMul_emi(rs.getInt(5));
				list.add(rt);
			}

		} catch (SQLException ex) {

		}
		return list;
		
	}

	public int deleteResource(String CITIES) {
		// conn = dc.dbConnection();
		
		String sql5 = null;
		String str = null;
		int rm = 0;
		try(BasicDataSource dataSource = DbConn_2.getDataSource();
				Connection conn = dataSource.getConnection();	
				) {
			sql5 = "delete from resources where CITIES = ? ";
			pstmt = conn.prepareStatement(sql5);
			pstmt.setString(1, CITIES);
			rm = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rm;
	}

	public int updateResource(ResourceDto rt) {
		// conn = dc.dbConnection();
		String sql4 = null;
		int upg = 0;
		try(BasicDataSource dataSource = DbConn_2.getDataSource();
				Connection conn = dataSource.getConnection();	
			) {
			// 참조 update resources set pwd=?, email=?, phone=?, where id=?
			sql4 = "UPDATE resources 	set Multi_num=?, Multi_num_mem=?, mul_indi=?, mul_emi=?, mul_married=?, mul_etc=? where CITIES=? ";

			pstmt = conn.prepareStatement(sql4);
			pstmt.setInt(1, rt.getMulti_num());
			pstmt.setInt(2, rt.getMulti_num_mem());
			pstmt.setInt(3, rt.getMul_indi());
			pstmt.setInt(4, rt.getMul_emi());
			pstmt.setInt(5, rt.getMul_married());
			pstmt.setInt(6, rt.getMul_etc());
			pstmt.setString(7, rt.getCITIES());

			upg = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return upg;
	}

	public int insertResource(ResourceDto rt) {
		// conn = dc.dbConnection();
		String sql1 = null;
		int insrt = 0;
		try (BasicDataSource dataSource = DbConn_2.getDataSource();
				Connection conn = dataSource.getConnection();	
			){
			sql1 = "insert into resources ( CITIES,Multi_num, Multi_num_mem, "
					+ "Mul_indi, Mul_emi, Mul_married, Mul_etc) " + "values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, rt.getCITIES());
			pstmt.setInt(2, rt.getMulti_num());
			pstmt.setInt(3, rt.getMulti_num_mem());
			pstmt.setInt(4, rt.getMul_indi());
			pstmt.setInt(5, rt.getMul_emi());
			pstmt.setInt(6, rt.getMul_married());
			pstmt.setInt(7, rt.getMul_etc());
			insrt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insrt;
	}
}
