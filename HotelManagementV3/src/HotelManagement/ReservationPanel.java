package HotelManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class ReservationPanel extends JFrame {
	Reservations rs=new Reservations();

	private JPanel contentPane;
	private JTextField TFRID;
	private JTextField TFCID;
	private JTextField TFRN;
	private JTable table;


	public ReservationPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 884, 464);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(0, 0, 884, 85);
		panel.add(panel_1);
		
		JLabel lblManageReservation = new JLabel("MANAGE RESERVATION");
		lblManageReservation.setForeground(Color.WHITE);
		lblManageReservation.setFont(new Font("Shonar Bangla", Font.BOLD, 60));
		panel_1.add(lblManageReservation);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Serif", Font.BOLD, 20));
		label_1.setBounds(10, 100, 121, 23);
		panel.add(label_1);
		
		TFRID = new JTextField();
		TFRID.setColumns(10);
		TFRID.setBounds(150, 105, 174, 20);
		panel.add(TFRID);
		
		TFCID = new JTextField();
		TFCID.setColumns(10);
		TFCID.setBounds(150, 136, 174, 20);
		panel.add(TFCID);
		
		JLabel lblClientId = new JLabel("Client ID");
		lblClientId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientId.setForeground(Color.WHITE);
		lblClientId.setFont(new Font("Serif", Font.BOLD, 20));
		lblClientId.setBounds(10, 131, 121, 23);
		panel.add(lblClientId);
		
		TFRN = new JTextField();
		TFRN.setColumns(10);
		TFRN.setBounds(150, 172, 174, 20);
		panel.add(TFRN);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomNo.setForeground(Color.WHITE);
		lblRoomNo.setFont(new Font("Serif", Font.BOLD, 20));
		lblRoomNo.setBounds(10, 167, 121, 23);
		panel.add(lblRoomNo);
		
		JLabel lblDateIn = new JLabel("Date In");
		lblDateIn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateIn.setForeground(Color.WHITE);
		lblDateIn.setFont(new Font("Serif", Font.BOLD, 20));
		lblDateIn.setBounds(10, 203, 121, 23);
		panel.add(lblDateIn);
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Reservation ID", "Client ID", "Room Number", "Date In", "Date Out"}));
				rs.fillReservationTable(table);
			}
		});
		
		JLabel lblDateOut = new JLabel("Date Out");
		lblDateOut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOut.setForeground(Color.WHITE);
		lblDateOut.setFont(new Font("Serif", Font.BOLD, 20));
		lblDateOut.setBounds(10, 239, 121, 23);
		panel.add(lblDateOut);
		btnRefresh.setFont(new Font("Serif", Font.BOLD, 13));
		btnRefresh.setBounds(597, 427, 89, 23);
		panel.add(btnRefresh);
		
		JDateChooser DCIN = new JDateChooser();
		DCIN.setDateFormatString("dd/MM/yyyy");
		DCIN.setBounds(150, 203, 174, 20);
		panel.add(DCIN);
		
		JDateChooser DCOUT = new JDateChooser();
		DCOUT.setDateFormatString("dd/MM/yyyy");
		DCOUT.setBounds(150, 239, 174, 20);
		panel.add(DCOUT);
		
		JButton btnReserve = new JButton("RESERVE");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int client_id=Integer.valueOf(TFCID.getText());
					int room_number=Integer.valueOf(TFRN.getText());
					
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
					
					String date_in=dateFormat.format(DCIN.getDate()) ;
					String date_out=dateFormat.format(DCOUT.getDate()) ;
					
					if(rs.addReservation(client_id, room_number,date_in,date_out))
					{
						JOptionPane.showMessageDialog(rootPane,"Reserved successfully","ADD Room",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane,"Failed to reserve Room ","Failed to ADD",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(rootPane,ex.getMessage()+"Enter Room number+client ID","Failed to Update",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnReserve.setFont(new Font("Serif", Font.BOLD, 13));
		btnReserve.setBounds(10, 311, 89, 23);
		panel.add(btnReserve);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						
					int reservationId=Integer.valueOf(TFRID.getText());
					int roomNumber=Integer.valueOf(TFRN.getText());
					int clientId=Integer.valueOf(TFCID.getText());
						SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
						String date_in=dateFormat.format(DCIN.getDate()) ;
						String date_out=dateFormat.format(DCOUT.getDate()) ;
					 if(rs.editReservation(reservationId,clientId,roomNumber, date_in,date_out))
						{
							JOptionPane.showMessageDialog(rootPane," Reservation Updated","Updated Reservation",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane,"Failed to update Reservation ","Failed to Reservation",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(rootPane,ex.getMessage()+"Enter all details","Failed to Update",JOptionPane.ERROR_MESSAGE);
					}
				
					
				}
			}
		);
		btnUpdate.setFont(new Font("Serif", Font.BOLD, 13));
		btnUpdate.setBounds(235, 311, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 int reservationId=Integer.valueOf(TFRID.getText());
					 if(rs.remReservation(reservationId))
						{
							JOptionPane.showMessageDialog(rootPane," Reservation Deleted","Deleted Reservation",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane,"Failed to delete Reservation ","Failed to Delete",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(rootPane,ex.getMessage()+"Enter all details","Failed to Delete",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnDelete.setFont(new Font("Serif", Font.BOLD, 13));
		btnDelete.setBounds(124, 311, 89, 23);
		panel.add(btnDelete);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TFCID.setText("");
				TFRID.setText("");
				TFRN.setText("");
				DCIN.setDate(null);
				DCOUT.setDate(null);
			}
		});
		btnReset.setFont(new Font("Serif", Font.BOLD, 13));
		btnReset.setBounds(124, 360, 89, 23);
		panel.add(btnReset);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int rIndex=table.getSelectedRow();
				TFRID.setText(model.getValueAt(rIndex, 0).toString());
				TFCID.setText(model.getValueAt(rIndex, 1).toString());
				TFRN.setText(model.getValueAt(rIndex, 2).toString());
				
				 
				try {
					java.util.Date dateIn = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rIndex, 3).toString());
					DCIN.setDate(dateIn);
					java.util.Date dateOut = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rIndex, 4).toString());
					DCOUT.setDate(dateOut);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Reservation ID", "Client ID", "Room Number", "Date In", "Date Out"
			}
		));
		table.setFont(new Font("Serif", Font.BOLD, 13));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setBounds(334, 85, 550, 330);
		panel.add(table);
		
		rs.fillReservationTable(table);
		
	}
}
