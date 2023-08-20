import java.sql.*;

public class DatabaseConnection implements Database{	
	
	private static Database instance;

	public static Database getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	private void execSQLupdate(String query) throws ClassNotFoundException {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void makeTables() throws ClassNotFoundException {
		execSQLupdate("drop table if exists users, symbols, row, move");
		
		execSQLupdate(
				"CREATE TABLE users (id INT IDENTITY (1, 1) NOT NULL, name VARCHAR(50) NOT NULL , password VARCHAR(50) NOT NULL , user_level int NOT NULL, balance float NOT NULL, PRIMARY KEY (id));");
		execSQLupdate("INSERT INTO users (name, password, user_level, balance) VALUES ('Admin', 'root', 999, 50.1);");

		execSQLupdate("CREATE TABLE symbols (id int IDENTITY (1, 1) NOT NULL, name  VARCHAR(50) NOT NULL, [2] int NOT NULL, [3] int NOT NULL, [4] int NOT NULL, [5] int NOT NULL);");
		execSQLupdate("INSERT INTO symbols (name, [2], [3], [4], [5]) VALUES ('10       ', 0, 5, 25, 100), ('Jack     ', 0, 5, 25, 100), ('Queen    ', 0, 5, 25, 100), ('King     ', 0, 5, 25, 100), ('Ace      ', 0, 5, 25, 100), ('Scarab   ', 5, 30, 100, 750), ('Bird     ', 5, 30, 100, 750), ('Book     ', 0, 20, 200, 2000), ('Mummy    ', 5, 40, 400, 2000), ('Explorer ', 10, 100, 1000, 5000);");

		execSQLupdate("CREATE TABLE row (id int IDENTITY (1, 1) NOT NULL, [1] int NOT NULL, [2] int NOT NULL, [3] int NOT NULL, [4] int NOT NULL, [5] int NOT NULL, CONSTRAINT [PK_row] PRIMARY KEY CLUSTERED ([id] ASC));");
		execSQLupdate("INSERT INTO [dbo].[row] ([1],[2],[3],[4],[5]) VALUES (2, 2, 2, 2, 2), (1, 1, 1, 1, 1), (3, 3, 3, 3, 2), (1, 2, 3, 2, 1), (3, 2, 1, 2, 2), (2, 3, 3, 3, 2), (2, 1, 1, 1, 2), (3, 3, 2, 1, 1), (1, 1, 2, 3, 3), (3, 2, 2, 2, 1);");

		execSQLupdate("CREATE TABLE move (id INT IDENTITY (1, 1) NOT NULL, [user] VARCHAR(50) NOT NULL , timestamp DATETIME NULL , [1] INT NOT NULL , [2] INT NOT NULL , [3] INT NOT NULL , [4] INT NOT NULL , [5] INT NOT NULL , [6] INT NOT NULL , [7] INT NOT NULL , [8] INT NOT NULL , [9] INT NOT NULL , [10] INT NOT NULL , [11] INT NOT NULL , [12] INT NOT NULL , [13] INT NOT NULL , [14] INT NOT NULL , [15] INT NOT NULL, WON INT NULL, PRIMARY KEY (id));");
	}

	public boolean isConnected() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (
			Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM symbols WHERE id = 1;");
			while (rs.next()) return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (
			Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(id) AS klients FROM users WHERE name = '" + username
					+ "' AND password = '" + password + "'");
			while (rs.next()) {
				if (rs.getInt(1) == 1)
					return true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public void register(String username, String password) throws ClassNotFoundException {
		execSQLupdate("INSERT INTO users (name, password, user_level, balance) VALUES ('" + username + "', '"
				+ password + "', 1, 0)");
	}

	@Override
	public float checkBalance(String username, String password) throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (
			Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT balance FROM users WHERE name = '"+username+"' and password = '"+password+"';");
			while (rs.next()) {
				if (rs.getFloat(1) == 1)
					System.out.println("RSFloat: "+rs.getFloat(1));
					return rs.getFloat(1);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public void updateBalance(int balance, String username, String password) throws ClassNotFoundException {
		float x = balance / 100;
		execSQLupdate("UPDATE users SET balance = '"+x+"' WHERE name = '"+username+"' and password = '"+password+"';");
	}
}
