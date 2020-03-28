package HotelManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final Action action = new SwingAction();

	
	public MainPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 490);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MManage = new JMenu("Manage>");
		MManage.setFont(new Font("Serif", Font.PLAIN, 15));
		menuBar.add(MManage);
		
		JMenuItem MIClient = new JMenuItem("Clients");
		MIClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientPanel cp=new ClientPanel();
				cp.setVisible(true);
				//cp.pack();
				cp.setLocationRelativeTo(null);
				cp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//cp.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
		});
		MIClient.setFont(new Font("Serif", Font.PLAIN, 14));
		MManage.add(MIClient);
		
		JSeparator separator = new JSeparator();
		MManage.add(separator);
		
		JMenuItem MIRooms = new JMenuItem("Rooms");
		MIRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			RoomPanel rp=new RoomPanel();
			rp.setVisible(true);
			//rp.pack();
			rp.setLocationRelativeTo(null);
			rp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//rp.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		MIRooms.setFont(new Font("Serif", Font.PLAIN, 14));
		MManage.add(MIRooms);
		
		JSeparator separator_1 = new JSeparator();
		MManage.add(separator_1);
		
		JMenuItem mntmReservations = new JMenuItem("Reservations");
		mntmReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReservationPanel rv=new ReservationPanel();
				rv.setVisible(true);
				//rv.pack();
				rv.setLocationRelativeTo(null);
				rv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mntmReservations.setFont(new Font("Serif", Font.PLAIN, 14));
		MManage.add(mntmReservations);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 882, 451);
		contentPane.add(panel);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
