package learn.jdbc;

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
 * - next() : được sử dụng để di chuyển con trỏ đến một hàng tiếp theo từ vị trí
 * hiện tại.
 * 
 * - previous() : được sử dụng để di chuyển con trỏ đến một hàng trước đó từ vị
 * trí hiện tại.
 * 
 * - first() : được sử dụng để di chuyển con trỏ đến hàng đầu tiên trong đối tượng
 * thiết lập kết quả.
 * 
 * - last() : được sử dụng để di chuyển con trỏ đến hàng cuối cùng trong đối tượng
 * thiết lập kết quả.
 * 
 * - absolute(int row) : được sử dụng để di chuyển con trỏ đến số hàng được chỉ
 * định trong đối tượng ResultSet.
 * 
 * - relative(int row) : được sử dụng để di chuyển con trỏ đến số hàng tương đối
 * trong đối tượng ResultSet, nó có thể là dương hoặc âm. Số âm nghĩa là di
 * chuyển về hàng trước đó. Số dương nghĩa là di chuyển đến hàng tiếp theo.
 * 
 * - getInt(int columnIndex) : được sử dụng để lấy kết quả tại dựa vào chỉ mục của
 * một cột được chỉ định. Kết quả là một giá trị kiểu int.
 * 
 * - getInt(String columnName) : được sử dụng để lấy kết quả dựa vào tên của một
 * cột được chỉ định. Kết quả là một giá trị kiểu int.
 * 
 * Tương tự như getInt(), chúng ta có thể getString(), getDouble() ,..
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
			System.out.println("\n=== Move to previous row ===");
			while (rs.previous()) {
				showUserInfo(rs);
			}
			System.out.println("\n=== Move to last row ===");
			rs.last();
			showUserInfo(rs);
			System.out.println("\n=== Move to first row ===");
			rs.first();
			showUserInfo(rs);
		}
	}

	private static void showUserInfo(ResultSet rs) throws SQLException {
		System.out.println("Id: " + rs.getInt(1));
		System.out.println("UserName: " + rs.getString(2));
		System.out.println("Password: " + rs.getString("password"));
		System.out.println("CreatedDate: " + rs.getDate("created_date"));
		System.out.println("---");
	}

}
