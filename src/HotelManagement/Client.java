package HotelManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Client {
	Connections con=new Connections();
	public boolean addClient(String fname, String lname, String phone,String email)
	{	
		
		PreparedStatement st;
		ResultSet rs;
		String addQuery="INSERT INTO `clients`( `first_name`, `last_name`, `phone`, `email`) VALUES (?,?,?,?)";
		
		try {
			st=con.createConnection().prepareStatement(addQuery);
			st.setString(1, fname);
			st.setString(2, lname);
			st.setString(3, phone);
			st.setString(4, email);
			
			return (st.executeUpdate()>0);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public boolean remClient(int id)
	{
		PreparedStatement st;
		ResultSet rs;
		String delQuery="DELETE FROM `clients` WHERE `id`=?";
		
		try {
			st=con.createConnection().prepareStatement(delQuery);
			st.setInt(1,id);
			
			return (st.executeUpdate()>0);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean editClient(int id,String fname, String lname, String phone,String email)
	{
		PreparedStatement st;
		ResultSet rs;
		String editQuery="UPDATE `clients` SET `first_name`=?,`last_name`=?,`phone`=?,`email`=? WHERE `id`=?";
		
		try {
			st=con.createConnection().prepareStatement(editQuery);
			st.setString(1, fname);
			st.setString(2, lname);
			st.setString(3, phone);
			st.setString(4, email);
			st.setInt(5, id);
				return (st.executeUpdate()>0);
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public void fillTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery="SELECT * FROM `clients`";
		
		try {
			ps=con.createConnection().prepareStatement(selectQuery);
			rs=ps.executeQuery();
			
			DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
			
			Object[] row;
			while(rs.next())
			{
				row= new Object[5];
				row[0]=rs.getInt(1);
				row[1]=rs.getString(2);
				row[2]=rs.getString(3);
				row[3]=rs.getString(4);
				row[4]=rs.getString(5);
			tableModel.addRow(row);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
