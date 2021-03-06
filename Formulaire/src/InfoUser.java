

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JPasswordField;

public class InfoUser extends ServeurConnexion{

	 static JFrame frame;
	private static JTextField textFieldName;
	private static JTextField textField_FirstName;
	private static JTextField textField_Town;
	private static JTextField textField_Email;
	private static JTextField textField_Pseudo;
	private static JTextField textField_Mtp;
	private static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_4;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_6;
	private static JLabel lblNewLabel_7;
	private static JButton btnClose;
	public static Users myUser ; 
	
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
	 * @wbp.parser.entryPoint
	 */
	public InfoUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	static void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(46, 139, 87));
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
		
		
		textFieldName.setEditable(false);
		textFieldName.setBounds(170, 83, 409, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		textField_FirstName = new JTextField(myUser.getFirstname());
		textField_FirstName.setEditable(false);
		textField_FirstName.setBounds(170, 125, 409, 20);
		frame.getContentPane().add(textField_FirstName);
		textField_FirstName.setColumns(10);

		textField_Town = new JTextField(myUser.getTown());
		textField_Town.setEditable(false);
		textField_Town.setBounds(170, 170, 409, 20);
		frame.getContentPane().add(textField_Town);
		textField_Town.setColumns(10);

		textField_Email = new JTextField(myUser.getEmail());
		textField_Email.setEditable(false);

		textField_Email.setBounds(170, 219, 409, 20);
		frame.getContentPane().add(textField_Email);
		textField_Email.setColumns(10);

		textField_Pseudo = new JTextField(myUser.getNickname());
		textField_Pseudo.setEditable(false);
		textField_Pseudo.setBounds(170, 271, 409, 20);
		frame.getContentPane().add(textField_Pseudo);
		textField_Pseudo.setColumns(10);

		textField_Mtp = new JPasswordField(myUser.getPassword());
		textField_Mtp.setEditable(false);
		textField_Mtp.setBounds(170, 320, 409, 20);
		frame.getContentPane().add(textField_Mtp);
		textField_Mtp.setColumns(10);

		JButton btnNewButton = new JButton("Modifier les informations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Update valid = new Update();
				valid.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(285, 369, 234, 46);
		btnNewButton.setBorder(new RoundedBorder(10));
		frame.getContentPane().add(btnNewButton);
		
		btnClose = new JButton("Deconnection");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component btnOK = null;
				int i=JOptionPane.showConfirmDialog( btnOK, "Voulez vous quitter??" );
				if(i==JOptionPane.OK_OPTION)
				{
				//instruction si confirmation	
				Connection valid = new Connection();
				valid.frame.setVisible(true);
				frame.setVisible(false);
				}else {
					frame.setVisible(true);
				}
			
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBackground(Color.RED);
		btnClose.setBounds(62, 369, 160, 46);
		btnClose.setBorder(new RoundedBorder(10));
		frame.getContentPane().add(btnClose);
		JPanel panel = new JPanel() {
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
}
