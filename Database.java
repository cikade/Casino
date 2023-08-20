public interface Database {

	void makeTables() throws ClassNotFoundException;

	boolean isConnected() throws ClassNotFoundException;

	boolean login(String username, String password) throws ClassNotFoundException;

	void register(String username, String password) throws ClassNotFoundException;

	float checkBalance(String username, String password) throws ClassNotFoundException;

	void updateBalance(int balance, String username, String password) throws ClassNotFoundException;

}