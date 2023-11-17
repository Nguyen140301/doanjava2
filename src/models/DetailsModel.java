package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.toedter.calendar.IDateEditor;

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
				detail.setFee(resultSet.getDouble("fee"));
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
	//find id user id book 
	public List<Details>  fillId(int id_book, int id_user) {
		
		List<Details> details = new ArrayList<Details>();
		try {
			PreparedStatement preparedStatement=ConnectDB.connection()
					.prepareStatement("select * from book where id=? ");
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
				detail.setFee(resultSet.getDouble("fee"));
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
		FeeModel feeModel = new FeeModel();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement
("insert into details(id_book,  title, author, id_user, name_user, check_out_date, due_date, issue_status) values(?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, details.getId_book());
			
			
			preparedStatement.setString(2, details.getTitle());
			preparedStatement.setString(3, details.getAuthor());
			preparedStatement.setInt(4, details.getId_user());
			preparedStatement.setString(5, details.getName_user());
			preparedStatement.setDate(6, new java.sql.Date(details.getCheck_out_date().getTime()));
			preparedStatement.setDate(7, new java.sql.Date(details.getDue_date().getTime()));
			preparedStatement.setString(8, details.getIssue_status());
			
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
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("delete from details where id_book = ?");
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
	public List<Details>  Seacrh(String tittle , String username) {
		List<Details> details = new ArrayList<Details>();
		try {
			PreparedStatement preparedStatement=ConnectDB.connection()
					.prepareStatement("select * from details where title like ? or Name_user like ?");
			preparedStatement.setString(1, tittle + "%");
			preparedStatement.setString(2, username );
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
				detail.setFee(resultSet.getDouble("fee"));
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
	
	
	
}
