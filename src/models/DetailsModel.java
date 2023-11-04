package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import entities.Details;
import entities.Book;

public class DetailsModel {
	public List<Details>  fillAll() {
		List<Details> details = new ArrayList<Details>();
		try {
			PreparedStatement preparedStatement=ConnectDB.connection()
					.prepareStatement("select * from details");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Details detail=new Details();
				detail.setId_book(resultSet.getInt("id_book"));
				detail.setCallnumber(resultSet.getString("callnumber"));
				detail.setIsbn(resultSet.getString("isbn"));
				detail.setTitle(resultSet.getString("title"));
				detail.setAuthor(resultSet.getString("author"));
				detail.setId_user(resultSet.getInt("id_user"));
				detail.setName_user(resultSet.getString("name_user"));
				detail.setCheck_out_date(resultSet.getDate("check_out_date"));
				detail.setDue_date(resultSet.getDate("due_date"));
				detail.setIssue_status(resultSet.getString("issue_status"));
				details.add(detail);
			}
		} catch (Exception e) {
			e.printStackTrace();
			details= null;
		}finally {
			ConnectDB.disconnect();
		}
		
		return details;
		
	}
	public boolean create(Details details) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement
("insert into nhanvien(id_book, callnumber, isbn, title, author, id_user, name_user, check_out_date, due_date, issue_status) values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, details.getId_book());
			preparedStatement.setString(2, details.getCallnumber());
			preparedStatement.setString(3, details.getIsbn());
			preparedStatement.setString(4, details.getTitle());
			preparedStatement.setString(5, details.getAuthor());
			preparedStatement.setInt(6, details.getId_user());
			preparedStatement.setString(7, details.getName_user());
			preparedStatement.setDate(8, new java.sql.Date(details.getCheck_out_date().getTime()));
			preparedStatement.setDate(9, new java.sql.Date(details.getDue_date().getTime()));
			preparedStatement.setString(10, details.getIssue_status());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	
	public boolean Delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("delete from user where id_book = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally{
			ConnectDB.disconnect();
		}
		return result;
	}
}
