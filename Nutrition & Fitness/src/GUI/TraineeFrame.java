package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Trainee;
import MainAndSys.TrainingSys;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TraineeFrame extends JFrame {

	private JPanel contentPane;
	private Trainee t;
	private AddFoodFrame addFood;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TraineeFrame frame = new TraineeFrame();
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
	public TraineeFrame(Trainee t) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(78, 99, 413, 213);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Display Workout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (t.getWorkout() != null)
					textArea.setText(t.getWorkout().toString());
				else
					textArea.setText("Your coach has not made your workout yet!");
			}
		});
		btnNewButton.setBounds(78, 39, 132, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Display Macros Left");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.calculateMacros();
				textArea.setText(t.calculateMacrosLeft() + "\n\n" + t.displayMeals());
			}
		});
		btnNewButton_1.setBounds(213, 68, 151, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Food");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFood = new AddFoodFrame(t);
				addFood.setTitle("Add Meal");
				addFood.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(370, 39, 121, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingSys.writeToBinary();
			}
		});
		btnNewButton_3.setBounds(249, 39, 85, 21);
		contentPane.add(btnNewButton_3);
	}

}
