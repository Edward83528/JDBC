package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

//JDBC第四種寫法
public class JDBC04 {

	public static void main(String[] args) {

		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "zxcvbnm0351");
		// 使用 try {} 可以讓 Connection 結束後自動執行 close() 以關閉資料庫。
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Demo", prop)) {
			// 3. SQL statement
			// 使用PreparedStatement能防止sql隱碼攻擊
			String sql = "INSERT INTO picture(name1,title) VALUES (?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 第一個欄位
			pstmt.setString(1, "321");
			// 第二個欄位
			pstmt.setString(2, "好吃");
			pstmt.execute();

			pstmt.setString(1, "421");
			pstmt.setString(2, "不好吃");
			pstmt.execute();

			// 4. query

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
