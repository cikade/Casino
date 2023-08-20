import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException {
		Database db = DatabaseConnection.getInstance();
		db.makeTables();

		int x = 99;
		while (x > 0) {
			System.out.println("If you want to login, enter 1");
			System.out.println("If you want to register, enter 2");
			System.out.println("If you want to play a game, enter 3");
			String username = "Admin";
			String password = "root";
			x = scanner.nextInt();
			switch (x) {
			case 1:
				if (db.login(username, password)) {
					System.out.println("Welcome, friend!");
					System.out.println("You've balance: "+db.checkBalance(username, password));
				} else {
					System.out.println("Access denied!");
				}
				break;
			case 2:
				if (db.login(username, password) == false) {
					db.register(username, password);
				} else {
					System.out.println("Username already in use!");
				}
				break;
			case 3:
				float balance = db.checkBalance(username, password);
				Game game = new Game();
				db.updateBalance(game.main(balance), username, password);
				break;
			}
		}
	}

}
