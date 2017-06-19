package chapter09.dataExchange;

/**
 * A user has a name and password. For security reasons, the password is stored as a char[], not a
 * String.
 */
class User {
	private String name;
	private char[] password;
	
	public User(String name, char[] password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public char[] getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassward(char[] password) {
		this.password = password;
	}
}
