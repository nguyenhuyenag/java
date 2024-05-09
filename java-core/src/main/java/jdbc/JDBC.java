package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*-
 *	- Execute Query
 * 		- executeQuery()  :	select
 * 		- executeUpdate() :	insert/update/delete
 * 		- execute()		  :	Cả 2
 * 			af = st.getUpdateCount(): Trả về số lượng record bị affect
 *			- af > 0	=>	thực thi các câu lệnh insert/update/delete
 *			- af = 0	=>	thực thi insert/update/delete không có dòng nào bị ảnh hưởng
 *			- af = -1	=>	thực thi câu lệnh select, gọi tiếp lệnh st.getResultSet() để lấy ResultSet
 *	
 *	- Khi Statement được close() thì ResultSet của Statement cũng được close.
 */
public class JDBC {

	private static final String username = "root";
	private static final String password = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/sys";

	public static void main(String[] args) throws SQLException {
		// 1. Load Driver
		// Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		try (
			// 2. Open connection
			Connection con = DriverManager.getConnection(URL, username, password);
			// 3. Create Statement
			Statement st = con.createStatement(); //
		) {
			// 4. Execute query
			String sql = "select * from sys_config";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				showData(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showData(ResultSet rs) throws SQLException {
		System.out.println("Variable: " + rs.getString(1));
		System.out.println("Value: " + rs.getString("value"));
		System.out.println("Set time: " + rs.getString("set_time"));
	}
}
