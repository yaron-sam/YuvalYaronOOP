package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Filters.And;
import Filters.Condition;
import Filters.Not;
import Filters.Or;
import Filters.Time;
import Filters.findGroupId;
import Filters.findLoction;
import ex0.wifiList;

import javax.swing.JCheckBox;



@SuppressWarnings("serial")
public class P_filter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtBeginingTime;
	private JTextField txtEndedTime;
	private Condition<wifiList> idfilter;
	private Condition<wifiList> timefilter;
	private Condition<wifiList> posfilter;

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
		setBounds(100, 100, 768, 375);
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
		TimeRadioButton.setBounds(293, 54, 155, 29);
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
		rdbtnPosition.setBounds(586, 54, 155, 29);
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
		textField_3.setBounds(566, 120, 166, 26);
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
		textField_4.setBounds(566, 186, 166, 26);
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
		textField_5.setBounds(566, 250, 166, 26);
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

		if (rdbtnId.isSelected()) {

			String id = textField.getText();

			if (id.equalsIgnoreCase("Name Of Device") || id.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Invalid ID Input", "Message",
						JOptionPane.INFORMATION_MESSAGE);

			} else {

				idfilter = GUI_Wrapper.idFilter(id);
			}
		}
		
		if(TimeRadioButton.isSelected()){
			String start = txtBeginingTime.getText();
			String end = txtEndedTime.getText();
			timefilter =  GUI_Wrapper.timeFilter(start, end);
					
			}
		


		if (rdbtnPosition.isSelected()) {
			String lat = textField_3.getText();
			String lon = textField_4.getText();
			String radius = textField_5.getText();

			if (lat.equalsIgnoreCase("Lat") || lat.equalsIgnoreCase("") || lon.equalsIgnoreCase("Lon")
					|| lon.equalsIgnoreCase("") || radius.equalsIgnoreCase("Radius") || radius.equalsIgnoreCase("")) {

				JOptionPane.showMessageDialog(null, "Invalid Position Input", "Message",
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				posfilter = GUI_Wrapper.positionFilter(Double.parseDouble(lat), Double.parseDouble(lon),
						Double.parseDouble(radius));
			}

		}
		
		JButton btnNewButton_1 = new JButton("Save To KML File");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!rdbtnOnoff.isSelected()) {
					if(idfilter != null && timefilter == null && posfilter == null)
						GUI_Wrapper.Filters(idfilter);
					else if(idfilter == null && timefilter != null && posfilter == null)
						GUI_Wrapper.Filters(timefilter);
					else if(idfilter != null && timefilter == null && posfilter != null)
						GUI_Wrapper.Filters(posfilter);
					else
						try {
							throw new IOException("erorr - only one can pick");
						} catch (IOException e1) {
							e1.printStackTrace();
						}  
				}

				if(rdbtnOnoff.isSelected()) {
					if(ANDButton.isSelected() || ORButton.isSelected()) {
						if(idfilter != null && timefilter != null && posfilter == null) {
							if(ANDButton.isSelected()) {
								GUI_Wrapper.Filters(new And(idfilter, timefilter));
							}else {
								GUI_Wrapper.Filters(new Or(idfilter, timefilter));
							}
						}
						
						if(idfilter != null && timefilter == null && posfilter != null) {
							if(ANDButton.isSelected()) {
								GUI_Wrapper.Filters(new And(idfilter, posfilter));
							}else {
								GUI_Wrapper.Filters(new Or(idfilter, posfilter));
							}
						}
						
						if(idfilter == null && timefilter != null && posfilter != null) {
							if(ANDButton.isSelected()) {
								GUI_Wrapper.Filters(new And(posfilter, timefilter));
							}else {
								GUI_Wrapper.Filters(new Or(posfilter, timefilter));
							}
						}

					}


					else if(NOTbutton.isSelected()) {
						if(idfilter != null && timefilter == null && posfilter == null)
							GUI_Wrapper.Filters(new Not(idfilter));
						else if(idfilter == null && timefilter != null && posfilter == null)
							GUI_Wrapper.Filters(new Not(timefilter));
						else if(idfilter != null && timefilter == null && posfilter != null)
							GUI_Wrapper.Filters(new Not(posfilter));
					}
				}
				try {
					GUI_Wrapper.saveTOKML("filter");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(310, 282, 176, 25);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Begin");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(234, 99, 97, 20);
		contentPane.add(lblNewLabel);

		JLabel lblEnd = new JLabel("End");
		lblEnd.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		lblEnd.setBounds(234, 139, 97, 20);
		contentPane.add(lblEnd);
		
		txtBeginingTime = new JTextField();
		txtBeginingTime.setEditable(false);
		txtBeginingTime.setEnabled(false);
		txtBeginingTime.setText("begining time");
		txtBeginingTime.setBounds(310, 103, 138, 20);
		contentPane.add(txtBeginingTime);
		txtBeginingTime.setColumns(10);
		
		txtEndedTime = new JTextField();
		txtEndedTime.setEditable(false);
		txtEndedTime.setEnabled(false);
		txtEndedTime.setText("ended time");
		txtEndedTime.setColumns(10);
		txtEndedTime.setBounds(310, 143, 138, 20);
		contentPane.add(txtEndedTime);
		



	}
}
