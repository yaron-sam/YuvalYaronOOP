package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Filters.And;
import Filters.Condition;
import Filters.Not;
import Filters.Or;
import Filters.util;
import wifiData.wifiList;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;



@SuppressWarnings("serial")
public class P_filter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtBeginingTime;
	private JTextField txtEndedTime;
	private Condition<wifiList> idfilter=null;
	private Condition<wifiList> timefilter=null;
	private Condition<wifiList> posfilter=null;
	private Condition<wifiList> finalFilter=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_filter frame = new P_filter();
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
	public P_filter() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 861, 375);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton ORButton = new JRadioButton("OR");
		ORButton.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		ORButton.setActionCommand("enable");
		ORButton.setEnabled(false);

		ORButton.setBounds(236, 250, 83, 29);
		contentPane.add(ORButton);


		JRadioButton ANDButton = new JRadioButton("AND");
		ANDButton.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		ANDButton.setBounds(135, 250, 83, 29);
		contentPane.add(ANDButton);
		ANDButton.setEnabled(false);

		JRadioButton NOTbutton = new JRadioButton("NOT");
		NOTbutton.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		NOTbutton.setBounds(36, 250, 97, 29);
		contentPane.add(NOTbutton);
		NOTbutton.setEnabled(false);
		NOTbutton.setSelected(true);

		ButtonGroup bt1=new ButtonGroup();
		bt1.add(ORButton);
		bt1.add(ANDButton);
		bt1.add(NOTbutton);



		textField = new JTextField();
		textField.setEnabled(false);
		textField.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");

			}
		});
		textField.setBounds(29, 97, 146, 26);
		contentPane.add(textField);
		textField.setText("Name Of Device");
		textField.setColumns(10);



		JCheckBox TimeRadioButton = new JCheckBox("Time");
		TimeRadioButton.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		TimeRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(TimeRadioButton.isSelected()) {
					txtBeginingTime.setEnabled(true);
					txtBeginingTime.setEditable(true);
					txtEndedTime.setEnabled(true);
					txtEndedTime.setEditable(true);
						
				}

				else if(!TimeRadioButton.isSelected()) {
					txtBeginingTime.setEnabled(false);
					txtBeginingTime.setEditable(false);
					txtEndedTime.setEnabled(false);
					txtEndedTime.setEditable(false);
				}

			}
		});
		TimeRadioButton.setBounds(256, 54, 155, 29);
		contentPane.add(TimeRadioButton);

		
		JCheckBox rdbtnId = new JCheckBox("ID");
		rdbtnId.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				if(rdbtnId.isSelected()) {

					textField.setEnabled(true);
					textField.setVisible(true);
					textField.setEditable(true);
					textField.setText("Name Of Device");


				}

				else if(!rdbtnId.isSelected()) {

					textField.setEnabled(false);
					textField.setVisible(true);
					textField.setEditable(false);
					textField.setText("Name Of Device");

				}

			}
		});
		rdbtnId.setBounds(36, 54, 155, 29);
		contentPane.add(rdbtnId);



		JCheckBox rdbtnPosition = new JCheckBox("Position");
		rdbtnPosition.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(rdbtnPosition.isSelected()) {

					textField_3.setEnabled(true);
					textField_3.setVisible(true);
					textField_3.setEditable(true);
					textField_3.setText("Lat");
					textField_4.setEnabled(true);
					textField_4.setVisible(true);
					textField_4.setEditable(true);
					textField_4.setText("Lon");
					textField_5.setEnabled(true);
					textField_5.setVisible(true);
					textField_5.setEditable(true);
					textField_5.setText("Radius");
					
				}

				else if(!rdbtnPosition.isSelected()) {

					textField_3.setEnabled(false);
					textField_3.setVisible(true);
					textField_3.setEditable(false);
					textField_3.setText("Lat");
					textField_4.setEnabled(false);
					textField_4.setVisible(true);
					textField_4.setEditable(false);
					textField_4.setText("Lon");
					textField_5.setEnabled(false);
					textField_5.setVisible(true);
					textField_5.setEditable(false);
					textField_5.setText("Radius");


				}


			}
		});
		rdbtnPosition.setBounds(452, 54, 103, 29);
		contentPane.add(rdbtnPosition);


		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setText("");
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(432, 120, 166, 26);
		contentPane.add(textField_3);
		textField_3.setText("Lat");


		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_4.setText("");
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(432, 186, 166, 26);
		contentPane.add(textField_4);
		textField_4.setText("Lon");


		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		textField_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_5.setText("");
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(432, 250, 166, 26);
		contentPane.add(textField_5);
		textField_5.setText("Radius");

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblFilters.setBounds(341, 16, 145, 20);
		contentPane.add(lblFilters);

		JCheckBox rdbtnOnoff = new JCheckBox("Logic Options (ON/OFF)");
		rdbtnOnoff.setSelected(false);
		rdbtnOnoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbtnOnoff.isSelected())
				{

					ORButton.setEnabled(true);
					ANDButton.setEnabled(true);
					NOTbutton.setEnabled(true);
				}
				else
				{
					ORButton.setEnabled(false);
					ANDButton.setEnabled(false);
					NOTbutton.setEnabled(false);
				}
			}
		});
		rdbtnOnoff.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnOnoff.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnOnoff.setBounds(18, 218, 261, 25);
		contentPane.add(rdbtnOnoff);

		
		JButton btnSave = new JButton("Save To KML File");
		btnSave.setEnabled(false);

		btnSave.setToolTipText("save to kml file");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				GUI_Wrapper.Filters(finalFilter);

				try {
					GUI_Wrapper.saveTOKML(GUI_Wrapper.KMLType.Filter);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(671, 16, 138, 58);
		contentPane.add(btnSave);

		JLabel lblNewLabel = new JLabel("Begin");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(197, 99, 97, 20);
		contentPane.add(lblNewLabel);

		JLabel lblEnd = new JLabel("End");
		lblEnd.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		lblEnd.setBounds(197, 139, 97, 20);
		contentPane.add(lblEnd);
		
		txtBeginingTime = new JTextField();
		txtBeginingTime.setEditable(false);
		txtBeginingTime.setEnabled(false);
		txtBeginingTime.setText("begining time");
		txtBeginingTime.setBounds(273, 103, 138, 20);
		contentPane.add(txtBeginingTime);
		txtBeginingTime.setColumns(10);
		
		txtEndedTime = new JTextField();
		txtEndedTime.setEditable(false);
		txtEndedTime.setEnabled(false);
		txtEndedTime.setText("ended time");
		txtEndedTime.setColumns(10);
		txtEndedTime.setBounds(273, 143, 138, 20);
		contentPane.add(txtEndedTime);
		
		JTextPane txtpnDisply = new JTextPane();
		txtpnDisply.setText("filter...");
		txtpnDisply.setBounds(44, 305, 357, 20);
		contentPane.add(txtpnDisply);
		
		JButton btnupload = new JButton("Upload filter");
		btnupload.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnId.isSelected()) {

					String id = textField.getText();

					if (id.equalsIgnoreCase("Name Of Device") || id.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Invalid ID Input", "Message",
								JOptionPane.INFORMATION_MESSAGE);

					} else {

						idfilter = GUI_Wrapper.idFilter(id);
					}
				}

				if (TimeRadioButton.isSelected()) {
					String start = txtBeginingTime.getText();
					String end = txtEndedTime.getText();
					timefilter = GUI_Wrapper.timeFilter(start, end);

				}

				if (rdbtnPosition.isSelected()) {
					String lat = textField_3.getText();
					String lon = textField_4.getText();
					String radius = textField_5.getText();

					if (lat.equalsIgnoreCase("Lat") || lat.equalsIgnoreCase("") || lon.equalsIgnoreCase("Lon")
							|| lon.equalsIgnoreCase("") || radius.equalsIgnoreCase("Radius")
							|| radius.equalsIgnoreCase("")) {

						JOptionPane.showMessageDialog(null, "Invalid Position Input", "Message",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						posfilter = GUI_Wrapper.positionFilter(Double.parseDouble(lat), Double.parseDouble(lon),
								Double.parseDouble(radius));
					}

				}
				
				
				if (!rdbtnOnoff.isSelected()) {
					if (idfilter != null && timefilter == null && posfilter == null)
						finalFilter = idfilter;
					else if (idfilter == null && timefilter != null && posfilter == null)
						finalFilter = timefilter;
					else if (idfilter == null && timefilter == null && posfilter != null)
						finalFilter = posfilter;
					else
						try {
							throw new IOException("erorr - only one can pick");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						

				}

				if (rdbtnOnoff.isSelected()) {
					if (ANDButton.isSelected() || ORButton.isSelected()) {
						if (idfilter != null && timefilter != null && posfilter == null) {
							if (ANDButton.isSelected()) {
								finalFilter = (new And<wifiList>(idfilter, timefilter));
							} else {
								finalFilter = (new Or<wifiList>(idfilter, timefilter));
							}
						}

						if (idfilter != null && timefilter == null && posfilter != null) {
							if (ANDButton.isSelected()) {
								finalFilter = (new And<wifiList>(idfilter, posfilter));
							} else {
								finalFilter = (new Or<wifiList>(idfilter, posfilter));
							}
						}

						if (idfilter == null && timefilter != null && posfilter != null) {
							if (ANDButton.isSelected()) {
								finalFilter = (new And<wifiList>(posfilter, timefilter));
							} else {
								finalFilter = (new Or<wifiList>(posfilter, timefilter));
							}
						}

					}

					else if (NOTbutton.isSelected()) {
						if (idfilter != null && timefilter == null && posfilter == null)
							finalFilter = (new Not<wifiList>(idfilter));
						else if (idfilter == null && timefilter != null && posfilter == null)
							finalFilter = (new Not<wifiList>(timefilter));
						else if (idfilter != null && timefilter == null && posfilter != null)
							finalFilter = (new Not<wifiList>(posfilter));
					}
				}
				
				idfilter = timefilter = posfilter = null;
				txtpnDisply.setText(finalFilter.toString());
				btnSave.setEnabled(true);


			}
		});
		btnupload.setBounds(671, 84, 138, 58);
		contentPane.add(btnupload);
		
		JButton btnImportFilter = new JButton("Import filter");
		btnImportFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalFilter = GUI_Wrapper.importCondition();
				txtpnDisply.setText(finalFilter.toString());
				btnSave.setEnabled(true);

			}
		});
		btnImportFilter.setBounds(671, 153, 138, 58);
		contentPane.add(btnImportFilter);
		
		JButton btnExportFilter = new JButton("Export filter");
		btnExportFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Wrapper.exportCondition(finalFilter);
			}
		});
		btnExportFilter.setBounds(671, 223, 138, 58);
		contentPane.add(btnExportFilter);
		



	}
}
