import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BillPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillPage frame = new BillPage();
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
	public BillPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.setFont(new Font("Elephant", Font.PLAIN, 13));
		btnReturn.setBounds(235, 345, 121, 25);
		contentPane.add(btnReturn);
		
		JButton btnPritnt = new JButton("PRINT");
		btnPritnt.setIcon(new ImageIcon("F:\\JAVA\\icons\\icons8-print-26.png"));
		btnPritnt.setBounds(476, 11, 121, 35);
		contentPane.add(btnPritnt);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("F:\\JAVA\\icons\\blue-background-023.jpg"));
		label.setBounds(0, 0, 607, 381);
		contentPane.add(label);
	}
}
