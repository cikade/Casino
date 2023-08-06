import java.util.Scanner;

public class Beggining {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username = "asd";
		String password = "zxc";

		User user = new User(username, password);
		User user2 = new User(username + "1", password + "1");

		Server server = new Server();

		server.db.userTable.addUser(user);
		server.db.userTable.addUser(user2);

		println("Server status: " + server.serverStatus() + "\n");
		println("Connections to database is established: " + server.databaseStatus() + "\n");

		if (server.serverStatus() == "Offline" || server.databaseStatus() == "Offline") {
			println("One or more servers are offline and need to terminate program");
			System.exit(0);
		} else {
			int x = 10;
			while (x > 0) {
				println("Whats your pleasure?");
				println("If you wish to add new user, enter 1");
				println("If you wish to see all existing users, enter 2");
				println("Play slots, enter 3");
				println("If you wish to exit this program, enter 4");
				x = sc.nextInt();
				switch (x) {
				case 1:
					println("Enter username!");
					username = sc.next();
					println("Enter password");
					password = sc.next();
					User newUser = new User(username, password);
					server.db.userTable.addUser(newUser);
					break;
				case 2:
					println(server.db.userTable);
					break;
				case 3:
					float balance = 5;
					Slot_machine slut = new Slot_machine();
					slut.main(balance, 0.10);
					break;
				case 4:
					System.exit(0);
					break;
				}
			}
		}
		sc.close();
	}

	public static void println(Object object) {
		System.out.println(object);
	}
}
