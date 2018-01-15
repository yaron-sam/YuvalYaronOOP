package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")

public class P_algo1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMac;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_algo1 frame = new P_algo1();
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
	public P_algo1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlgorithm = new JLabel("Algorithm 1");
		lblAlgorithm.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblAlgorithm.setForeground(Color.DARK_GRAY);
		lblAlgorithm.setBounds(238, 16, 117, 32);
		contentPane.add(lblAlgorithm);

		txtMac = new JTextField();
		txtMac.setHorizontalAlignment(SwingConstants.CENTER);
		txtMac.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		txtMac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				txtMac.setText("");
			}
		});
		txtMac.setText("enter MAC adress");
		txtMac.setBounds(193, 68, 196, 32);
		contentPane.add(txtMac);
		txtMac.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String mac = txtMac.getText();

					List<Double> p = GUI_Wrapper.algo1Short(mac);
					textField.setText(""+p.get(0));
					textField_1.setText(""+p.get(1));
					textField_2.setText(""+p.get(2));


			}
		});
		btnSubmit.setBounds(238, 116, 115, 29);
		contentPane.add(btnSubmit);

		JLabel lblAlt = new JLabel("Lat");

		lblAlt.setBounds(93, 161, 69, 20);
		contentPane.add(lblAlt);

		JLabel lblLon = new JLabel("Lon");
		lblLon.setBounds(273, 161, 69, 20);
		contentPane.add(lblLon);

		JLabel lblLat = new JLabel("Alt");
		lblLat.setBounds(420, 161, 69, 20);
		contentPane.add(lblLat);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setEditable(false);
		textField.setBounds(34, 189, 167, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(216, 189, 160, 46);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(391, 189, 160, 46);
		contentPane.add(textField_2);

		JButton btnNewButton = new JButton("Export Algorithm 1 (All Data) to CSV File");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					GUI_Wrapper.saveTOCSV("Algo1");
			}
		});
		btnNewButton.setBounds(93, 272, 396, 32);
		contentPane.add(btnNewButton);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.DARK_GRAY);
		editorPane.setBounds(216, 48, 151, 4);
		contentPane.add(editorPane);
	}

}
