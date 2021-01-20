/*
 * This is just a quick and nasty setup for storing those names
 */


package eu.codecache.haagahelia.tehtava2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.codecache.haagahelia.tehtava2.domain.Friend;

public class JDBCDao {

//	private static final String JDBC_URL = "jdbc:sqlite:/home/ldap/ville/Opiskelu/Palvelinohjelmointi/tehtava2.sqlite";
	// to make this app work properly, set JDBC_PATH to a valid location
	private static final String JDBC_URL = "jdbc:sqlite:" + System.getenv("JDBC_PATH");
	private static final String TABLE_NAME = "friends";

	public JDBCDao() {
		Connection connection = this.connect();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME
					+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, friend TEXT NOT NULL)");
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.disconnect(connection);
	}

	public void addFriend(Friend friend) {
		if (friend.getName() == null) {
			// no name set --> do nothing
			return;
		}
		Connection connection = this.connect();
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + TABLE_NAME + "(friend) VALUES (?)");
			stmt.setString(1, friend.getName());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.disconnect(connection);
	}

	public List<Friend> getFriends() {
		List<Friend> friends = new ArrayList<>();
		Connection connection = this.connect();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				friends.add(new Friend(results.getLong("id"), results.getString("friend")));
			}
			results.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.disconnect(connection);
		return friends;
	}

	private Connection connect() {
		try {
			return DriverManager.getConnection(JDBC_URL);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	private void disconnect(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
