import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.Date;

public class MakeReservations extends JFrame {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	

	private JPanel contentPane;
	private JTextField code;
	private JTextField no_child;
	private JTextField no_adult;
	private JTextField room_no;
	private JTextField c_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeReservations frame = new MakeReservations();
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
	public MakeReservations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMakeReservation = new JLabel("MAKE RESERVATION");
		lblMakeReservation.setForeground(Color.ORANGE);
		lblMakeReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblMakeReservation.setFont(new Font("Elephant", Font.PLAIN, 16));
		lblMakeReservation.setBounds(13, 11, 584, 34);
		contentPane.add(lblMakeReservation);
		
		JLabel lblCode = new JLabel("CODE");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCode.setForeground(Color.LIGHT_GRAY);
		lblCode.setBounds(128, 57, 110, 19);
		contentPane.add(lblCode);
		
		JLabel lblNoOfChild = new JLabel("NO OF CHILDREN");
		lblNoOfChild.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfChild.setForeground(Color.LIGHT_GRAY);
		lblNoOfChild.setBounds(128, 87, 110, 19);
		contentPane.add(lblNoOfChild);
		
		JLabel lblNoOfAdults = new JLabel("NO OF ADULTS");
		lblNoOfAdults.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfAdults.setForeground(Color.LIGHT_GRAY);
		lblNoOfAdults.setBounds(128, 117, 110, 19);
		contentPane.add(lblNoOfAdults);
		
		JLabel lblCheckindate = new JLabel("CHECK-IN-DATE");
		lblCheckindate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCheckindate.setForeground(Color.LIGHT_GRAY);
		lblCheckindate.setBounds(128, 147, 110, 19);
		contentPane.add(lblCheckindate);
		
		JLabel lblCheckoutdate = new JLabel("CHECK-OUT-DATE");
		lblCheckoutdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCheckoutdate.setForeground(Color.LIGHT_GRAY);
		lblCheckoutdate.setBounds(128, 178, 110, 19);
		contentPane.add(lblCheckoutdate);
		
		JLabel lblStatus = new JLabel("ROOM NO");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setForeground(Color.LIGHT_GRAY);
		lblStatus.setBounds(128, 209, 110, 19);
		contentPane.add(lblStatus);
		
		code = new JTextField();
		code.setBounds(271, 56, 190, 20);
		contentPane.add(code);
		code.setColumns(10);
		
		no_child = new JTextField();
		no_child.setColumns(10);
		no_child.setBounds(271, 86, 190, 20);
		contentPane.add(no_child);
		
		no_adult = new JTextField();
		no_adult.setColumns(10);
		no_adult.setBounds(271, 116, 190, 20);
		contentPane.add(no_adult);
		
		room_no = new JTextField();
		room_no.setColumns(10);
		room_no.setBounds(271, 208, 190, 20);
		contentPane.add(room_no);
		JDateChooser check_in_d = new JDateChooser();
		check_in_d.setDateFormatString("yyyy-MM-dd");
		check_in_d.setBounds(271, 147, 190, 19);
		contentPane.add(check_in_d);
		
		JDateChooser check_out_d = new JDateChooser();
		check_out_d.setDateFormatString("yyyy-MM-dd");
		check_out_d.setBounds(271, 178, 190, 20);
		contentPane.add(check_out_d);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sq1="INSERT INTO reservation_table"
							+"(code, child, adult, check_in, check_out,room_no,id)"
							+"VALUES (?,?,?,?,?,?,?)";
					con=Connections.getConnection();
					pst=con.prepareStatement(sq1);
					pst.setString(1,code.getText());
					pst.setString(2,no_child.getText());
					pst.setString(3,no_adult.getText());
					pst.setString(4,((JTextField)check_in_d.getDateEditor().getUiComponent()).getText());
					pst.setString(5,((JTextField)check_out_d.getDateEditor().getUiComponent()).getText());
					pst.setString(6,room_no.getText());
					pst.setString(7,c_id.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Reservation Made");
					
				}catch(Exception ex) {
					System.out.println(""+ex);
					JOptionPane.showMessageDialog(null, "Reservation Failed!\n Check The Room Available Rooms");
				}
			}
		});
		btnInsert.setBounds(128, 270, 103, 28);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate.setBounds(312, 270, 103, 28);
		contentPane.add(btnUpdate);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				    ReceptionistPage lp=new ReceptionistPage();
					lp.setVisible(true);
					setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Elephant", Font.PLAIN, 13));
		btnReturn.setBounds(218, 354, 121, 25);
		contentPane.add(btnReturn);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setBounds(128, 240, 110, 19);
		contentPane.add(lblId);
		
		c_id = new JTextField();
		c_id.setColumns(10);
		c_id.setBounds(271, 239, 190, 20);
		contentPane.add(c_id);
		

		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("C:\\Users\\Nand Kumar Singh\\Desktop\\SE\\app-background-design-8.jpg"));
		label.setBounds(0, 0, 607, 390);
		contentPane.add(label);
	}
}
