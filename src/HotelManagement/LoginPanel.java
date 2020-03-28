package HotelManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPanel extends JFrame {

	private JPanel contentPane;
	private JTextField TFUser;
	private JPasswordField PFPass;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel frame = new LoginPanel();
					frame.setLocationRelativeTo(null);

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
	public LoginPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 534, 311);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		
		JLabel lblUser = new JLabel("UserName");
		lblUser.setFont(new Font("Serif", Font.BOLD, 21));
		lblUser.setForeground(new Color(245, 245, 245));
		
		TFUser = new JTextField();
		TFUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(new Color(245, 245, 245));
		lblPass.setFont(new Font("Serif", Font.BOLD, 21));
		
		PFPass = new JPasswordField();
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Serif", Font.BOLD, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps;
				ResultSet rs;
				String username=TFUser.getText();
				String password=String.valueOf(PFPass.getPassword());
				
				if(username.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Enter Your UserName","Empty UserName",2);
				}
				else if(password.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Enter Your Passowrd","Empty Password",2);
				}
				else
				{
					Connections mycon=new Connections();
					String selectQuery="SELECT * FROM `users` WHERE `username`=? AND `password`=?";
					try {
						ps=mycon.createConnection().prepareStatement(selectQuery);
						ps.setString(1, username);
						ps.setString(2, password);
						rs=ps.executeQuery();
					if(rs.next())
					{	LoginPanel lp=new LoginPanel();
						MainPanel mp=new MainPanel();
						mp.setVisible(true);
						mp.setLocationRelativeTo(null);
						lp.dispose();
					}
					else 
					{
						JOptionPane.showMessageDialog(rootPane, "Invalid UserName or Password","Login Error",2);

					}
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(123)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(PFPass))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblUser)
							.addGap(18)
							.addComponent(TFUser, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(148, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(194)
					.addComponent(btnLogin)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUser)
						.addComponent(TFUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(PFPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		
		JLabel lblLoginPanel = new JLabel("LOGIN PANEL");
		lblLoginPanel.setForeground(new Color(245, 245, 245));
		lblLoginPanel.setFont(new Font("Shonar Bangla", Font.BOLD, 60));
		panel_1.add(lblLoginPanel);
		panel.setLayout(gl_panel);
	}
}
