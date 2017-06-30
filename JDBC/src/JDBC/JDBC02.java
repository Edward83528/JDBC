package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//JDBC第二種寫法
public class JDBC02 {

	public static void main(String[] args) {
		// 1. Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(-1);
		}

		try {
			// 2. 連接Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Demo", "root", "zxcvbnm0351");
			// 3. SQL statement
			Statement stmt = conn.createStatement();
			// 4. query
			String sql = "INSERT INTO wish(date1,title,content )" + " VALUES (curdate(),'123','234')";
			stmt.execute(sql);
			System.out.println(sql);
		} catch (SQLException se) {
			System.out.println(se);
		}

	}

}
