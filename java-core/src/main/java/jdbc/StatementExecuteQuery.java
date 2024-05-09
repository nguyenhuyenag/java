package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*-
 * Statement.createStatement(ResultSetType, ResultSetConcurrency)
 * 
 * - ResultSetType là:
 * 
 * 	 - TYPE_FORWARD_ONLY: Duyệt từ trên xuống dưới, từ trái sang phải, đây là kiểu mặc định.
 * 
 *   - TYPE_SCROLL_INSENSITIVE: Duyệt lùi, sang trái, sang phải, không nhạy cảm với sự thay đổi dữ liệu.
 * 
 *   - TYPE_SCROLL_SENSITIVE: Duyệt tiến lùi, sang trái, sang phải, và nhạy cảm với sự thay đổi dữ liệu.
 * 
 * - ResultSetConcurrency là:
 * 
 *   - CONCUR_READ_ONLY: Chỉ có thể đọc khi duyệt.
 * 
 *   - CONCUR_UPDATABLE: Có thể thay đổi dữ liệu khi duyệt tại nơi con trỏ đứng.
 *
 * Một số phương thức được hỗ trợ bởi ResultSet:
 * 
 * - next(): Di chuyển con trỏ đến một hàng tiếp theo.
 * 
 * - previous(): Di chuyển con trỏ đến hàng trước đó.
 * 
 * - first(): Di chuyển con trỏ đến hàng đầu tiên.
 * 
 * - last(): Di chuyển con trỏ đến hàng cuối cùng.
 * 
 * - absolute(int row): Di chuyển con trỏ đến số hàng được chỉ định.
 * 
 * - relative(int row): Số âm di chuyển về hàng trước đó. Số dương di chuyển đến hàng tiếp theo.
 * 
 * - getInt(int columnIndex): Lấy kết quả dựa vào chỉ mục.
 * 
 * - getInt(String columnName): Lấy kết quả dựa vào tên của một cột được chỉ định.
 * 
 * - Tương tự như getInt(), chúng ta có thể getString(), getDouble() ,..
 */
public class StatementExecuteQuery {

	public static void main(String[] args) throws SQLException {
		String sqlSelect = "SELECT * FROM user";
		try ( //
			Connection con = ConnectionUtils.openConnection();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sqlSelect); //
		) {
			while (rs.next()) {
				showUserInfo(rs);
			}
			System.out.println("Move to previous row");
			while (rs.previous()) {
				showUserInfo(rs);
			}
			System.out.println("Move to last row");
			rs.last();
			showUserInfo(rs);
			System.out.println("Move to first row");
			rs.first();
			showUserInfo(rs);
		}
	}

	private static void showUserInfo(ResultSet rs) throws SQLException {
		System.out.println("Id: " + rs.getInt(1));
		System.out.println("UserName: " + rs.getString(2));
		System.out.println("Password: " + rs.getString("password"));
		System.out.println("CreatedDate: " + rs.getDate("created_date"));
		System.out.println();
	}

}
