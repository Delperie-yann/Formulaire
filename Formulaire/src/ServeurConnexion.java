

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServeurConnexion{

	static Connection accessDataBase = null;

	

	
/**
 * Open server connection
 */
	public static void openConnection() {
		/* Parametres de connexion */
		String url = "jdbc:mysql://127.0.0.1/nesti";
		// nesti = nom de ma bdd
		String utilisateur = "root";
		String motDePasse = "";
		try {
			System.out.println("try to connect");
			// on ajoute nos paramètres
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			Logger.getLogger(ServeurConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * test Connection
	 * @return
	 */
	public static boolean testConnection() {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connexion au serveur... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ServeurConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return flag;
	}

	/**
	 * Close connection
	 */
	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}
	}
	
}
