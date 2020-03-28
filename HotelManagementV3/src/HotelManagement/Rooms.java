package HotelManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Rooms {
	Connections con=new Connections();
	public void fillRTypeTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery="SELECT * FROM `type`";
		
		try {
			ps=con.createConnection().prepareStatement(selectQuery);
			rs=ps.executeQuery();
			
			DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
			
			Object[] row;
			while(rs.next())
			{
				row= new Object[3];
				row[0]=rs.getInt(1);
				row[1]=rs.getString(2);
				row[2]=rs.getString(3);
			tableModel.addRow(row);
			
			}
			
		} catch (SQLException e) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void fillRoomsTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery="SELECT * FROM `rooms`";
		
		try {
			ps=con.createConnection().prepareStatement(selectQuery);
			rs=ps.executeQuery();
			
			DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
			
			Object[] row;
			while(rs.next())
			{
				row= new Object[4];
				row[0]=rs.getInt(1);
				row[1]=rs.getInt(2);
				row[2]=rs.getString(3);
				row[3]=rs.getString(4);
				tableModel.addRow(row);
			
			}
			
		} catch (SQLException e) {
			
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	public void fillRTypeCombo(JComboBox CBT)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery="SELECT * FROM `type`";
		
		try {
			ps=con.createConnection().prepareStatement(selectQuery);
			rs=ps.executeQuery();
			
			while(rs.next())
			{

			CBT.addItem(rs.getInt(1));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean addRoom(int number, int type, String phone)
	{	
		
		PreparedStatement st;
		ResultSet rs;
		String addQuery="INSERT INTO `rooms`(`r_number`, `type`, `phone`, `reserved`) VALUES (?,?,?,?)";
		
		try {
			st=con.createConnection().prepareStatement(addQuery);
			st.setInt(1, number);
			st.setInt(2, type);
			st.setString(3, phone);
			st.setString(4, "NO");
			
			
			return (st.executeUpdate()>0);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean editRoom(int number,int type, String phone,String isReserved)
	{
		PreparedStatement st;
		ResultSet rs;
		String editQuery="UPDATE `rooms` SET `type`=?,`phone`=?,`reserved`=? WHERE `r_number`=?";
		
		try {
			st=con.createConnection().prepareStatement(editQuery);
			st.setInt(1, type);
			st.setString(2, phone);
			st.setString(3, isReserved);
			st.setInt(4, number);
				return (st.executeUpdate()>0);
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean remRoom(int roomNumber)
	{
		PreparedStatement st;
		ResultSet rs;
		String delQuery="DELETE FROM `rooms` WHERE `r_number`=?";
		
		try {
			st=con.createConnection().prepareStatement(delQuery);
			st.setInt(1,roomNumber);
			
			return (st.executeUpdate()>0);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
