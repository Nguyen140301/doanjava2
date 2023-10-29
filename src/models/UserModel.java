package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.User;

public class UserModel {
	public List<User> find() {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from user");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAddress(resultSet.getString("address"));
				user.setPhone(resultSet.getInt("phone"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			users = null;
		} finally {
			ConnectDB.disconnect();
		}
		return users;
	}
	
	
	public boolean Delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("delete from user where id = ?");
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
	
	
	public boolean create(User user) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("insert into user(id, name, address, phone) values(?,?,?,?)");
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setInt(4, user.getPhone());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(User user) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("update user set id = ?,  name = ?, address=?, phone = ? where id = ?");
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setInt(4, user.getPhone());
			preparedStatement.setInt(5, user.getId());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	public User find(int id) {
		User user = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from user where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAddress(resultSet.getString("address"));
				user.setPhone(resultSet.getInt("phone"));
			}
		} catch (Exception e) {
			user = null;
		} finally {
			ConnectDB.disconnect();
		}
		return user;
	}
	
	
	
}
