package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

////JDBC第三種寫法
public class JDBC03 {

	public static void main(String[] args) {
		// jdbc1.8後自動會載入driver不必自己引入,但專案還是要有jar檔
		// 1. Driver
		// try{
		// Class.forName("com.mysql.jdbc.Driver");
		// }catch(ClassNotFoundException ee){
		// System.exit(-1);
		// }

		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "zxcvbnm0351");

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Demo", prop)) {
			// 3. SQL statement
			Statement stmt = conn.createStatement();
			// 4. query
			String sql = "SELECT * FROM wish";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String date1 = rs.getString("date1");
				String title = rs.getString("title");
				System.out.println(date1 + ":" + title);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
