package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle.Control;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.InlineView;

import Model.PanelService;
import Model.Subscriber;
import Model.sqliteConnection;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Controller.Subsc_BorrowController;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Subsc_Borrow extends JFrame {
	public Subscriber subsc=null;
	public JList<String> inLibrary;
	public JList ToBorrow;
	public JPanel contentPane;
	public JDateChooser dateChooserFrom;
	public JDateChooser dateChooserUntill;
	public  DefaultListModel model1;
	public  DefaultListModel model2;
	
	
	
	
	//////images 
	Image img_leftArrow = new ImageIcon(this.getClass().getResource("/leftArrow.png")).getImage();
	Image img_rightArrow = new ImageIcon(this.getClass().getResource("/RightArrow.png")).getImage();
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subsc_Borrow frame = new Subsc_Borrow(new Subscriber(6));
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	sqliteConnection singelton= sqliteConnection.getInstance();
	Connection connection  = singelton.dbConnector();
	
	
	/**
	 * Create the frame.
	 */
	public Subsc_Borrow(Subscriber subscriber) {
		super("MA-Library Managment System");
		Subsc_BorrowController controller = new Subsc_BorrowController(this);
		subsc=subscriber;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(0, 43, 191, 347);
		 contentPane.add(scrollPane_1);
		
		 inLibrary = new JList();
		 inLibrary.setBackground(SystemColor.menu);
		 scrollPane_1.setViewportView(inLibrary);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(424, 43, 191, 347);
		 contentPane.add(scrollPane);
		
		 ToBorrow = new JList();
		 ToBorrow.setBackground(SystemColor.menu);
		 scrollPane.setViewportView(ToBorrow);
		
		 model1 = new DefaultListModel();
		 addelements(model1);
		
		 model2 = new DefaultListModel();
		
		
		JLabel lblInLibrary = new JLabel("Books:");
		lblInLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblInLibrary.setFont(new Font("Tahoma", lblInLibrary.getFont().getStyle(), 23));
		lblInLibrary.setBounds(-29, 16, 191, 20);
		contentPane.add(lblInLibrary);
		
		JLabel lblToBorrow = new JLabel("To Borrow");
		lblToBorrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblToBorrow.setFont(new Font("Tahoma", lblToBorrow.getFont().getStyle(), 23));
		
		lblToBorrow.setBounds(424, 16, 182, 20);
		contentPane.add(lblToBorrow);
		
		JButton button = new JButton("");
		button.setActionCommand(">");
		button.setIcon(new ImageIcon(img_rightArrow));
		button.addActionListener(controller);
		button.setBounds(225, 54, 50, 39);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(img_leftArrow));
		button_1.setActionCommand("<");
		button_1.addActionListener(controller);
		button_1.setBounds(225, 106, 50, 39);
		contentPane.add(button_1);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setFont(new Font("Tahoma", btnBorrow.getFont().getStyle(), 22));
		
		btnBorrow.addActionListener(controller);
		btnBorrow.setBounds(225, 357, 159, 29);
		contentPane.add(btnBorrow);
		
		JLabel lblTillWhen = new JLabel("End date:");
		lblTillWhen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTillWhen.setFont(new Font("Tahoma", lblTillWhen.getFont().getStyle(), 20));
		lblTillWhen.setBounds(190, 295, 115, 20);
		contentPane.add(lblTillWhen);
		
		 dateChooserUntill = new JDateChooser();
		 dateChooserUntill.setBackground(SystemColor.menu);
		dateChooserUntill.setDateFormatString("MMM,d,yyyy");
		dateChooserUntill.setBounds(299, 295, 115, 26);
		contentPane.add(dateChooserUntill);
		
		 dateChooserFrom = new JDateChooser();
		 dateChooserFrom.setBackground(SystemColor.menu);
		dateChooserFrom.setDateFormatString("MMM,d,yyyy");
		dateChooserFrom.setBounds(299, 231, 115, 26);
		contentPane.add(dateChooserFrom);
		
		JLabel lblFrom = new JLabel("Start date:");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setFont(new Font("Tahoma", lblFrom.getFont().getStyle(), 20));
		lblFrom.setBounds(190, 237, 109, 20);
		contentPane.add(lblFrom);
		
		JLabel lblAddBook = new JLabel("Add book");
		lblAddBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBook.setBounds(279, 62, 109, 20);
		contentPane.add(lblAddBook);
		
		JLabel lblRemoveBook = new JLabel("Remove book");
		lblRemoveBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRemoveBook.setBounds(266, 121, 146, 20);
		contentPane.add(lblRemoveBook);
		

		
		
		
		
	}
	
	private void addelements(DefaultListModel<String> model) {
		try { 
			String query = "select DISTINCT Name from book join bookscopy using(bookid) where IsRented= 'false'";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
		 
			while(rs.next())
			{ 
				model.addElement(rs.getString("Name"));
			}
			inLibrary.setModel(model);
			
			
			
			pst.close();
			rs.close();
		}
		catch (Exception e) 
		 { 
			 e.printStackTrace(); 
		 }
		
	}
}
