import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffPage extends JFrame {

	private JPanel contentPane;
	private JTextField e_name;
	private JTextField e_address;
	private JTextField e_age;
	private JTextField textField_3;
	private JTextField e_occupation;
	private JTextField e_mail;
	private JTextField e_contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffPage frame = new StaffPage();
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
	public StaffPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffMembers = new JLabel("STAFF MEMBERS");
		lblStaffMembers.setForeground(Color.ORANGE);
		lblStaffMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffMembers.setFont(new Font("Elephant", Font.PLAIN, 16));
		lblStaffMembers.setBounds(10, 0, 584, 34);
		contentPane.add(lblStaffMembers);
		
		JLabel lblEmployeeName = new JLabel("EMPLOYEE NAME");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeName.setForeground(Color.LIGHT_GRAY);
		lblEmployeeName.setBounds(107, 45, 130, 19);
		contentPane.add(lblEmployeeName);
		
		JLabel lblEmployeeAddress = new JLabel("EMPLOYEE ADDRESS");
		lblEmployeeAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeAddress.setForeground(Color.LIGHT_GRAY);
		lblEmployeeAddress.setBounds(107, 75, 130, 19);
		contentPane.add(lblEmployeeAddress);
		
		JLabel lblEmployeeAge = new JLabel("EMPLOYEE AGE");
		lblEmployeeAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeAge.setForeground(Color.LIGHT_GRAY);
		lblEmployeeAge.setBounds(107, 105, 130, 19);
		contentPane.add(lblEmployeeAge);
		
		JLabel lblEmployeeSalary = new JLabel("EMPLOYEE SALARY");
		lblEmployeeSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeSalary.setForeground(Color.LIGHT_GRAY);
		lblEmployeeSalary.setBounds(107, 135, 130, 19);
		contentPane.add(lblEmployeeSalary);
		
		JLabel lblEmployee = new JLabel("EMPLOYEE OCCUPATION");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployee.setForeground(Color.LIGHT_GRAY);
		lblEmployee.setBounds(107, 165, 157, 19);
		contentPane.add(lblEmployee);
		
		JLabel lblEmployeeEmail = new JLabel("EMPLOYEE E-MAIL");
		lblEmployeeEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeEmail.setForeground(Color.LIGHT_GRAY);
		lblEmployeeEmail.setBounds(107, 195, 130, 19);
		contentPane.add(lblEmployeeEmail);
		
		JLabel lblEmployeeContactNo = new JLabel("EMPLOYEE CONTACT NO");
		lblEmployeeContactNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeContactNo.setForeground(Color.LIGHT_GRAY);
		lblEmployeeContactNo.setBounds(107, 225, 130, 19);
		contentPane.add(lblEmployeeContactNo);
		
		JButton button = new JButton("INSERT");
		button.setBounds(161, 265, 103, 28);
		contentPane.add(button);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.setBounds(342, 265, 103, 28);
		contentPane.add(button_1);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    ManagerPage lp=new ManagerPage();
				lp.setVisible(true);
				setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Elephant", Font.PLAIN, 13));
		btnReturn.setBounds(242, 316, 121, 25);
		contentPane.add(btnReturn);
		
		e_name = new JTextField();
		e_name.setColumns(10);
		e_name.setBounds(306, 45, 190, 20);
		contentPane.add(e_name);
		
		e_address = new JTextField();
		e_address.setColumns(10);
		e_address.setBounds(306, 75, 190, 20);
		contentPane.add(e_address);
		
		e_age = new JTextField();
		e_age.setColumns(10);
		e_age.setBounds(306, 105, 190, 20);
		contentPane.add(e_age);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(306, 135, 190, 20);
		contentPane.add(textField_3);
		
		e_occupation = new JTextField();
		e_occupation.setColumns(10);
		e_occupation.setBounds(306, 166, 190, 20);
		contentPane.add(e_occupation);
		
		e_mail = new JTextField();
		e_mail.setColumns(10);
		e_mail.setBounds(306, 196, 190, 20);
		contentPane.add(e_mail);
		
		e_contact = new JTextField();
		e_contact.setColumns(10);
		e_contact.setBounds(306, 226, 190, 20);
		contentPane.add(e_contact);
		
		JLabel label = new JLabel("  ");
		label.setIcon(new ImageIcon("C:\\Users\\Nand Kumar Singh\\Desktop\\SE\\app-background-design-8.jpg"));
		label.setBounds(0, 0, 606, 381);
		contentPane.add(label);
	}

}
