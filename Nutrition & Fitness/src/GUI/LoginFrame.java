package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Coach;
import Inheritance.Trainee;
import Inheritance.User;
import MainAndSys.TrainingSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JLabel updates;
	private JTextField textField;
	private CreateUserFrame createUser = new CreateUserFrame(this);
	private TraineeFrame traineeFrame;
	private CoachFrame coachFrame;
	private JPasswordField password;
	// 
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(210, 62, 96, 19);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(125, 65, 75, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(125, 104, 75, 13);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(210, 101, 96, 19);
		contentPane.add(password);
		
		updates = new JLabel("");
		updates.setBounds(125, 135, 198, 13);
		contentPane.add(updates);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (password.getText().isEmpty())
					password.setText("You can't leave the password field empty!");
				else if (userName.getText().isEmpty())
					userName.setText("You can't leave the username field empty!");
				else {
					User currentUser = TrainingSys.checkLogin(userName.getText(), password.getText());
					if (currentUser == null)
						updates.setText("User information does not exist! Create a new user or login with different information.");
					else {
						if (currentUser instanceof Trainee) {
							traineeFrame = new TraineeFrame((Trainee) currentUser);
							traineeFrame.setTitle("Training & Diet");
							traineeFrame.setVisible(true);
							dispose();
						}
						else {
							coachFrame = new CoachFrame((Coach) currentUser);
							coachFrame.setTitle("Create Workouts & Check Trainee Progress");
							coachFrame.setVisible(true);
							dispose();
						}
					}
					//TraineeFrame.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(176, 158, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create a New Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser.setTitle("Create New Account");
				createUser.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(125, 196, 181, 21);
		contentPane.add(btnNewButton_1);
	}
}
