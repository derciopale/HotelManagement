import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.*;
import java.util.*;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Color;

public class AdminPage extends JFrame {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField uname;
	private JTextField options;
	private JPasswordField apswd;
	private JTable table;

	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public AdminPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("ADMIN PANEL");
		lblAdminPanel.setForeground(Color.ORANGE);
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setFont(new Font("Elephant", Font.PLAIN, 16));
		lblAdminPanel.setBounds(10, 11, 750, 34);
		contentPane.add(lblAdminPanel);
		

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage lp=new LoginPage();
				lp.setVisible(true);
				setVisible(false);
				
			}
		});
		btnLogout.setFont(new Font("Elephant", Font.PLAIN, 13));
		btnLogout.setBounds(270, 348, 121, 25);
		contentPane.add(btnLogout);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(20, 56, 128, 25);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setBounds(20, 107, 128, 25);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setBounds(20, 164, 128, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBounds(20, 218, 128, 25);
		contentPane.add(lblPassword);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesignation.setForeground(Color.LIGHT_GRAY);
		lblDesignation.setBounds(20, 271, 128, 25);
		contentPane.add(lblDesignation);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sq1="INSERT INTO login_table"
							+"(firstname, lastname, username, password, options)"
							+"VALUES (?,?,?,?,?)";
					con=Connections.getConnection();
					pst=con.prepareStatement(sq1);
					pst.setString(1,fname.getText());
					pst.setString(2,lname.getText());
					pst.setString(3,uname.getText());
					pst.setString(4,apswd.getText());
					pst.setString(5,options.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "USER INSERTED");
					
				}catch(Exception ex) {
					System.out.println(""+ex);
				}
				
			}
		});
		btnInsert.setBounds(30, 314, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sq1="UPDATE login_table SET firstname=?,lastname=?,password=?,options=? WHERE username=?";
					con=Connections.getConnection();
					pst=con.prepareStatement(sq1);
					pst.setString(1,fname.getText());
					pst.setString(2,lname.getText());
					pst.setString(3,apswd.getText());
					pst.setString(4,options.getText());
					pst.setString(5,uname.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "USER UPDATE");
					
				}catch(Exception ex) {
					System.out.println(""+ex);
				}
			}
		});
		btnUpdate.setBounds(189, 314, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sq1="DELETE FROM login_table where username=? ";
					con=Connections.getConnection();
					pst=con.prepareStatement(sq1);
					pst.setString(1,uname.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "USER Deleted");
					
				}catch(Exception ex) {
					System.out.println(""+ex);
				}
			}
		});
		btnDelete.setBounds(349, 314, 89, 23);
		contentPane.add(btnDelete);
		
		fname = new JTextField();
		fname.setBounds(109, 58, 133, 23);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(109, 109, 133, 23);
		contentPane.add(lname);
		
		uname = new JTextField();
		uname.setColumns(10);
		uname.setBounds(109, 166, 133, 23);
		contentPane.add(uname);
		
		options = new JTextField();
		options.setColumns(10);
		options.setBounds(109, 273, 133, 23);
		contentPane.add(options);
		
		JButton btnNew = new JButton("Refresh");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con=Connections.getConnection();
				try {
					String sq3="SELECT * FROM login_table";
					pst=con.prepareStatement(sq3);
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception ex)
				{
					System.out.println(""+ex);
				}
				
			}
		});
		btnNew.setBounds(488, 314, 89, 23);
		contentPane.add(btnNew);
		
		apswd = new JPasswordField();
		apswd.setBounds(109, 220, 133, 20);
		contentPane.add(apswd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 61, 490, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblToDeleteUse = new JLabel("*To Delete USERNAME is mandatory");
		lblToDeleteUse.setForeground(Color.LIGHT_GRAY);
		lblToDeleteUse.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblToDeleteUse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblToDeleteUse.setBounds(585, 340, 175, 20);
		contentPane.add(lblToDeleteUse);
		
		JLabel lblUseRefresh = new JLabel("** Use refresh button to view changes");
		lblUseRefresh.setForeground(Color.LIGHT_GRAY);
		lblUseRefresh.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblUseRefresh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUseRefresh.setBounds(573, 359, 187, 20);
		contentPane.add(lblUseRefresh);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("C:\\Users\\Nand Kumar Singh\\Desktop\\SE\\app-background-design-8.jpg"));
		label.setBounds(0, 0, 770, 390);
		contentPane.add(label);
		
	}
}

