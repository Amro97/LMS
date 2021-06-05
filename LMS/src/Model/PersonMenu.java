package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import View.Lib_Menu;
import net.proteanit.sql.DbUtils;

public class PersonMenu extends DBConnector{

	sqliteConnection singelton= sqliteConnection.getInstance();
	Connection connection  = singelton.dbConnector();

	
	public void mouseklicked_panel4(Lib_Menu obj)
	{
		JTable table4=obj.table4;
		JTextField ID=obj.ID;
		JTextField UserName=obj.UserName;
		JTextField Password=obj.Password;
		JTextField Country=obj.Country;
		JTextField City=obj.City;
		JTextField Address=obj.Address;
		JTextField FirstName=obj.FirstName;
		JTextField LastName=obj.LastName;
		JTextField Age=obj.Age;
		JTextField isLibrarian=obj.isLibrarian;
		
		
		
		try 
		{
		int row = table4.getSelectedRow();
		String ID_=(table4.getModel().getValueAt(row, 0)).toString();
			
		String query = "select * from Person where ID = ?"; 
		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, ID_);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			ID.setText(rs.getString("ID"));
			UserName.setText(rs.getString("UserName"));
			Password.setText(rs.getString("Password"));
			Country.setText(rs.getString("Country"));
			City.setText(rs.getString("City"));
			Address.setText(rs.getString("Address"));
			FirstName.setText(rs.getString("FirstName"));
			LastName.setText(rs.getString("LastName"));
			Age.setText(rs.getString("Age"));
			isLibrarian.setText(rs.getString("isLibrarian"));
		}
		pst.close();
		rs.close();
		}
		catch (Exception e1) 
		{
		e1.printStackTrace();
		}
	}
	
	
	
	public void Update_panel4(Lib_Menu obj)
	{
		JTable table4=obj.table4;
		JTextField ID=obj.ID;
		JTextField UserName=obj.UserName;
		JTextField Password=obj.Password;
		JTextField Country=obj.Country;
		JTextField City=obj.City;
		JTextField Address=obj.Address;
		JTextField FirstName=obj.FirstName;
		JTextField LastName=obj.LastName;
		JTextField Age=obj.Age;
		
		String query = "update Person set UserName=?,Password=?,Country=?,City=?,Address=?,FirstName=?,LastName=?,Age=? where ID=?";
		try 
		{
		//int row = table4.getSelectedRow();
		//String ID_=(table4.getModel().getValueAt(row, 0)).toString();
		PreparedStatement pst = connection.prepareStatement(query);
		//pst.setString(1, ID_);
		

		int i=1;
		pst.setString(i++, UserName.getText());
		pst.setString(i++, Password.getText());
		pst.setString(i++, Country.getText());
		pst.setString(i++, City.getText());
		pst.setString(i++, Address.getText());
		pst.setString(i++, FirstName.getText());
		pst.setString(i++, LastName.getText());
		pst.setInt(i++, Integer.parseInt(Age.getText()));
		pst.setInt(i++, Integer.parseInt(ID.getText()));

		pst.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Data Updated Successfully!!!!");
		PanelService.UpdatePanel(5, table4);
		pst.close();
		}
		catch (Exception e1) 
		{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error Please select A Subscriber");
		}
	}
/*	public void Save_panel4(Lib_Menu obj)
	{
		JTable table4=obj.table4;
		JTextField ID=obj.ID;
		JTextField UserName=obj.UserName;
		JTextField Password=obj.Password;
		JTextField Country=obj.Country;
		JTextField City=obj.City;
		JTextField Address=obj.Address;
		JTextField FirstName=obj.FirstName;
		JTextField LastName=obj.LastName;
		JTextField Age=obj.Age;
		JTextField isLibrarian=obj.isLibrarian;
		
		try 
		{
    		String query = "insert into Person (ID,UserName,Password,Country,City,Address,FirstName,LastName,Age,isLibrarian) values (?,?,?,?,?,?,?,?,?,?)";
    		
    		PreparedStatement pst = connection.prepareStatement(query);
    		int i=1;
    		pst.setInt(i++, Integer.parseInt(ID.getText()));
    		pst.setString(i++, UserName.getText());
    		pst.setString(i++, Password.getText());
    		pst.setString(i++, Country.getText());
    		pst.setString(i++, City.getText());
    		pst.setString(i++, Address.getText());
    		pst.setString(i++, FirstName.getText());
    		pst.setString(i++, LastName.getText());
    		pst.setInt(i++, Integer.parseInt(Age.getText()));
    		pst.setString(i++, isLibrarian.getText());
    		
    		pst.execute();
		
		JOptionPane.showMessageDialog(null, "Data Saved");
		PanelService.UpdatePanel(5, table4);
		pst.close();
		}
		catch ( Exception e ) {
            System.err.println( e );
            
        }
	}
	
	
*/	
	
	
	public void Delete_panel4(Lib_Menu obj)
	{
		JTextField ID=obj.ID;
		JTable table4 = obj.table4;
		
		int action = JOptionPane.showConfirmDialog(null, "Are you sure!?!","Delete",JOptionPane.YES_NO_OPTION);
		if(action==0)
		{
			try 
			{
				String query = "Delete from Person where ID='"+ID.getText()+"' ";
				PreparedStatement pst = connection.prepareStatement(query);
		
				pst.execute();
		
				JOptionPane.showMessageDialog(null, "Data Deleted successfully!!");
		
				pst.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			PanelService.UpdatePanel(5, table4);
		}
	}
	
	
	public void keyreleased_panel4(Lib_Menu obj)
	{
		JTextField txtSearch4=obj.txtSearch4;
		JComboBox Search_comboBox4=obj.Search_comboBox4;
		JTable table4=obj.table4;
		try 
		{
		String human = (String)Search_comboBox4.getSelectedItem();
		PreparedStatement pst = connection.prepareStatement(
			    "SELECT * FROM Person WHERE "+human+" like ?");
		pst.setString(1, txtSearch4.getText() + "%");
		ResultSet rs = pst.executeQuery();
		table4.setModel(DbUtils.resultSetToTableModel(rs));
		pst.close();
		rs.close();
		}
		catch (Exception e1) 
		{
		e1.printStackTrace();
		}
	}
}
	
	
