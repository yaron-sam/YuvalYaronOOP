package gui;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class P_algo2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtMac;
	private JTextField txtMac_1;
	private JTextField txtMac_2;
	private JTextField txtSignal;
	private JTextField txtSignal_1;
	private JTextField txtSignal_2;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblMac;
	private JLabel lblSignal;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnAddCombFile;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_algo2 frame = new P_algo2();
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
	public P_algo2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlgorithm = new JLabel("Find user loction");
		lblAlgorithm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgorithm.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblAlgorithm.setBounds(137, 11, 188, 35);
		contentPane.add(lblAlgorithm);

		textField = new JTextField();
		textField.setBounds(15, 107, 499, 26);
		contentPane.add(textField);
		textField.setColumns(10);


		txtMac = new JTextField();
		txtMac.setHorizontalAlignment(SwingConstants.CENTER);
		txtMac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtMac.setText("");

			}
		});
		txtMac.setText("MAC 1");
		txtMac.setBounds(37, 200, 146, 26);
		contentPane.add(txtMac);
		txtMac.setColumns(10);
		txtMac.setEnabled(false);
		txtMac.setEditable(false);
		JRadioButton jradio2 = new JRadioButton("Three Mac and Signal Input");
		jradio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jradio2.isSelected())
				{

					textField.setEnabled(false);
					txtMac.setEnabled(true);
					txtMac_1.setEnabled(true);
					txtMac_2.setEnabled(true);			
					txtSignal.setEnabled(true);
					txtSignal_1.setEnabled(true);
					txtSignal_2.setEnabled(true);

					textField.setEditable(false);
					txtMac.setEditable(true);
					txtMac_1.setEditable(true);
					txtMac_2.setEditable(true);
					txtSignal.setEditable(true);
					txtSignal_1.setEditable(true);
					txtSignal_2.setEditable(true);

					txtMac.setText("MAC 1");
					txtMac_1.setText("MAC 2");
					txtMac_2.setText("MAC 3");
					txtSignal.setText("Signal 1");
					txtSignal_1.setText("Signal 2");
					txtSignal_2.setText("Signal 3");




				}
			}
		});
		jradio2.setBounds(15, 145, 252, 29);
		contentPane.add(jradio2);

		jradio2.setActionCommand("enable");
		jradio2.setEnabled(true);


		JRadioButton jradio = new JRadioButton("String Line From \"nogps\" File Input");
		jradio.setSelected(true);
		jradio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jradio.isSelected())
				{

					textField.setEnabled(true);
					txtMac.setEnabled(false);
					txtMac_1.setEnabled(false);
					txtMac_2.setEnabled(false);

					txtSignal.setEnabled(false);
					txtSignal_1.setEnabled(false);
					txtSignal_2.setEnabled(false);

					textField.setEditable(true);
					txtMac.setEditable(false);
					txtMac_1.setEditable(false);
					txtMac_2.setEditable(false);
					txtSignal.setEditable(false);
					txtSignal_1.setEditable(false);
					txtSignal_2.setEditable(false);

					txtMac.setText("MAC 1");
					txtMac_1.setText("MAC 2");
					txtMac_2.setText("MAC 3");
					txtSignal.setText("Signal 1");
					txtSignal_1.setText("Signal 2");
					txtSignal_2.setText("Signal 3");

				}

			}
		});
		jradio.setBounds(15, 66, 293, 29);
		contentPane.add(jradio);

		jradio.setActionCommand("enable");
		jradio.setEnabled(true);

		ButtonGroup bt=new ButtonGroup();
		bt.add(jradio);
		bt.add(jradio2);




		txtMac_1 = new JTextField();
		txtMac_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMac_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtMac_1.setText("");
			}
		});
		txtMac_1.setText("MAC 2");
		txtMac_1.setColumns(10);
		txtMac_1.setBounds(37, 242, 146, 26);
		contentPane.add(txtMac_1);
		txtMac_1.setEnabled(false);
		txtMac_1.setVisible(true);
		txtMac_1.setEditable(false);
		txtMac_2 = new JTextField();
		txtMac_2.setHorizontalAlignment(SwingConstants.CENTER);

		txtMac_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtMac_2.setText("");
			}
		});
		txtMac_2.setText("MAC 3");
		txtMac_2.setColumns(10);
		txtMac_2.setBounds(37, 284, 146, 26);
		contentPane.add(txtMac_2);
		txtMac_2.setEnabled(false);
		txtMac_2.setVisible(true);
		txtMac_2.setEditable(false);
		txtSignal = new JTextField();
		txtSignal.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtSignal.setText("");
			}
		});
		txtSignal.setText("Signal 1");
		txtSignal.setColumns(10);
		txtSignal.setBounds(267, 200, 146, 26);
		contentPane.add(txtSignal);
		txtSignal.setEnabled(false);
		txtSignal.setVisible(true);
		txtSignal.setEditable(false);
		txtSignal_1 = new JTextField();
		txtSignal_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignal_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtSignal_1.setText("");
			}
		});
		txtSignal_1.setText("Signal 2");
		txtSignal_1.setColumns(10);
		txtSignal_1.setBounds(267, 242, 146, 26);
		contentPane.add(txtSignal_1);
		txtSignal_1.setEnabled(false);
		txtSignal_1.setVisible(true);
		txtSignal_1.setEditable(false);
		txtSignal_2 = new JTextField();
		txtSignal_2.setHorizontalAlignment(SwingConstants.CENTER);

		txtSignal_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtSignal_2.setText("");
			}
		});
		txtSignal_2.setText("Signal 3");
		txtSignal_2.setColumns(10);
		txtSignal_2.setBounds(267, 284, 146, 26);
		contentPane.add(txtSignal_2);
		txtSignal_2.setEnabled(false);
		txtSignal_2.setVisible(true);
		txtSignal_2.setEditable(false);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(191, 369, 134, 26);
		contentPane.add(textField_5);

		JLabel lblLat = new JLabel("Lat");
		lblLat.setBounds(66, 342, 69, 20);
		contentPane.add(lblLat);

		JLabel lblLon = new JLabel("Lon");
		lblLon.setBounds(240, 342, 69, 20);
		contentPane.add(lblLon);

		JLabel lblAlt = new JLabel("Alt");
		lblAlt.setBounds(409, 342, 69, 20);
		contentPane.add(lblAlt);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(15, 369, 134, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(359, 369, 134, 26);
		contentPane.add(textField_2);

		lblMac = new JLabel("MAC");
		lblMac.setBounds(77, 174, 69, 20);
		contentPane.add(lblMac);

		lblSignal = new JLabel("Signal");
		lblSignal.setBounds(311, 174, 69, 20);
		contentPane.add(lblSignal);

		btnNewButton = new JButton("Export result to CSV File");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//TODO add what to do
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(48, 544, 411, 29);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Add nogps File");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent args0) {

				//TODO add what to do

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}
		});


		btnNewButton_1.setBounds(78, 499, 170, 29);
		contentPane.add(btnNewButton_1);

		btnAddCombFile = new JButton("Add comb File");
		btnAddCombFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent args0) {
///TODO add what to do

			}
		});
		btnAddCombFile.setBounds(263, 499, 181, 29);
		contentPane.add(btnAddCombFile);

		btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jradio2.isSelected()) {
					String m1 = txtMac.getText();
					String m2 = txtMac_1.getText();
					String m3 = txtMac_2.getText();
					String s1 = txtSignal.getText();
					String s2 = txtSignal_1.getText();
					String s3 = txtSignal_2.getText();


					ArrayList<String> Allm_Alls = new ArrayList<String>();

					Allm_Alls.add(m1);
					Allm_Alls.add(s1);
					Allm_Alls.add(m2);
					Allm_Alls.add(s2);
					Allm_Alls.add(m3);
					Allm_Alls.add(s3);


					//TODO add what to do


				}

			}
		});

		btnSubmit.setBounds(164, 437, 197, 29);
		contentPane.add(btnSubmit);

	}

}
