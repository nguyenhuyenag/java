package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*-
 * - Các thuộc tính ACID miêu tả về Transaction, trong đó
 * 
 * 	  - Atomicity: Tất cả thành công hoặc không.
 * 
 * 	  - Consistency: Bảo đảm tính đồng nhất của dữ liệu.
 * 
 * 	  - Isolation: Bảo đảm rằng Transaction này là độc lập với Transaction khác.
 * 
 * 	  - Durability: Khi một Transaction đã được commit thì nó vẫn tồn tại dù xảy ra các lỗi, ...
 * 
 * - Connection Interface cung cấp các phương thức sau để quản lý transaction
 * 
 * 	  - setAutoCommit(boolean status): Mặc định là true, ddể thao tác với Transaction, cần thiết lập về false.
 * 
 * 	  - commit(): Gọi method commit dữ liệu xuống database.
 * 
 * 	  - rollback(): Xóa tất cả các thay đổi đã được thực hiện trước đó và quay về trạng thái trước khi thực hiện thay đổi.
 */
public class TransactionManager {

	public static void main(String[] args) throws SQLException {

		try ( //
			Connection con = ConnectionUtils.openConnection();
			Statement st = con.createStatement(); //
		) {
			con.setAutoCommit(false); // 1. Disable individualtransaction
			try {
				// This user will be inserted
				st.executeUpdate("INSERT INTO user(username, password, created_date) VALUE('user-1', '123', now());");
				System.out.println("Inserted user-1 successfully");

				// This is an error sql. Cannot insert user
				st.executeUpdate("INSERT INTO user2(username, password, created_date) VALUE('user-2', '123', now());");
				System.out.println("Inserted user-2 successfully");
				con.commit(); // 2. commit data to database if all command are success
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback(); // 2. roll-back data if one of command are failed
				System.out.println("Rollback data");
			}
		}
	}

}
