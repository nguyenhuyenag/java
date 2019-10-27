package learn.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysqlConnect {

	public static void main(String[] args) {
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/world";
		try (Connection connect = DriverManager.getConnection(url, user, password)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM countrylanguage;");
			List<Object[]> records = new ArrayList<>();
			while (rs.next()) {
				int cols = rs.getMetaData().getColumnCount();
				Object[] arr = new Object[cols];
				for (int i = 0; i < cols; i++) {
					arr[i] = rs.getObject(i + 1);
				}
				records.add(arr);
			}
			System.out.println(Arrays.toString(records.toArray()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
