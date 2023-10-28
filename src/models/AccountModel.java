package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.account;



public class AccountModel {
	public List<account> findAll() {
		List<account> accounts = new ArrayList<account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from account");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				account account = new account();
				account.setName(resultSet.getString("name"));
				account.setPass(resultSet.getString("pass"));	
				accounts.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
			accounts = null;
		} finally {
			ConnectDB.disconnect();
		}
		return accounts;
	}
}
