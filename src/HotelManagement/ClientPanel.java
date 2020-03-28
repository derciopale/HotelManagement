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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.sql.*;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientPanel extends JFrame {

	private JPanel contentPane;
	private JTextField TFID;
	private JTextField TFFN;
	private JTextField TFLN;
	private JTextField TFCN;
	private JTextField TFE;
	
	Client client=new Client();
	private JTable table;


	public ClientPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 884, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(0, 0, 884, 85);
		panel.add(panel_1);
		
		JLabel lblClientPanel = new JLabel("Client Panel");
		panel_1.add(lblClientPanel);
		lblClientPanel.setFont(new Font("Shonar Bangla", Font.BOLD, 60));
		lblClientPanel.setForeground(new Color(255, 255, 255));
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Serif", Font.BOLD, 20));
		lblId.setBounds(10, 100, 121, 23);
		panel.add(lblId);
		
		TFID = new JTextField();
		TFID.setBounds(150, 105, 174, 20);
		panel.add(TFID);
		TFID.setColumns(10);
		
		TFFN = new JTextField();
		TFFN.setColumns(10);
		TFFN.setBounds(150, 136, 174, 20);
		panel.add(TFFN);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Serif", Font.BOLD, 20));
		lblFirstName.setBounds(10, 131, 121, 23);
		panel.add(lblFirstName);
		
		TFLN = new JTextField();
		TFLN.setColumns(10);
		TFLN.setBounds(150, 172, 174, 20);
		panel.add(TFLN);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Serif", Font.BOLD, 20));
		lblLastName.setBounds(10, 167, 121, 23);
		panel.add(lblLastName);
		
		TFCN = new JTextField();
		TFCN.setColumns(10);
		TFCN.setBounds(150, 208, 174, 20);
		panel.add(TFCN);
		
		JLabel lblContactNumb = new JLabel("Contact Numb");
		lblContactNumb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactNumb.setForeground(Color.WHITE);
		lblContactNumb.setFont(new Font("Serif", Font.BOLD, 20));
		lblContactNumb.setBounds(10, 203, 121, 23);
		panel.add(lblContactNumb);
		
		TFE = new JTextField();
		TFE.setColumns(10);
		TFE.setBounds(150, 244, 174, 20);
		panel.add(TFE);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Serif", Font.BOLD, 20));
		lblEmail.setBounds(10, 239, 121, 23);
		panel.add(lblEmail);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname=TFFN.getText();
				String lname=TFLN.getText();
				String phone=TFCN.getText();
				String email=TFE.getText();
				
				if(fname.trim().equals("")||lname.trim().equals("")||phone.trim().equals("")||email.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane,"Fill all the details ","Failed to ADD",JOptionPane.WARNING_MESSAGE);
				}
				
				else
				{
					if(client.addClient(fname, lname, phone, email))
					{
						JOptionPane.showMessageDialog(rootPane,"New Client Added","ADD Client",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane,"Failed to add Client ","Failed to ADD",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnInsert.setFont(new Font("Serif", Font.BOLD, 13));
		btnInsert.setBounds(10, 311, 89, 23);
		panel.add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int id= 0;
				String fname=TFFN.getText();
				String lname=TFLN.getText();
				String phone=TFCN.getText();
				String email=TFE.getText();
				if(fname.trim().equals("")||lname.trim().equals("")||phone.trim().equals("")||email.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane,"Fill all the details ","Failed to Update",JOptionPane.WARNING_MESSAGE);
				}
				
				else
				{
					try {
					 id=Integer.valueOf(TFID.getText());
					 if(client.editClient(id,fname, lname, phone, email))
						{
							JOptionPane.showMessageDialog(rootPane," Client Updated","Updated Client",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane,"Failed to update Client ","Failed to Update",JOptionPane.ERROR_MESSAGE);
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
		btnUpdate.setBounds(235, 311, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Serif", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 int id=Integer.valueOf(TFID.getText());
					 if(client.remClient(id))
						{
							JOptionPane.showMessageDialog(rootPane," Client Deleted","Deleted Client",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane,"Failed to delete Client ","Failed to Delete",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(rootPane,ex.getMessage()+"Enter Client ID","Failed to Delete",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnDelete.setBounds(124, 311, 89, 23);
		panel.add(btnDelete);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TFID.setText("");
				TFFN.setText("");
				TFLN.setText("");
				TFCN.setText("");
				TFE.setText("");
			}
		});
		btnReset.setFont(new Font("Serif", Font.BOLD, 13));
		btnReset.setBounds(124, 360, 89, 23);
		panel.add(btnReset);
		
		table = new JTable();
		table.setFont(new Font("Serif", Font.BOLD, 13));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int rIndex=table.getSelectedRow();
				TFID.setText(model.getValueAt(rIndex, 0).toString());
				TFFN.setText(model.getValueAt(rIndex, 1).toString());
				TFLN.setText(model.getValueAt(rIndex, 2).toString());
				TFCN.setText(model.getValueAt(rIndex, 3).toString());
				TFE.setText(model.getValueAt(rIndex, 4).toString());
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Phone", "Email"
			}
		)
			{
			public boolean isCellEditable(int row,int coloumn) {
			return false;
		}});
		table.setBounds(334, 85, 550, 330);
		panel.add(table);
		client.fillTable(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(new DefaultTableModel(null,new Object[] {"ID","First Name","Last Name","Phone","Email"}));
				client.fillTable(table);
			}
		});
		btnRefresh.setFont(new Font("Serif", Font.BOLD, 13));
		btnRefresh.setBounds(597, 427, 89, 23);
		panel.add(btnRefresh);
	}
}
