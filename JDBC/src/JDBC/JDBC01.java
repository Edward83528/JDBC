package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01 {

	public static void main(String[] args) {
		// 1. 載入Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException ee) {
			System.out.println(ee);
			System.exit(0);
		}

		try {
			// 2.連接 Connection
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/Demo?" + "user=root&password=zxcvbnm0351");
			// 3. 執行SQL語法的物件 statement
			Statement stmt = conn.createStatement();
			// 4. query

			String sql = "INSERT INTO wish(date1,title,content )" + " VALUES (curdate(),'123','234')";
			System.out.println(sql);
			boolean isQueryOK = stmt.execute(sql);
			if (isQueryOK) {
				System.out.println("OK");
			} else {
				System.out.println("XX");
			}
		} catch (SQLException se) {
			System.out.println(se);
		}

	}

}
