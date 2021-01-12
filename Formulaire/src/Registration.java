

import java.awt.EventQueue;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Registration extends ServeurConnexion {

	JFrame frame;
	private static JTextField textFieldName;
	private static JTextField textField_FirstName;
	private static JTextField textField_Town;
	private static JTextField textField_Email;
	private static JTextField textField_Pseudo;
	private static JTextField textField_Mtp;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(60, 179, 113));
		frame.setBounds(100, 100, 622, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("INSCRIPTION NESTI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 28, 222, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Vous pouvez vous inscrire via ce formulaire :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 52, 293, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Votre nom :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(27, 86, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Votre pr\u00E9nom :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(31, 128, 100, 14);
		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Ville :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(27, 172, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("* E-mail : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(22, 221, 71, 14);
		frame.getContentPane().add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("* Pseudo : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(27, 273, 85, 14);
		frame.getContentPane().add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("* Mot De Passe : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(27, 323, 114, 14);
		frame.getContentPane().add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("* Champs obligatoires");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(285, 416, 158, 20);
		frame.getContentPane().add(lblNewLabel_8);

		textFieldName = new JTextField();
		textFieldName.setBounds(170, 83, 409, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		textField_FirstName = new JTextField();
		textField_FirstName.setBounds(170, 125, 409, 20);
		frame.getContentPane().add(textField_FirstName);
		textField_FirstName.setColumns(10);

		textField_Town = new JTextField();
		textField_Town.setBounds(170, 170, 409, 20);
		frame.getContentPane().add(textField_Town);
		textField_Town.setColumns(10);

		textField_Email = new JTextField();

		textField_Email.setBounds(170, 219, 409, 20);
		frame.getContentPane().add(textField_Email);
		textField_Email.setColumns(10);

		textField_Pseudo = new JTextField();
		textField_Pseudo.setBounds(170, 271, 409, 20);
		frame.getContentPane().add(textField_Pseudo);
		textField_Pseudo.setColumns(10);

		textField_Mtp = new JTextField();
		textField_Mtp.setBounds(170, 320, 409, 20);
		frame.getContentPane().add(textField_Mtp);
		textField_Mtp.setColumns(10);

		JButton btnNewButton = new JButton("INSCRIPTION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				validation();
				

			}
		});
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(285, 369, 160, 46);
		btnNewButton.setBorder(new RoundedBorder(10));
		frame.getContentPane().add(btnNewButton);

		panel = new JPanel() {

			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Connection.class.getResource("/image/image2.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBounds(0, 0, 606, 447);
		frame.getContentPane().add(panel);

	}

	/**
	 * Email validation
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		boolean IsMatch = m.matches();

		if (IsMatch == false) {

			IsMatch = false;
		} else {
			IsMatch = m.matches();

		}

		return IsMatch;
	}

	/**
	 * Request to serveur
	 */
	public static void actionGiveServeur() {
		ServeurConnexion.openConnection();
		// QueryUsers.readAll();
		QueryUsers.create(textFieldName.getText(), textField_FirstName.getText(), textField_Town.getText(),
				textField_Email.getText(), textField_Mtp.getText(), textField_Pseudo.getText());
		showMessageDialog(null, "Utilisateur enregister!");
		QueryUsers.readAll();
		ServeurConnexion.closeConnection();
	}

	/**
	 * Email and password validation
	 */
	public static void validation() {
		if ((!textFieldName.getText().isEmpty()) && (!textField_FirstName.getText().isEmpty())
				&& (!textField_Town.getText().isEmpty()) && (!textField_Town.getText().isEmpty())) {

			if ((isValidEmailAddress(textField_Email.getText()) == true)) {
				textField_Email.setBackground(Color.white);
				if ((force(textField_Mtp.getText()) > 82)) {
					textField_Mtp.setBackground(Color.white);
					actionGiveServeur();

				} else {
					showMessageDialog(null, "Votre mot de passe est trop faible");
					textField_Mtp.setText("Mot de passe trop simple : changer le ");
					textField_Mtp.setBackground(Color.RED);
				}
			} else {
				textField_Email.setText("Email invalide");
				textField_Email.setBackground(Color.RED);
				showMessageDialog(null, "Email est invalide");
			}
		} else {

			showMessageDialog(null, "Certain champs sont vide !");
		}
	}

	/**
	 * Comparison of the user password with the standard.
	 * 
	 * @param mdp
	 * @return
	 */
	public static long force(String mdp) {
		// La Longueur
		int l = mdp.length();
		// Le nombre de caractères
		int n = alphabet(mdp);

		// Appliquer la formule
		double force = l * (Math.log(n) / Math.log(2));
		long forceRest;
		if (force <= 82) {

			forceRest = 0;
		} else {
			forceRest = Math.round(force);
		}
		return forceRest;
	}

	/**
	 * Word strength count
	 * 
	 * @param mdp
	 * @return
	 */
	public static int alphabet(String mdp) {
		int n = 0;
		Pattern regex1 = Pattern.compile("[0-9]");
		Matcher matcher1 = regex1.matcher(mdp);
		if (matcher1.find()) {
			// if (mdp.matches("")) {
			n += 10;
		}
		Pattern regex2 = Pattern.compile("[a-z]");
		Matcher matcher2 = regex2.matcher(mdp);
		if (matcher2.find()) {
			// if (mdp.matches("a-z")) {
			n += 26;
		}
		Pattern regex3 = Pattern.compile("[A-Z]");
		Matcher matcher3 = regex3.matcher(mdp);
		if (matcher3.find()) {
			// if (mdp.matches("A-Z")) {
			n += 26;
		}
		Pattern regex = Pattern.compile("[$&+,:;=?@#|]");
		Matcher matcher = regex.matcher(mdp);
		if (matcher.find()) {
			n += 8;
		}

		return n;
	}

}
