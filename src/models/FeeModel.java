package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Fee;
import entities.User;

public class FeeModel {
	public List<Fee> find() {
		List<Fee> fees = new ArrayList<Fee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from fee");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Fee fee = new Fee();
				fee.setName_user(resultSet.getString("name_user"));
				fee.setTitle(resultSet.getString("title"));
				fee.setCheck_out_date(resultSet.getDate("check_out_date"));
				fee.setDue_date(resultSet.getDate("due_date"));
				fee.setFee(resultSet.getDouble("fee"));
				fees.add(fee);
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
}
