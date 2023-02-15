package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trainee_HasA.Exercise;
import Trainee_HasA.Workout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddExerciseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField numOfSets;
	private JTextField numOfReps;
	private JTextField weightUsed;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddExerciseFrame frame = new AddExerciseFrame();
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
	public AddExerciseFrame(Workout w) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(25, 34, 105, 13);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(140, 34, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		numOfSets = new JTextField();
		numOfSets.setColumns(10);
		numOfSets.setBounds(140, 63, 96, 19);
		contentPane.add(numOfSets);
		
		JLabel lblNewLabel_1 = new JLabel("Number of sets: ");
		lblNewLabel_1.setBounds(25, 63, 105, 13);
		contentPane.add(lblNewLabel_1);
		
		numOfReps = new JTextField();
		numOfReps.setColumns(10);
		numOfReps.setBounds(140, 92, 96, 19);
		contentPane.add(numOfReps);
		
		JLabel lblNewLabel_2 = new JLabel("Number of reps: ");
		lblNewLabel_2.setBounds(25, 92, 105, 13);
		contentPane.add(lblNewLabel_2);
		
		weightUsed = new JTextField();
		weightUsed.setColumns(10);
		weightUsed.setBounds(140, 121, 96, 19);
		contentPane.add(weightUsed);
		
		JLabel lblNewLabel_3 = new JLabel("Weight to use: ");
		lblNewLabel_3.setBounds(25, 121, 105, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel updates = new JLabel("");
		updates.setBounds(61, 147, 175, 13);
		contentPane.add(updates);
		
		JButton btnNewButton = new JButton("Add Exercise to Workout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!name.getText().isEmpty() && !numOfSets.getText().isEmpty() && !numOfReps.getText().isEmpty() && !weightUsed.getText().isEmpty()) {
					w.addExercise(name.getText(), Integer.parseInt(numOfSets.getText()), Integer.parseInt(numOfReps.getText()), Double.parseDouble(weightUsed.getText()));
					dispose();
			} else {
					updates.setText("Fill in all necessary fields!");
			}
			}
		});
		btnNewButton.setBounds(25, 170, 211, 21);
		contentPane.add(btnNewButton);
	}

}
