package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Subsc_MenuController;
import Model.Subscriber;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Subsc_Menu extends JFrame {
	private JPanel contentPane;
	public Subscriber subsc=null;

	
	//images 
	Image img_shop = new ImageIcon(this.getClass().getResource("/subsc-Shoping.png")).getImage();
	Image img_myBorrowings = new ImageIcon(this.getClass().getResource("/subsc-My borrowings.png")).getImage();
	Image img_borrow = new ImageIcon(this.getClass().getResource("/subsc-BorrowV2.png")).getImage();
	Image img_myInfo = new ImageIcon(this.getClass().getResource("/subsc-myinfo.png")).getImage();
	Image img_cover = new ImageIcon(this.getClass().getResource("/bookt.png")).getImage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subsc_Menu frame = new Subsc_Menu(new Subscriber(1));
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
	public Subsc_Menu(Subscriber subscriber) {
		super("MA-Library Managment System");
		//initialize controller
		Subsc_MenuController controller = new Subsc_MenuController(this);
		subsc = subscriber;
		System.out.println("welcome "+ subsc.subscriber.getFirstName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 654, 466);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		//contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(controller);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnFile = new JMenu("Menu");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(controller);
		mntmLogout.setIcon(new ImageIcon(Lib_Menu.class.getResource("/empty.png")));
		mnFile.add(mntmLogout);
		mntmExit.setIcon(new ImageIcon(Lib_Menu.class.getResource("/empty.png")));
		mnFile.add(mntmExit);
		
		//borrow button
		JButton btnBorrow = new JButton("");
		btnBorrow.setIcon(new ImageIcon(img_borrow));
		btnBorrow.setActionCommand("Borrow");
		btnBorrow.addActionListener(controller);
		btnBorrow.setBounds(89, 59, 137, 95);
		contentPane.add(btnBorrow);
		
		JButton btnMyInfo = new JButton("");
		btnMyInfo.setIcon(new ImageIcon(img_myInfo));
		btnMyInfo.setActionCommand("My Info");
		btnMyInfo.addActionListener(controller);
		btnMyInfo.setBounds(430, 59, 137, 95);
		contentPane.add(btnMyInfo);
		
		JButton btnShop = new JButton("");
		btnShop.setActionCommand("Shop");
		btnShop.setIcon(new ImageIcon(img_shop));
		btnShop.addActionListener(controller);
		btnShop.setBounds(430, 242, 137, 95);
		contentPane.add(btnShop);
		
		JButton btnBorrowed = new JButton("");
		btnBorrowed.setIcon(new ImageIcon(img_myBorrowings));
		btnBorrowed.setActionCommand("My Borrowings");
		btnBorrowed.addActionListener(controller);
		btnBorrowed.setBounds(89, 242, 137, 95);
		contentPane.add(btnBorrowed);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setFont(new Font("Corbel Light", lblShop.getFont().getStyle() | Font.BOLD, lblShop.getFont().getSize() + 4));
		lblShop.setForeground(new Color(0, 0, 0));
		lblShop.setLabelFor(btnShop);
		lblShop.setBounds(479, 214, 65, 26);
		contentPane.add(lblShop);
		
		JLabel lblMyBorrowings = new JLabel("My Borrowings");
		lblMyBorrowings.setFont(new Font("Corbel Light", lblMyBorrowings.getFont().getStyle() | Font.BOLD, lblMyBorrowings.getFont().getSize() + 4));
		lblMyBorrowings.setForeground(Color.BLACK);
		lblMyBorrowings.setBounds(89, 214, 157, 26);
		contentPane.add(lblMyBorrowings);
		
		JLabel lblBorrow = new JLabel("Borrow");
		lblBorrow.setFont(new Font("Corbel Light", lblBorrow.getFont().getStyle() | Font.BOLD, lblBorrow.getFont().getSize() + 4));
		
		lblBorrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrow.setForeground(Color.BLACK);
		lblBorrow.setBounds(89, 30, 137, 26);
		contentPane.add(lblBorrow);
		
		JLabel lblMyInfo = new JLabel("My Info");
		lblMyInfo.setFont(new Font("Corbel Light", lblMyInfo.getFont().getStyle() | Font.BOLD, lblMyInfo.getFont().getSize() + 4));
		lblMyInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyInfo.setForeground(Color.BLACK);
		lblMyInfo.setBounds(432, 34, 132, 26);
		contentPane.add(lblMyInfo);
		
		//Logo center
		JLabel ImgLable = new JLabel("");
		ImgLable.setIcon(new ImageIcon(img_cover));
		ImgLable.setBounds(258, 59, 345,304);
		contentPane.add(ImgLable);
	}
}
