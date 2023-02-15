package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Trainee;
import MainAndSys.TrainingSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFoodFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField calories;
	private JTextField protein;
	private JTextField carbs;
	private JTextField fats;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddFoodFrame frame = new AddFoodFrame();
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
	public AddFoodFrame(Trainee t) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(107, 10, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Food Name: ");
		lblNewLabel.setBounds(29, 13, 78, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Calories: ");
		lblNewLabel_1.setBounds(29, 42, 57, 13);
		contentPane.add(lblNewLabel_1);
		
		calories = new JTextField();
		calories.setColumns(10);
		calories.setBounds(107, 39, 96, 19);
		contentPane.add(calories);
		
		JLabel lblNewLabel_2 = new JLabel("Protein: ");
		lblNewLabel_2.setBounds(29, 68, 57, 13);
		contentPane.add(lblNewLabel_2);
		
		protein = new JTextField();
		protein.setColumns(10);
		protein.setBounds(107, 65, 96, 19);
		contentPane.add(protein);
		
		JLabel lblNewLabel_3 = new JLabel("Carbs: ");
		lblNewLabel_3.setBounds(29, 99, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		carbs = new JTextField();
		carbs.setColumns(10);
		carbs.setBounds(107, 96, 96, 19);
		contentPane.add(carbs);
		
		JLabel lblNewLabel_4 = new JLabel("Fats: ");
		lblNewLabel_4.setBounds(29, 128, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		fats = new JTextField();
		fats.setColumns(10);
		fats.setBounds(107, 125, 96, 19);
		contentPane.add(fats);
		
		JLabel updates = new JLabel("");
		updates.setBounds(29, 156, 174, 11);
		contentPane.add(updates);
		
		JButton btnNewButton = new JButton("Add Food");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calories.getText().isEmpty() || protein.getText().isEmpty() || carbs.getText().isEmpty() || fats.getText().isEmpty())
					updates.setText("Fill all necessary fields!");
				else {
					t.addMeal(name.getText(), Integer.parseInt(calories.getText()), Double.parseDouble(protein.getText()), Double.parseDouble(carbs.getText()), Double.parseDouble(fats.getText()));
					dispose();
				}
			}
		});
		btnNewButton.setBounds(68, 177, 96, 21);
		contentPane.add(btnNewButton);
	}

}
