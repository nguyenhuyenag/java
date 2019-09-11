package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysqlConnect {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/world";
			Connection connect = DriverManager.getConnection(url, user, password);
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM countrylanguage;");
			List<Object[]> records = new ArrayList<Object[]>();
			while (rs.next()) {
				int cols = rs.getMetaData().getColumnCount();
				Object[] arr = new Object[cols];
				for (int i = 0; i < cols; i++) {
					arr[i] = rs.getObject(i + 1);
				}
				records.add(arr);
			}
			System.out.println(Arrays.toString(records.toArray()));
			connect.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
