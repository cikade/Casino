public class Server {
	
	private boolean ServerStatus = true;
	private boolean DatabaseStatus = false;
	
	DB db = new DB();
	
	private void databaseInitialisation() {
		if (db.dbServerStatus()) {
			DatabaseStatus = db.dbServerStatus();
		}
	}

	private Boolean isOnline() {
		databaseInitialisation();
		return ServerStatus;
	}

	private Boolean databaseConnection() {
		return DatabaseStatus;
	}

	public String serverStatus() {
		if (isOnline()) {
			return "Online";
		} else {
			return "Offline";
		}
	}

	public String databaseStatus() {
		if (databaseConnection()) {
			return "Online";
		} else {
			return "Offline";
		}
	}

}
