package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Trainee;
import MainAndSys.TrainingSys;
import Trainee_HasA.Workout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWorkout extends JFrame {

	private JPanel contentPane;
	private JTextField cardioType;
	private JTextField cardioLength;
	private AddExerciseFrame addExercise;
	private Workout w;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddWorkout frame = new AddWorkout();
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
	public AddWorkout(Trainee t) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cardioType = new JTextField();
		cardioType.setBounds(138, 42, 96, 19);
		contentPane.add(cardioType);
		cardioType.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cardio type: ");
		lblNewLabel.setBounds(34, 45, 94, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cardio length: ");
		lblNewLabel_1.setBounds(34, 84, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		cardioLength = new JTextField();
		cardioLength.setColumns(10);
		cardioLength.setBounds(138, 81, 96, 19);
		contentPane.add(cardioLength);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(268, 42, 144, 211);
		contentPane.add(textArea);
		

		JLabel updates = new JLabel("");
		updates.setBounds(34, 107, 200, 13);
		contentPane.add(updates);
		
		JButton btnNewButton = new JButton("Add Exercise");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cardioType.getText().isEmpty() || cardioLength.getText().isEmpty())
					updates.setText("Fill in all necessary fields!");
				else {
					if (w == null)
						w = new Workout(cardioType.getText(), Integer.parseInt(cardioLength.getText()));
					addExercise = new AddExerciseFrame(w);
					addExercise.setTitle("Add Exercise");
					addExercise.setVisible(true);
					}
			}
		});
		btnNewButton.setBounds(34, 160, 200, 19);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finish Adding Workout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cardioType.getText().isEmpty() || cardioLength.getText().isEmpty())
					updates.setText("Fill in all necessary fields!");
				else {
					t.setWorkout(w);
					TrainingSys.writeToBinary();
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(34, 189, 200, 19);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show added exercises");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (w.getExercises().isEmpty())
					textArea.setText("You have not added any exercises!");
				else
					textArea.setText(w.displayExercises());
			}
		});
		btnNewButton_2.setBounds(34, 130, 200, 21);
		contentPane.add(btnNewButton_2);
	}

}
