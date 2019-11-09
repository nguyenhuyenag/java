package learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*-
 * CREATE DATABASE IF NOT EXISTS `jdbc`;
 * 
 * use `jdbc`;
 * 
 * CREATE TABLE `user` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `username` varchar(255) DEFAULT NULL,
 * `password` varchar(255) DEFAULT NULL,
 * `created_date` timestamp NULL DEFAULT NULL,
 * PRIMARY KEY (`id`)
 * );
 */
public class ConnectionUtils {

	private static final String username = "root";
	private static final String password = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";

	public static Connection openConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		return DriverManager.getConnection(URL, username, password);
	}

}
