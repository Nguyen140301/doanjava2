package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import demo.details;
import entities.Book;
import entities.Details;
import entities.Fee;
import entities.User;

public class FeeModel {
	public List<Fee> find() {
		List<Fee> fees = new ArrayList<Fee>();
		List<Details> details = new ArrayList<Details>();
		try {
			Details detail = new Details();
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select *"+"from fee "+"inner join details on fee.title = details.title && fee.due_date = details.due_date && fee.name_user = details.name_user "+"where details.name_user = ?");
			preparedStatement.setString(1, detail.getName_user());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Fee fee = new Fee();
				detail.setName_user(resultSet.getString("name_user"));
				detail.setTitle(resultSet.getString("title"));
				detail.setDue_date(resultSet.getDate("due_date"));
				fee.setReturn_date(resultSet.getDate("return_date"));
				fee.setFee(resultSet.getDouble("fee"));
				fees.add(fee);
				details.add(detail);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			fees = null;
		} finally {
			ConnectDB.disconnect();
		}
		return fees;
	}
	
	
	public boolean Delete(String name_user) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("delete from fee where name_user = ?");
			preparedStatement.setString(1, name_user);
			result = preparedStatement.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally{
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	public void generatefee(Details detailss) {
		
		try {
			PreparedStatement preparedStatement=ConnectDB.connection()
					.prepareStatement("select due_date from details where id_user = ? and id_book = ?");
			preparedStatement.setInt(1, detailss.getId_user());
			preparedStatement.setInt(2, detailss.getId_book());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Date duedate = resultSet.getDate("due_date");
				Date returndate = new Date();
				Calendar returnCalendar  = Calendar.getInstance();
				returnCalendar.setTime(returndate);
				Calendar duedateCalendar  = Calendar.getInstance();
				duedateCalendar.setTime(duedate);
				long overday = tinhngay(duedate, returndate);
				
				
				if(overday>0) {
					double latefee = overday * 10;
					PreparedStatement preparedStatementt=ConnectDB.connection()
							.prepareStatement("update details set fee = ? where id_user =? and id_book = ?");
					preparedStatementt.setDouble(1, latefee);
					preparedStatementt.setInt(2, detailss.getId_user());
					preparedStatementt.setInt(3, detailss.getId_book());
					preparedStatementt.executeUpdate();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static long tinhngay(Date duedate,  Date returndate) {
		long diff = returndate.getTime() - duedate.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	
	public List<Fee> findall() {
		List<Fee> fees = new ArrayList<Fee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from fee");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Fee user = new Fee();
				user.setName_user(resultSet.getString("name_user"));
				user.setTitle(resultSet.getString("title"));
				user.setReturn_date(new java.sql.Date(resultSet.getDate("return_date").getTime()));
				user.setDue_date(new java.sql.Date(resultSet.getDate("due_date").getTime()));
				user.setFee(resultSet.getDouble("fee"));
				fees.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fees = null;
		} finally {
			ConnectDB.disconnect();
		}
		return fees;
	}
}
