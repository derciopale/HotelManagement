package HotelManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class RoomPanel extends JFrame {
	Rooms room=new Rooms();
	private JPanel contentPane;
	private JTextField TFRN;
	private JTextField TFPN;
	private JTable table;


	public RoomPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 880, 459);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(0, 0, 874, 68);
		panel.add(panel_1);
		
		JLabel lblManageRooms = new JLabel("MANAGE ROOMS");
		lblManageRooms.setForeground(Color.WHITE);
		lblManageRooms.setFont(new Font("Shonar Bangla", Font.BOLD, 60));
		panel_1.add(lblManageRooms);
		
		JLabel lblRoomNumber = new JLabel("ROOM Number");
		lblRoomNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomNumber.setFont(new Font("Serif", Font.BOLD, 16));
		lblRoomNumber.setForeground(new Color(255, 255, 255));
		lblRoomNumber.setBounds(10, 99, 116, 19);
		panel.add(lblRoomNumber);
		
		TFRN = new JTextField();
		TFRN.setBounds(140, 99, 163, 20);
		panel.add(TFRN);
		TFRN.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Serif", Font.BOLD, 16));
		lblType.setBounds(10, 124, 116, 20);
		panel.add(lblType);
		
		JComboBox CBT = new JComboBox();
		CBT.setFont(new Font("Serif", Font.BOLD, 15));
		CBT.setBounds(140, 126, 51, 18);
		panel.add(CBT);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(140, 197, 51, 23);
		panel.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(200, 197, 51, 23);
		panel.add(rdbtnNo);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Serif", Font.BOLD, 16));
		lblPhoneNo.setBounds(10, 155, 116, 20);
		panel.add(lblPhoneNo);
		
		TFPN = new JTextField();
		TFPN.setColumns(10);
		TFPN.setBounds(140, 157, 163, 20);
		panel.add(TFPN);
		
		JButton btnAddRoom = new JButton("ADD ROOM");
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int roomNumber=Integer.valueOf(TFRN.getText());
					int roomType=Integer.valueOf(CBT.getSelectedItem().toString());
					String phone=TFPN.getText();
					
					if(room.addRoom(roomNumber, roomType, phone))
					{
						JOptionPane.showMessageDialog(rootPane,"New Room Added","ADD Room",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane,"Failed to add Room ","Failed to ADD",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(rootPane,ex.getMessage()+"Enter Room number","Failed to Update",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddRoom.setFont(new Font("Serif", Font.BOLD, 13));
		btnAddRoom.setBounds(10, 254, 110, 23);
		panel.add(btnAddRoom);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int roomNumber= 0;
				int type=Integer.valueOf(CBT.getSelectedItem().toString()) ;
				String phone=TFPN.getText();
				String isReserved="No";
				if(rdbtnYes.isSelected())
				{
					isReserved="Yes";
				}
				if(phone.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane,"Fill all the details ","Failed to Update",JOptionPane.WARNING_MESSAGE);
				}
				
				else
				{
					try {
					 roomNumber=Integer.valueOf(TFRN.getText());
					 if(room.editRoom(roomNumber, type, phone, isReserved))
						{
							JOptionPane.showMessageDialog(rootPane," Room Updated","Updated Room",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane,"Failed to update Room ","Failed to Update",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(rootPane,ex.getMessage()+"Enter Client ID","Failed to Update",JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		btnUpdate.setFont(new Font("Serif", Font.BOLD, 13));
		btnUpdate.setBounds(193, 255, 110, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 int roomNumber=Integer.valueOf(TFRN.getText());
					 if(room.remRoom(roomNumber))
						{
							JOptionPane.showMessageDialog(rootPane," Room Deleted","Deleted Room",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane,"Failed to delete Room ","Failed to Delete",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(rootPane,ex.getMessage()+"Enter Room Number","Failed to Delete",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnDelete.setFont(new Font("Serif", Font.BOLD, 13));
		btnDelete.setBounds(103, 299, 103, 23);
		panel.add(btnDelete);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TFRN.setText("");
				TFPN.setText("");
				CBT.setSelectedIndex(0);
				rdbtnYes.setSelected(false);
				rdbtnNo.setSelected(true);
			}
			
		});
		btnReset.setFont(new Font("Serif", Font.BOLD, 13));
		btnReset.setBounds(103, 344, 103, 23);
		panel.add(btnReset);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int rIndex=table.getSelectedRow();
				TFRN.setText(model.getValueAt(rIndex, 0).toString());
				CBT.setSelectedItem(model.getValueAt(rIndex, 1));
				TFPN.setText(model.getValueAt(rIndex, 2).toString());
				String isReserved=model.getValueAt(rIndex, 3).toString();
				
				if(isReserved.equals("Yes")) {
					rdbtnYes.setSelected(true);
				}
				else if(isReserved.equals("No"))
				{
					rdbtnNo.setSelected(true);
				}
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Type", "Phone Number", "Reserved"
			}
		)
		{
		public boolean isCellEditable(int row,int coloumn) {
		return false;
	}}
				);
		table.setBounds(315, 79, 559, 334);
		panel.add(table);
		
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Number","Type","Phone","Reserved"}));
				room.fillRoomsTable(table);
			}
		});
		btnRefresh.setFont(new Font("Serif", Font.BOLD, 13));
		btnRefresh.setBounds(554, 427, 103, 23);
		panel.add(btnRefresh);
		room.fillRTypeCombo(CBT);
		room.fillRoomsTable(table);
		
		JButton btnNewButton = new JButton("Show Types");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomType rt=new RoomType();
				rt.setVisible(true);
			//	rt.pack();
				rt.setLocationRelativeTo(null);
				rt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//rt.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 13));
		btnNewButton.setBounds(200, 125, 103, 23);
		panel.add(btnNewButton);
		
		JLabel lblReservation = new JLabel("Reservation");
		lblReservation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReservation.setForeground(Color.WHITE);
		lblReservation.setFont(new Font("Serif", Font.BOLD, 16));
		lblReservation.setBounds(10, 196, 116, 20);
		panel.add(lblReservation);
		

		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnYes);
		bg.add(rdbtnNo);
		}
}
