import java.util.ArrayList;
import java.util.List;

public class UserTable {
	private Boolean status = true;

	public Boolean userTableStatus() {
		return status;
	}

	private List<User> users = new ArrayList<>();

	private int getSize() {
		return users.size();
	}

	public void addUser(User user) {
		if (userExists(user)) {
			System.out.println("This username already exists!");
		} else {
			user.setId(getSize() + 1);
			users.add(user);
		}
	}

	public boolean userExists(User user) {
		for (int i = 0; i < getSize(); i++) {
			if (users.get(i).getUserName().equals(user.getUserName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "UserTable [status=" + status + ", users=" + users + "]";
	}
}
