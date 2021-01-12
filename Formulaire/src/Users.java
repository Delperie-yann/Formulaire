

public class Users {
	
	String name;
	String firstname;
	String town;
	String email;
	String password;
	String nickname;

	
	public Users(String name,String firstname,String town,String email,String password,String nickname) {
		
		this.name=name;
		this.firstname=firstname;
		this.town=town;
		this.email=email;
		this.password=password;
		this.nickname=nickname;
	}
	
	


	public Users() {
		
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}


	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	@Override
	public String toString() {
		return "Users [ name=" + name + ", firstname=" + firstname + ", town=" + town + ", email=" + email
				+ ", password=" + password + ", nickname=" + nickname + "]";
	}

}
