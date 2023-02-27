package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		try {
		
		Connection connection = JDBCUtil.getConnection();
		
		Statement st =  (Statement) connection.createStatement();
		
		String sql = "INSERT INTO benhan (Mãhồsơ,Tênbệnhnhân,MãsốBHYT,Địachỉ,Nămsinh,Giớitính,Dântộc,Loạibệnh)"
				+ "VALUES (\"3\",\"Nguyen Van C\",\"1226567\",\"Bình Định\",\"1995\",\"Nam\",\"Kinh\",\"Tiểu đường\")";

		int check = st.executeUpdate(sql);
		
		System.out.println("Số dòng thay đổi: "+check);
		if(check>0) {
			System.out.println("Thêm dữ liệu thành công");
		}else {
			System.out.println("Thêm dữ liệu thất bại");
		}
		
		JDBCUtil.closeConnetion(connection);
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	}

}
  