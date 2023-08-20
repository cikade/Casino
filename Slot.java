import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Slot {

	public int slot() throws ClassNotFoundException {
		Random rand = new Random();
		int b = rand.nextInt(10);
		System.out.println(b);
		System.out.println("-------------------");
		System.out.println(nextSymbol(b));
		System.out.println("-------------------");
		int count = 5;
		System.out.println(symbolValue(nextSymbol(b), count));
		System.out.println("-------------------");
		int row[] = new int[15];
		for (int i = 0; i < 15; i++) {
			row[i] = rand.nextInt(10);
			System.out.print(nextSymbol(row[i]));
		}
		rowToDB(row);
		System.out.println("-------------------");
		
		List<String> aaa = new ArrayList<String>();
		aaa = getLine();
		aaa.set(0, "9");
		aaa.set(1, "9");
		aaa.set(2, "9");
		aaa.set(3, "9");
		aaa.set(4, "9");
		int x = 1;
		while (x < aaa.size()) {
			if (aaa.get(0).equals(aaa.get(x))) {
				x++;
			} else {
				break;
			}
		}
		System.out.println("-------------------");
		System.out.println(x);
		System.out.println("-------------------");
		int z= Integer.valueOf(aaa.get(0));
		System.out.println(symbolValue(nextSymbol(z), x));
		return symbolValue(nextSymbol(z), x);
	}

	private static List<String> getLine() throws ClassNotFoundException {
		List<String> line = new ArrayList<String>();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (
			Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT [1],[2],[3],[4],[5],[6],[7],[8],[9],[10],[11],[12],[13],[14],[15] FROM move;");
			rs.next();
			System.out.println("");
			System.out.println("-----------------> "+rs.getInt("1"));
			for (int i = 1; i <= 5; i++) {
				String str = Integer.toString(rs.getInt(i));
				line.add(str);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for (int i = 0; i < line.size(); i++) {
			System.out.println(line.get(i));
		}
		return line;
	}

	private static void rowToDB(int[] row) throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO move ([user], [1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15]) VALUES ('Admin', ";
			for (int i = 0; i < 14; i++) {
				sql += row[i] + ", ";
			}
			sql += row[14]+");";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static int symbolValue(String symbol, int count) throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ["+count+"] FROM symbols WHERE name = '" + symbol + "';");
			rs.next();
			int symbolValue = rs.getInt(1);
			con.close();
			return symbolValue;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	private static String nextSymbol(int x) throws ClassNotFoundException {
		x++;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost;database=casino;user=Admin;password=root;encrypt=true;trustServerCertificate=true;")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name FROM symbols WHERE id = " + x);
			rs.next();
			String nextSimbol = rs.getString(1);
			con.close();
			return nextSimbol;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
