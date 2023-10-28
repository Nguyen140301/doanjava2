package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Account;



public class AccountModel {
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("select * from account");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
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
