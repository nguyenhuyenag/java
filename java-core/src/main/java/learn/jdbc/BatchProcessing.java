package learn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class User {
	String username;
	String password;
	java.sql.Date createdDate;
}

public class BatchProcessing {

	public static void main(String[] args) throws SQLException {
		String sql = "INSERT INTO user(username, password, created_date) VALUE(?, ?, ?);";
		try ( //
			Connection con = ConnectionUtils.openConnection();
			PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //
		) {
			try {
				con.setAutoCommit(false);
				List<User> users = readUsersFromCsvFile();
				for (User user : users) {
					pstm.setString(1, user.getUsername());
					pstm.setString(2, user.getPassword());
					pstm.setDate(3, user.getCreatedDate());
					pstm.addBatch(); // Add user to batch
				}
				// Executes the SQL statement
				int[] counts = pstm.executeBatch();
				System.out.println("Affected row [0] = " + counts[0]);
				System.out.println("Affected row [1] = " + counts[1]);
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}
		}
	}

	private static List<User> readUsersFromCsvFile() {
		List<User> list = new ArrayList<>();
		for (int i = 1; i <= 2; i++) {
			list.add(new User("user-" + 1, "pwd123", new java.sql.Date(System.currentTimeMillis())));
		}
		return list;
	}

}
