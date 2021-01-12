

import java.sql.Statement;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryUsers extends ServeurConnexion {
	

	/**
	 * Read user 
	 */
	public static void readAll() {

		try {
			Statement declaration = accessDataBase.createStatement();

			String query = "SELECT name,firstname,town,email,password,nickname FROM users;";

			ResultSet resultat = declaration.executeQuery(query);

			while (resultat.next()) {
				Users ing = new Users();
				
				ing.setName(resultat.getString("name"));
				ing.setFirstname(resultat.getString("firstname"));
				ing.setTown(resultat.getString("town"));
				ing.setEmail(resultat.getString("email"));
				ing.setPassword(resultat.getString("password"));
				ing.setNickname(resultat.getString("nickname"));
				System.out.println(ing.toString());

			}
		} catch (Exception e) {

			System.err.println("Erreur d'affichage : " + e.getMessage());

		}
	}
	
/**
 * Create User
 * @param name
 * @param firstname
 * @param town
 * @param email
 * @param password
 * @param nickname
 * @return
 */
	public static boolean create(String name, String firstname, String town, String email, String password,
			String nickname)

	{
		boolean flag = false;
		try {
			
		
			String query = "INSERT INTO `users` (`name`, `firstname`, `town`, `email`, `password`, `nickname`) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, name);
			declaration.setString(2, firstname);
			declaration.setString(3, town);
			declaration.setString(4, email);
			declaration.setString(5, password);
			declaration.setString(6, nickname);
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion : " + e);
		}
		return flag;
	}

/**
 *  
 * @param name
 * @param firstname
 * @param town
 * @param email
 * @param password
 * @param nickname
 * @return
 */
	public static boolean deleteByNamePrepared(String name, String firstname, String town, String email, String password,
			String nickname) {
		boolean success = false;
		try {
			String query = "DELETE FROM `users` (`name`, `firstname`, `town`, `email`, `password`, `nickname`) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			// on verifie la requet avant
			declaration.setString(1, name);
			declaration.setString(2, firstname);
			declaration.setString(3, town);
			declaration.setString(4, email);
			declaration.setString(5, password);
			declaration.setString(6, nickname);
			int executeUpdate = declaration.executeUpdate();
			success = (executeUpdate == 1);
		} catch (SQLException e) {
			System.err.println("Erreur suppression : " + e.getMessage());
		}
		return success;
	}
/**
 * Update Users
 * @param name
 * @param firstname
 * @param town
 * @param email
 * @param password
 * @param nickname
 * @return
 */
	public static boolean update(String name, String firstname, String town, String email, String password,
			String nickname) {
		boolean success = false;
		try {
			// indique le nom et la colonne
			String query = "UPDATE users SET name = ? , firstname=? , town=? , email=? , password=?  WHERE nickname = ?; ";
			/*Requete Sql
			*-------------------------------------------------------------------------------------------------------------------------------------
			*UPDATE users SET name = 'titi' , firstname='toto', town='tata' , email='tata@hotmail.fr' ,password='tota' WHERE nickname = 'Fred' 
			*---------------------------------------------------------------------------------------------------------------------------------------
			*/
			System.out.println(query);
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			// modifie le nom et l'id si il corresponde
			declaration.setString(1, name);
			declaration.setString(2, firstname);
			declaration.setString(3, town);
			declaration.setString(4, email);
			declaration.setString(5, password);
			declaration.setString(6, nickname);
			int executeUpdate = declaration.executeUpdate();
			System.out.println(executeUpdate);
			success = (executeUpdate == 1);
			
		} catch (SQLException e) {
			System.err.println("Erreur suppression : " + e.getMessage());
		}
		return success;
	}
	
}
