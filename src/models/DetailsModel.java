package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import entities.Details;
import entities.Nhanvien;
import entities.Book;

public class DetailsModel {
	public List<DetailsModel>  fillAll() {
		List<DetailsModel> detailsModels = new ArrayList<DetailsModel>();
		try {
			PreparedStatement preparedStatement=ConnectDB.connection()
					.prepareStatement("select * from details");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Details details=new Details();
				details.setId_book(resultSet.getInt("Id_book"));
				details.setCallnumber(resultSet.getString("Callnumber"));
				details.setIsbn(resultSet.getString("Isbn"));
				details.setTitle(resultSet.getString("Title"));
				details.setAuthor(resultSet.getString("Author"));
				details.setId_user(resultSet.getInt("Id_user"));
				details.setName_user(resultSet.getString("Name_user"));
				details.setCheck_out_date(resultSet.getDate("Check_out_date"));
				details.setDue_date(resultSet.getDate("Due_date"));
				details.setIssue_status(resultSet.getBoolean("Issue_status"));
				
			}
			ConnectDB.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return detailsModels;
		
	}
	public boolean create(Details details) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement
("insert into nhanvien(Id_book, Callnumber, Isbn, Title, Author, Id_user, Name_user, Check_out_date, Due_date, Issue_status) values(?,?,?,?,?)");
			preparedStatement.setInt(1, details.getId_book());
			preparedStatement.setString(2, details.getCallnumber());
			preparedStatement.setString(3, details.getIsbn());
			preparedStatement.setString(4, details.getTitle());
			preparedStatement.setString(5, details.getAuthor());
			preparedStatement.setInt(6, details.getId_user());
			preparedStatement.setString(7, details.getName_user());
			preparedStatement.setDate(8, new java.sql.Date(details.getCheck_out_date().getTime()));
			preparedStatement.setDate(9, new java.sql.Date(details.getDue_date().getTime()));
//con mot cai boolean cuoi.
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}
