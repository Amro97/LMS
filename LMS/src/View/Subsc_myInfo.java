package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Subscriber;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Color;

public class Subsc_myInfo extends JFrame {
	private JLabel lblHelloSubscriber;
	private JPanel contentPane;
	private JTextField numBorrowField;
	private JTextField FirstNameField;
	private JTextField LastNameField;
	private JTextField CityField;
	private JTextField AddressField;
	private JTextField CountryField;
	private JLabel lblAge;
	private JTextField AgeField;
	
	Image img_lib = new ImageIcon(this.getClass().getResource("/person.PNG")).getImage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subsc_myInfo frame = new Subsc_myInfo(new Subscriber(6));//6=Amro
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Subsc_myInfo(Subscriber subsc) {
		super("MA-Library Managment System");
		subsc = new Subscriber(subsc.subscriber.getID());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 534, 480);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("info"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHelloSubscriber = new JLabel("Hello *****");
		lblHelloSubscriber.setForeground(SystemColor.textHighlight);
		lblHelloSubscriber.setFont(new Font("Tahoma", lblHelloSubscriber.getFont().getStyle() | Font.BOLD, lblHelloSubscriber.getFont().getSize() + 30));
		lblHelloSubscriber.setBounds(91, 22, 365, 71);
		contentPane.add(lblHelloSubscriber);
		
		JLabel lblName = new JLabel("First name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(15, 111, 122, 20);
		contentPane.add(lblName);
		
		JLabel lblNickname = new JLabel("Last name:");
		lblNickname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNickname.setBounds(15, 147, 122, 20);
		contentPane.add(lblNickname);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCity.setBounds(15, 183, 122, 20);
		contentPane.add(lblCity);
		
		JLabel lblCity_1 = new JLabel("Address:");
		lblCity_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCity_1.setBounds(15, 219, 122, 20);
		contentPane.add(lblCity_1);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCountry.setBounds(15, 255, 122, 20);
		contentPane.add(lblCountry);
		
		JLabel lblBooksowned = new JLabel("Books Borrowed");
		lblBooksowned.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooksowned.setBounds(150, 348, 146, 20);
		contentPane.add(lblBooksowned);
		
		//user image Icon
		JLabel ImgInfoLable = new JLabel("");
		ImgInfoLable.setIcon(new ImageIcon(img_lib));
		ImgInfoLable.setBounds(260,-10,400, 440);
		contentPane.add(ImgInfoLable);
		
		numBorrowField = new JTextField();
		numBorrowField.setForeground(SystemColor.controlDkShadow);
		numBorrowField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		numBorrowField.setEditable(false);
		//numBorrowField.setBackground(SystemColor.textHighlight);
		numBorrowField.setHorizontalAlignment(SwingConstants.CENTER);
		numBorrowField.setText("99999");
		numBorrowField.setBounds(145, 373, 140, 43);//num box
		contentPane.add(numBorrowField);
		numBorrowField.setColumns(10);
		
		
		FirstNameField = new JTextField();
		FirstNameField.setBackground(SystemColor.controlHighlight);
		FirstNameField.setEditable(false);
		FirstNameField.setBounds(150, 109, 146, 26);
		contentPane.add(FirstNameField);
		FirstNameField.setColumns(10);
		
		LastNameField = new JTextField();
		LastNameField.setEditable(false);
		LastNameField.setBackground(SystemColor.controlHighlight);
		LastNameField.setColumns(10);
		LastNameField.setBounds(150, 147, 146, 26);
		contentPane.add(LastNameField);
		
		CityField = new JTextField();
		CityField.setEditable(false);
		CityField.setBackground(SystemColor.controlHighlight);
		CityField.setColumns(10);
		CityField.setBounds(150, 183, 146, 26);
		contentPane.add(CityField);
		
		AddressField = new JTextField();
		AddressField.setEditable(false);
		AddressField.setBackground(SystemColor.controlHighlight);
		AddressField.setColumns(10);
		AddressField.setBounds(150, 217, 146, 26);
		contentPane.add(AddressField);
		
		CountryField = new JTextField();
		CountryField.setEditable(false);
		CountryField.setColumns(10);
		CountryField.setBackground(SystemColor.controlHighlight);
		CountryField.setBounds(150, 253, 146, 26);
		contentPane.add(CountryField);
		
		lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(15, 293, 122, 20);
		contentPane.add(lblAge);
		
		AgeField = new JTextField();
		AgeField.setText((String) null);
		AgeField.setEditable(false);
		AgeField.setColumns(10);
		AgeField.setBackground(SystemColor.controlHighlight);
		AgeField.setBounds(150, 291, 146, 26);
		contentPane.add(AgeField);
		
		
		
		Update_SubscMyInfo(subsc);
		
	}
	
	
	
	private void Update_SubscMyInfo(Subscriber subsc)
	{
		numBorrowField.setText(String.valueOf(subsc.getNumOfBorrowedBooks()));
		lblHelloSubscriber.setText("user: " + subsc.subscriber.getFirstName());
		FirstNameField.setText(subsc.subscriber.getFirstName());
		LastNameField.setText(subsc.subscriber.getLastName());
		CityField.setText(subsc.subscriber.getCity());
		AddressField.setText(subsc.subscriber.getAddress());
		CountryField.setText(subsc.subscriber.getCountry());
		AgeField.setText(String.valueOf(subsc.subscriber.getAge()));
	}
}
