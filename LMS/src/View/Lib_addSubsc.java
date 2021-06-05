package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Lib_addSubscController;
import Model.sqliteConnection;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class Lib_addSubsc extends JFrame {

	public JPanel contentPane;
	public JTextField UserNameField;
	public JTextField PasswordField;
	public JTextField CityField;
	public JTextField CountryField;
	public JTextField LastNameField;
	public JTextField AgeField;
	public JTextField FirstNameField;
	public JTextField AddressField;
	
	
	
	
	///images 
	Image img_regSubsc = new ImageIcon(this.getClass().getResource("/Lib_registeButton.PNG")).getImage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lib_addSubsc frame = new Lib_addSubsc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public Lib_addSubsc() {
		Lib_addSubscController controller = new Lib_addSubscController(this);
		sqliteConnection singelton= sqliteConnection.getInstance();
		connection  = singelton.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 454, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new java.awt.Color(242, 244, 245));//set color of frame
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", lblNewLabel.getFont().getStyle(), lblNewLabel.getFont().getSize() + 7));
		lblNewLabel.setBounds(27, 16, 128, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", lblPassword.getFont().getStyle(), lblPassword.getFont().getSize() + 7));
		lblPassword.setBounds(27, 55, 105, 28);
		contentPane.add(lblPassword);
		
		JLabel lblAshdod = new JLabel("City");
		lblAshdod.setFont(new Font("Tahoma", lblAshdod.getFont().getStyle(), lblAshdod.getFont().getSize() + 7));
		lblAshdod.setBounds(27, 133, 105, 28);
		contentPane.add(lblAshdod);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", lblCountry.getFont().getStyle(), lblCountry.getFont().getSize() + 7));
		lblCountry.setBounds(27, 94, 105, 28);
		contentPane.add(lblCountry);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", lblLastName.getFont().getStyle(), lblLastName.getFont().getSize() + 7));
		lblLastName.setBounds(27, 251, 128, 28);
		contentPane.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", lblAge.getFont().getStyle(), lblAge.getFont().getSize() + 7));
		lblAge.setBounds(27, 290, 105, 28);
		contentPane.add(lblAge);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", lblFirstName.getFont().getStyle(), lblFirstName.getFont().getSize() + 7));
		lblFirstName.setBounds(27, 212, 113, 28);
		contentPane.add(lblFirstName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", lblAddress.getFont().getStyle(), lblAddress.getFont().getSize() + 7));
		lblAddress.setBounds(27, 173, 105, 28);
		contentPane.add(lblAddress);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(195, 18, 176, 26);
		contentPane.add(UserNameField);
		UserNameField.setColumns(10);
		
		PasswordField = new JTextField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(195, 57, 176, 26);
		contentPane.add(PasswordField);
		
		CityField = new JTextField();
		CityField.setColumns(10);
		CityField.setBounds(195, 135, 176, 26);
		contentPane.add(CityField);
		
		CountryField = new JTextField();
		CountryField.setColumns(10);
		CountryField.setBounds(195, 96, 176, 26);
		contentPane.add(CountryField);
		
		LastNameField = new JTextField();
		LastNameField.setColumns(10);
		LastNameField.setBounds(195, 253, 176, 26);
		contentPane.add(LastNameField);
		
		AgeField = new JTextField();
		AgeField.setColumns(10);
		AgeField.setBounds(195, 292, 176, 26);
		contentPane.add(AgeField);
		
		FirstNameField = new JTextField();
		FirstNameField.setColumns(10);
		FirstNameField.setBounds(195, 214, 176, 26);
		contentPane.add(FirstNameField);
		
		AddressField = new JTextField();
		AddressField.setColumns(10);
		AddressField.setBounds(195, 175, 176, 26);
		contentPane.add(AddressField);
		
		//add button
		JButton btnAdd = new JButton("");//Add
		//btnAdd.setFont(new Font("Tahoma", btnAdd.getFont().getStyle(), btnAdd.getFont().getSize() + 7));//add text to button
		btnAdd.setIcon(new ImageIcon(img_regSubsc));
		btnAdd.addActionListener(controller);
		btnAdd.setBounds(205, 336, 145, 64);
		contentPane.add(btnAdd);
	}
}
