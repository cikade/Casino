public class DB {

	private boolean status = false;
	
	UserTable userTable = new UserTable();

	public Boolean dbServerStatus() {
		if (userTable.userTableStatus()) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

}
