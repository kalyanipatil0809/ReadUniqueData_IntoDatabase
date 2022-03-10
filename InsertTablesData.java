package in.sts.excelutility.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import in.sts.excelutility.model.StudentModel;
import in.sts.excelutility.mysqlconnection.DBConnection;

public class InsertTablesData {
	Connection connection = DBConnection.connect();
	PreparedStatement preparedStatement = null;

	public void insertDetails(HashSet<StudentModel> uniqueSet, PreparedStatement preparedStatement, String query) {

		try {
			preparedStatement = connection.prepareStatement(query);
			if (preparedStatement != null) {

				for (StudentModel studentModel : uniqueSet) {

					preparedStatement.setString(1, studentModel.getFirstName());
					preparedStatement.setString(2, studentModel.getMiddleName());
					preparedStatement.setString(3, studentModel.getLastName());
					preparedStatement.setString(4, studentModel.getBranch());
					preparedStatement.setInt(5, studentModel.getMarksModel().getMaths());
					preparedStatement.setInt(6, studentModel.getMarksModel().getEnglish());
					preparedStatement.setInt(7, studentModel.getMarksModel().getScience());

					preparedStatement.executeUpdate();
				}
			}
			System.out.println("Data uploaded in database");
			connection.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void insertIntoTextTable(HashSet<StudentModel> uniqueSet) {
		try {
			String query = "Insert into TextTablesData  values(s_id,?,?,?,?,?,?,?)"; 
			preparedStatement = connection.prepareStatement(query);

			InsertTablesData insertTablesData = new InsertTablesData();
			insertTablesData.insertDetails(uniqueSet, preparedStatement, query);
			connection.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	public void insertIntoExcelTable(HashSet<StudentModel> uniqueSet) {
		try {
			String query = "Insert into ExcelTablesdata  values(stu_id,?,?,?,?,?,?,?)"; 
			preparedStatement = connection.prepareStatement(query);

			InsertTablesData insertTablesData = new InsertTablesData();
			insertTablesData.insertDetails(uniqueSet, preparedStatement, query);
			connection.close();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	public void insertIntoXmlTable(HashSet<StudentModel> uniqueSet) {
		try {
			String query = "Insert into XmlTablesData values(student_id,?,?,?,?,?,?,?)"; 
			preparedStatement = connection.prepareStatement(query);

			InsertTablesData insertTablesData = new InsertTablesData();
			insertTablesData.insertDetails(uniqueSet, preparedStatement, query);
			connection.close();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
