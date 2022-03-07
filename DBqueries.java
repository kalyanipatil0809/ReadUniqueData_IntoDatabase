package in.sts.excelutility.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import in.sts.excelutility.dao.DBConnection;
import in.sts.excelutility.model.StudentModel;

public class DBqueries {
	

	public void insertIntoStudents (HashSet<StudentModel> uniqueSet) {

		try (Connection con = DBConnection.connect()) {

			String sql = "Insert into students values(student_id,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql);

			if (uniqueSet != null) {

				for (StudentModel studentModel : uniqueSet) {

					pstmt.setString(1, studentModel.getFirstName());
					pstmt.setString(2, studentModel.getMiddleName());
					pstmt.setString(3, studentModel.getLastName());
					pstmt.setString(4, studentModel.getBranch());
					pstmt.setInt(5, studentModel.getMarksModel().getMaths());
					pstmt.setInt(6, studentModel.getMarksModel().getEnglish());
					pstmt.setInt(7, studentModel.getMarksModel().getScience());

					pstmt.executeUpdate();
					
				}
				
			}
			System.out.println("Data uploaded in database");

			pstmt.close();
			con.close();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

	}

//	public void insertIntoStudentDetails (HashSet<StudentModel> uniqueSet) {
//
//		try (Connection con = DBConnection.connect()) {
//			String sql = "Insert into studentDetails  values(student_id,?,?,?,?,?,?,?)";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//
//			if (uniqueSet != null) {
//
//				for (StudentModel studentModel : uniqueSet) {
//					pstmt.setString(1, studentModel.getFirstName());
//					pstmt.setString(2, studentModel.getMiddleName());
//					pstmt.setString(3, studentModel.getLastName());
//					pstmt.setString(4, studentModel.getBranch());
//					pstmt.setInt(5, studentModel.getMarksModel().getMaths());
//					pstmt.setInt(6, studentModel.getMarksModel().getEnglish());
//					pstmt.setInt(7, studentModel.getMarksModel().getScience());
//
//					pstmt.executeUpdate();
//				}
//			}
//			System.out.println("Data uploaded in database");
//			
//			pstmt.close();
//			con.close();
//
//		} catch (SQLException exception) {
//			exception.printStackTrace();
//		}
//
//	}

//	public void insertIntoStudentsInformation (HashSet<StudentModel> uniqueSet) {
//
//		try (Connection con = DBConnection.connect()) {
//			String sql = "Insert into StudentInformation  values(stu_id,?,?,?,?,?,?,?)";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//
//			if (uniqueSet != null) {
//
//				for (StudentModel studentModel : uniqueSet) {
//					pstmt.setString(1, studentModel.getFirstName());
//					pstmt.setString(2, studentModel.getMiddleName());
//					pstmt.setString(3, studentModel.getLastName());
//					pstmt.setString(4, studentModel.getBranch());
//					pstmt.setInt(5, studentModel.getMarksModel().getMaths());
//					pstmt.setInt(6, studentModel.getMarksModel().getEnglish());
//					pstmt.setInt(7, studentModel.getMarksModel().getScience());
//
//					pstmt.executeUpdate();
//				}
//			}
//			System.out.println("Data uploaded in database");
//			
//			pstmt.close();
//			con.close();
//
//		} catch (SQLException exception) {
//			exception.printStackTrace();
//		}
//
//	}

}
