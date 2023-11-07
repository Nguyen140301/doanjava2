package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.ConnectDB;
import entities.Book;

public class BookModel {
	List<Book> books;
	//Fill all
	public List<Book> fillAll(){
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement=ConnectDB.connection()
					.prepareStatement("select * from book");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setAuthor(resultSet.getString("author"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCallnumber(resultSet.getString("callnumber"));
				book.setSequence(resultSet.getInt("sequence"));
				books.add(book);
			}
			ConnectDB.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			ConnectDB.disconnect();
		}
		return books;
	}
	
	//Generate ISBN 
	public String generateISBN(Book book) {
		try {
			PreparedStatement preparedStatement=ConnectDB.connection()
					.prepareStatement("select * from book");
			ResultSet resultSet = preparedStatement.executeQuery();
			Random random = new Random();
			
			int indentifier = random.nextInt(100);
			String isbn =String.format(book.getSequence()+"-%03d",indentifier);
			return isbn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Generate Call Number
		public String generateCallNumber(Book book) {
			String title= book.getTitle();
			String authot=book.getAuthor(); 
			try {
				PreparedStatement preparedStatement=ConnectDB.connection()
						.prepareStatement("select * from book");
				ResultSet resultSet = preparedStatement.executeQuery();
				String titlePrefix = title.substring(0,2).toUpperCase();
				String authorPrefix = authot.substring(0,2).toUpperCase();
				Integer sequence = book.getSequence();
				sequence.toString();
				String callNumber = titlePrefix+ "-"+ authorPrefix+ "-"+sequence;
				return callNumber;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
		}
	
	//Add Book
	public boolean create(Book book) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into book(id, isbn, title, author,callnumber,sequence) values(?,?,?,?,?,?)");
			preparedStatement.setInt(6, book.getSequence());
			preparedStatement.setInt(1, book.getId());
			
			preparedStatement.setString(4, book.getAuthor());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setString(2, generateISBN(book));
			preparedStatement.setString(5, generateCallNumber(book));
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
}