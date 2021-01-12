
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.Toolkit;
import java.awt.Color;

import java.awt.event.ActionListener;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Connection extends ServeurConnexion {

	JFrame frame;
	private static JTextField textPseudo;
	private static JTextField textField_mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection window = new Connection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();

		frame.getContentPane().setBackground(new Color(60, 179, 113));
		frame.setBounds(100, 100, 571, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnConnexion = new JButton("CONNEXION\r\n");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openConnection();
				userTest(textPseudo.getText(), textField_mdp.getText());
				closeConnection();
			}
		});
		btnConnexion.setBackground(Color.GREEN);
		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConnexion.setBounds(66, 184, 145, 34);
		btnConnexion.setBorder(new RoundedBorder(10));
		frame.getContentPane().add(btnConnexion);

		JLabel lblNewLabel = new JLabel("CONNEXION NESTI");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 201, 14);

		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* E-mail ou Pseudo :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(45, 70, 130, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("* Mot De Passe :");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(45, 129, 113, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("* Champs obligatoires");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(185, 224, 145, 14);
		frame.getContentPane().add(lblNewLabel_4);

		textPseudo = new JTextField();
		textPseudo.setBounds(210, 68, 323, 20);
		frame.getContentPane().add(textPseudo);
		textPseudo.setColumns(10);

		textField_mdp = new JPasswordField();
		textField_mdp.setBounds(210, 127, 323, 20);
		frame.getContentPane().add(textField_mdp);
		textField_mdp.setColumns(10);

		JButton btnFirstConnex = new JButton("Premi\u00E8re connexion");
		btnFirstConnex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration valid = new Registration();
				valid.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnFirstConnex.setBounds(311, 184, 189, 34);
		btnFirstConnex.setBorder(new RoundedBorder(10));
		frame.getContentPane().add(btnFirstConnex);

		JPanel panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Connection.class.getResource("/image/image2.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 555, 260);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	}

	public void userTest(String userNickname, String password) {

		try {

			String query = "SELECT * FROM `users` WHERE (`nickname` = ? OR `email` = ?) AND `password` = ? ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, userNickname);

			declaration.setString(2, userNickname);

			declaration.setString(3, password);

			ResultSet result = declaration.executeQuery();

			if (result.next() == true) {
				frame.setVisible(false);
				Users userInfo = new Users(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6));
				InfoUser.myUser = userInfo;
				Update.myUser = userInfo;
				InfoUser valid = new InfoUser();
				valid.frame.setVisible(true);

			}

		} catch (Exception e) {

			System.err.println("Erreur d'affichage d'ing: " + e);

		}
	}
}
