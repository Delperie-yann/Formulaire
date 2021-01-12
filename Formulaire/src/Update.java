

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showMessageDialog;

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
import java.awt.Component;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Update extends ServeurConnexion {

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
	public static Users myUser;
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
	 * 
	 * @wbp.parser.entryPoint
	 */
	public Update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(60, 179, 113));
		frame.setBounds(100, 100, 622, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Information utilisateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 28, 222, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Les information vous concernants :");
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

		textFieldName = new JTextField(myUser.getName());
		textFieldName.setBounds(170, 83, 409, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		textField_FirstName = new JTextField(myUser.getFirstname());
		textField_FirstName.setBounds(170, 125, 409, 20);
		frame.getContentPane().add(textField_FirstName);
		textField_FirstName.setColumns(10);

		textField_Town = new JTextField(myUser.getTown());
		textField_Town.setBounds(170, 170, 409, 20);
		frame.getContentPane().add(textField_Town);
		textField_Town.setColumns(10);

		textField_Email = new JTextField(myUser.getEmail());

		textField_Email.setBounds(170, 219, 409, 20);
		frame.getContentPane().add(textField_Email);
		textField_Email.setColumns(10);

		textField_Pseudo = new JTextField(myUser.getNickname());
		textField_Pseudo.setEditable(false);
		textField_Pseudo.setBounds(170, 271, 409, 20);
		frame.getContentPane().add(textField_Pseudo);
		textField_Pseudo.setColumns(10);

		textField_Mtp = new JTextField(myUser.getPassword());
		textField_Mtp.setBounds(170, 320, 409, 20);
		frame.getContentPane().add(textField_Mtp);
		textField_Mtp.setColumns(10);

		JButton btnNewButton = new JButton("Mise \u00E0 jour des informations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component btnOK = null;
				int i = JOptionPane.showConfirmDialog(btnOK, "Vous confirmez ?");
				if (i == JOptionPane.OK_OPTION) {
					validation();
					frame.setVisible(false);
					InfoUser valid = new InfoUser();
					valid.frame.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(184, 370, 234, 46);
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
	 * Email and password validation
	 */
	public static void validation() {
		if (((!textFieldName.getText().isEmpty()) && (!textField_FirstName.getText().isEmpty())
				&& (!textField_Town.getText().isEmpty()) && (!textField_Town.getText().isEmpty()))) {

			if ((Registration.isValidEmailAddress(textField_Email.getText()) == true)) {
				textField_Email.setBackground(Color.white);
				if ((Registration.force(textField_Mtp.getText()) > 82)) {
					
					textField_Mtp.setBackground(Color.white);
					ServeurConnexion.openConnection();
					
					QueryUsers.update(textFieldName.getText(), textField_FirstName.getText(), textField_Town.getText(),
							textField_Email.getText(), textField_Mtp.getText(), textField_Pseudo.getText());
					
					myUser.setName(textFieldName.getText());
					myUser.setFirstname(textField_FirstName.getText());
					myUser.setTown(textField_Town.getText());
					myUser.setEmail(textField_Email.getText());
					myUser.setPassword(textField_Mtp.getText());
					
					ServeurConnexion.closeConnection();
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
}
