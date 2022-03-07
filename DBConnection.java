package in.sts.excelutility.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/unique_data";
	private static String userName = "root";
	private static String Pass = "root";
	private static Connection con;

	public static Connection connect() {
		try {

			con = DriverManager.getConnection(url, userName, Pass);
			System.out.println("succsess");

			con.close();

		} catch (SQLException e) {
			System.out.println("Cannot create database connection");
			e.printStackTrace();
		}
		return con;
	}

}
