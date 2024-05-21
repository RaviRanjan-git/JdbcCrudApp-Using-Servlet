package ravi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbcUtil {
	private jdbcUtil() {
	}

	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	public static Connection getjdbcConnection() throws SQLException {
		String url="jdbc:Mysql://localhost:3306/ravi";
		String user="root";
		String password="Ravi@8340";
		

		Connection connection= DriverManager.getConnection(url,user,password);
	return connection;
		}
	public static void cleanUp(Connection con, Statement statement,ResultSet resultSet) throws SQLException{
		if(con!= null) {
			con.close();
		}
		if(statement!=null) {
			statement.close();
			
		}
		if(resultSet!=null) {
			resultSet.close();
		}
	}

}
