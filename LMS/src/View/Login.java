package View;

import java.awt.EventQueue;
import Model.Book;
import Model.BookService;
import Model.PanelService;
import Model.Person;
import Model.Subscriber;
import Model.sqliteConnection;

import java.sql.*;
import java.util.List;

import javax.swing.*;

import Controller.LoginController;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Button;

public class Login {
	
	public JRadioButton rdbtnLibrarian;
	JRadioButton rdbtnSubscriber;
	public JFrame frame;
	public JTextField usernameField;
	public JPasswordField passwordField;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					Login window = new Login();
					
					window.frame.setVisible(true);
					
			}
		});
	}
	
	
	//images
	Image img_login = new ImageIcon(this.getClass().getResource("/secrecy-icon.png")).getImage();
	Image img_radioSubsc = new ImageIcon(this.getClass().getResource("/Subscriber.png")).getImage();
	Image img_radiolibrarian = new ImageIcon(this.getClass().getResource("/Librarian.png")).getImage();
	Image img_cover = new ImageIcon(this.getClass().getResource("/cover.jpg")).getImage();
	
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		LoginController controller = new LoginController(this);//this=login object
		frame = new JFrame("MA-Library Managment System");
		frame.getContentPane().setBackground( new java.awt.Color(242, 244, 245) );
		frame.setBounds(600, 300, 697, 428);//600, 300, 697, 428
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//User name text
		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		//lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(330, 127, 122, 43);
		frame.getContentPane().add(lblNewLabel);
		
		//Password text
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(330, 175, 109, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(448, 127, 216, 43);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon(img_login));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(controller);
		btnNewButton.setBounds(448, 280, 216, 43);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(448, 183, 216, 40);
		frame.getContentPane().add(passwordField);
		
		
	    rdbtnLibrarian = new JRadioButton("Librarian");
		rdbtnLibrarian.setBounds(580, 69, 155, 29);
		frame.getContentPane().add(rdbtnLibrarian);
		
		rdbtnSubscriber = new JRadioButton("Subscriber");
		rdbtnSubscriber.setSelected(true);
		rdbtnSubscriber.setBounds(450, 69, 155, 29);
		frame.getContentPane().add(rdbtnSubscriber);
		
		ButtonGroup bg1 = new ButtonGroup( );//group radio buttons
		bg1.add(rdbtnSubscriber);
		bg1.add(rdbtnLibrarian);
		
		//subscriber image
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(img_radioSubsc));
		lblNewLabel_2.setBounds(450, 52, 80, 20);//354, 52, 69, 20
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img_radiolibrarian));
		label.setBounds(580, 52, 69, 20);
		frame.getContentPane().add(label);
		
		//Cover photo
		JLabel ImgLable = new JLabel("");
		ImgLable.setIcon(new ImageIcon(img_cover));
		ImgLable.setBounds(-20, 0, 711,428);
		frame.getContentPane().add(ImgLable);
	}
}
