import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoginPage extends JFrame {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	private JPanel contentPane;
	private JTextField UName;
	private JPasswordField password;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

        
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 538, 33);
		contentPane.add(lblNewLabel);
		
		JLabel UsernameLable = new JLabel("Username");
		UsernameLable.setForeground(Color.BLACK);
		UsernameLable.setFont(new Font("Elephant", Font.PLAIN, 15));
		UsernameLable.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLable.setBounds(190, 77, 176, 26);
		contentPane.add(UsernameLable);
		
		UName = new JTextField();
		UName.setFont(new Font("Elephant", Font.PLAIN, 13));
		UName.setBounds(190, 114, 176, 20);
		contentPane.add(UName);
		UName.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Elephant", Font.PLAIN, 13));
		password.setBounds(190, 182, 176, 20);
		contentPane.add(password);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Elephant", Font.PLAIN, 15));
		lblPassword.setBounds(190, 145, 176, 26);
		contentPane.add(lblPassword);
		
		JLabel lblSelectUser = new JLabel("Select User");
		lblSelectUser.setForeground(Color.BLACK);
		lblSelectUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectUser.setFont(new Font("Elephant", Font.PLAIN, 15));
		lblSelectUser.setBounds(190, 213, 176, 26);
		contentPane.add(lblSelectUser);
		
		JComboBox Options = new JComboBox();
		Options.setForeground(Color.BLACK);
		Options.setFont(new Font("Elephant", Font.PLAIN, 14));
		Options.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Manager", "Receptionist"}));
		Options.setBounds(200, 250, 166, 20);
		contentPane.add(Options);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=UName.getText();
				String pswd=password.getText();
				String option=Options.getSelectedItem().toString();
				if(uname.equals("")||pswd.equals("")||option.equals("Select")) {
					JOptionPane.showMessageDialog(rootPane, "Some Fields are Empty", "Error", 1);
				}
				else {
					try {
						con=Connections.getConnection();
						pst=con.prepareStatement("select * from login_table where username=? and password=?");
						pst.setString(1, uname);
						pst.setString(2, pswd);
						rs=pst.executeQuery();
						
						if(rs.next()) {
							String s1=rs.getString("options");
							String un=rs.getString("username");
							if(option.equalsIgnoreCase("Admin")&&s1.equalsIgnoreCase("admin")){
								AdminPage ad= new AdminPage();
								ad.setVisible(true);
								setVisible(false);}
							
							else if(option.equalsIgnoreCase("Manager")&&s1.equalsIgnoreCase("manager")){
								ManagerPage mr= new ManagerPage();
								mr.setVisible(true);
								setVisible(false);}
						    
							else if(option.equalsIgnoreCase("Receptionist")&&s1.equalsIgnoreCase("receptionist")){
								ReceptionistPage rp= new ReceptionistPage();
								rp.setVisible(true);
								setVisible(false);}
							else {
								JOptionPane.showMessageDialog(rootPane, "Username or Password Invalid", "Error", 1);
						}
						
						}
						
					
					}
						catch(Exception ex){
							System.out.println(""+ex);
							JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					}
				}
			}
		});
		btnLogin.setFont(new Font("Elephant", Font.PLAIN, 15));
		btnLogin.setBounds(230, 291, 116, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Elephant", Font.PLAIN, 15));
		btnCancel.setBounds(230, 333, 116, 23);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel(" ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon("F:\\JAVA\\icons\\man-user.png"));
		label.setBounds(135, 109, 46, 18);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel(" ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setIcon(new ImageIcon("F:\\JAVA\\icons\\padlock.png"));
		label_2.setBounds(135, 181, 46, 18);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setBackground(Color.WHITE);
		label_1.setForeground(Color.WHITE);
		label_1.setIcon(new ImageIcon("F:\\JAVA\\icons\\users-meeting-people.png"));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(135, 239, 46, 18);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Nand Kumar Singh\\Desktop\\SE\\app-background-design-8.jpg"));
		label_3.setBounds(0, 0, 558, 387);
		contentPane.add(label_3);
		}
}
