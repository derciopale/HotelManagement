package HotelManagement;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Reservations {
	Connections con=new Connections();

	public boolean addReservation(int client_id,int room_number, String date_in,String date_out )
	{	
		
		PreparedStatement st;
		ResultSet rs;
		String addQuery="INSERT INTO `reservations`(`client_id`, `room_number`, `date_in`, `date_out`) VALUES (?,?,?,?)";
		
		try {
			st=con.createConnection().prepareStatement(addQuery);
			st.setInt(1, client_id);
			st.setInt(2, room_number);
			st.setString(3, date_in);
			st.setString(4, date_out);
			//st.setString(5, "No");
			
			
			return (st.executeUpdate()>0);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean editReservation(int reservation_id,int clinet_id,int room_number,String date_in,String date_out)
	{
		PreparedStatement st;
		ResultSet rs;
		String editQuery="UPDATE `reservations` SET `client_id`=?,`room_number`=?,`date_in`=?,`date_out`=? WHERE `id`=?";
		
		try {
			st=con.createConnection().prepareStatement(editQuery);
			st.setInt(1, clinet_id);
			st.setInt(2, room_number);
			st.setString(3, date_in);
			st.setString(4, date_out);
			st.setInt(5, reservation_id);

				return (st.executeUpdate()>0);
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean remReservation(int reservation_id)
	{
		PreparedStatement st;
		ResultSet rs;
		String delQuery="DELETE FROM `reservations` WHERE `id`=?";
		
		try {
			st=con.createConnection().prepareStatement(delQuery);
			st.setInt(1,reservation_id);
			
			return (st.executeUpdate()>0);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public void fillReservationTable(JTable table)
	{
		PreparedStatement ps;
		ResultSet rs;
		String selectQuery="SELECT * FROM `reservations`";
		
		try {
			ps=con.createConnection().prepareStatement(selectQuery);
			rs=ps.executeQuery();
			
			DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
			
			Object[] row;
			while(rs.next())
			{
				row= new Object[5];
				row[0]=rs.getInt(1);
				row[1]=rs.getInt(2);
				row[2]=rs.getInt(3);
				row[3]=rs.getString(4);
				row[4]=rs.getString(5);
				tableModel.addRow(row);
			
			}
			
		} catch (SQLException e) {
			
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE,null,e);
		}
	}
}
