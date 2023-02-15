package GUI;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSys.TrainingSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class CreateUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField height;
	private JTextField weight;
	private JTextField sex;
	private JTextField age;
	private JTextField goal;
	private JLabel lblNewLabel_7;
	private JTextField experience;
	private final ButtonGroup userType = new ButtonGroup();
	private JRadioButton traineeRBB;
	private JRadioButton coachRBB;
	private JLabel updates;
	private JPasswordField password;
	private int coachId = 0;
	private JLabel lblNewLabel_8;
	private JTextField id;
	private JTextArea coachInfo;
	private JLabel lblNewLabel_9;
	private JComboBox comboBox;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateUserFrame frame = new CreateUserFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CreateUserFrame(LoginFrame l) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		coachInfo = new JTextArea();
		coachInfo.setBounds(280, 120, 184, 99);
		contentPane.add(coachInfo);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coachInfo.setText(TrainingSys.searchCoach(Integer.parseInt((String) comboBox.getSelectedItem())).toString());
			}
		});
		comboBox.setBounds(329, 93, 78, 21);
		comboBox.setModel(new DefaultComboBoxModel<String>(TrainingSys.getCoachIdSortedById()));
		contentPane.add(comboBox);
		
		traineeRBB = new JRadioButton("Trainee");
		traineeRBB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goal.setEditable(true);
				experience.setEditable(false);
			}
		});
		traineeRBB.setSelected(true);
		userType.add(traineeRBB);
		traineeRBB.setBounds(24, 16, 103, 21);
		contentPane.add(traineeRBB);
		
		coachRBB = new JRadioButton("Coach");
		coachRBB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goal.setEditable(false);
				experience.setEditable(true);
				comboBox.setEditable(true);
			}
		});
		userType.add(coachRBB);
		coachRBB.setBounds(129, 16, 103, 21);
		contentPane.add(coachRBB);
		

		lblNewLabel_8 = new JLabel("ID:");
		lblNewLabel_8.setBounds(10, 75, 78, 13);
		contentPane.add(lblNewLabel_8);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(147, 69, 96, 19);
		contentPane.add(id);
		
		userName = new JTextField();
		userName.setBounds(147, 40, 96, 19);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User name:");
		lblNewLabel.setBounds(10, 46, 78, 13);
		contentPane.add(lblNewLabel);
		
		password = new JPasswordField();
		password.setBounds(147, 95, 96, 16);
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setBounds(10, 101, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		height = new JTextField();
		height.setColumns(10);
		height.setBounds(148, 117, 96, 19);
		contentPane.add(height);
		
		JLabel lblNewLabel_2 = new JLabel("Height: ");
		lblNewLabel_2.setBounds(11, 123, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		weight = new JTextField();
		weight.setColumns(10);
		weight.setBounds(148, 147, 96, 19);
		contentPane.add(weight);
		
		JLabel lblNewLabel_3 = new JLabel("Weight: ");
		lblNewLabel_3.setBounds(11, 153, 77, 13);
		contentPane.add(lblNewLabel_3);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(148, 177, 96, 19);
		contentPane.add(sex);
		
		JLabel lblNewLabel_4 = new JLabel("Sex (Male/Female): ");
		lblNewLabel_4.setBounds(11, 183, 116, 13);
		contentPane.add(lblNewLabel_4);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(148, 210, 96, 19);
		contentPane.add(age);
		
		JLabel lblNewLabel_5 = new JLabel("Age: ");
		lblNewLabel_5.setBounds(11, 216, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		goal = new JTextField();
		goal.setColumns(10);
		goal.setBounds(148, 239, 96, 19);
		contentPane.add(goal);
		
		JLabel lblNewLabel_6 = new JLabel("Goal: ");
		lblNewLabel_6.setBounds(11, 245, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Experience: ");
		lblNewLabel_7.setBounds(280, 19, 78, 13);
		contentPane.add(lblNewLabel_7);
		
		experience = new JTextField();
		experience.setColumns(10);
		experience.setBounds(368, 16, 96, 19);
		contentPane.add(experience);
		
		updates = new JLabel("");
		updates.setBounds(280, 48, 184, 13);
		contentPane.add(updates);
		
		lblNewLabel_9 = new JLabel("Select Coach:");
		lblNewLabel_9.setBounds(280, 72, 103, 13);
		contentPane.add(lblNewLabel_9);
		
		btnNewButton = new JButton("Create a new account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userName.getText().isEmpty() || password.getText().isEmpty() || height.getText().isEmpty()
						|| weight.getText().isEmpty() || sex.getText().isEmpty() || age.getText().isEmpty()) {
					updates.setText("Fill in all the necessary fields.");
				} else {
					if ((traineeRBB.isSelected() && (goal.getText().isEmpty())) || (coachRBB.isSelected() && experience.getText().isEmpty()))
						updates.setText("Fill in the necessary fields.");
					else {
						String type;
						String cExperience, tGoal;
						if (traineeRBB.isSelected()) {
							type = "Trainee";
							cExperience = "";
							tGoal = goal.getText();
							coachId = Integer.parseInt((String) comboBox.getSelectedItem());
						} else {
							type = "Coach";
							cExperience = experience.getText();
							tGoal = "";
						}
						TrainingSys.addUser(type, Integer.parseInt(id.getText()), userName.getText(), password.getText(), Integer.parseInt(height.getText()), Double.parseDouble(weight.getText()), sex.getText(), Integer.parseInt(age.getText()), cExperience, tGoal, coachId);
						dispose();
					}
				}
			}
		});
		btnNewButton.setBounds(290, 238, 174, 20);
		contentPane.add(btnNewButton);
		
	}
}
