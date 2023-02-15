package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Coach;
import MainAndSys.TrainingSys;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CoachFrame extends JFrame {

	private JPanel contentPane;
	private AddWorkout addWorkout;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CoachFrame frame = new CoachFrame();
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
	public CoachFrame(Coach c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 82, 595, 325);
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel<String>(TrainingSys.getCoachTrainees(c.getId())));
		comboBox.setBounds(507, 44, 98, 21);
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(TrainingSys.searchTrainee(Integer.parseInt((String) comboBox.getSelectedItem())).toString());
			}
		});
		
		JLabel lblNewLabel = new JLabel("Your trainees: ");
		lblNewLabel.setBounds(386, 48, 87, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Display All Trainees");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res = "";
				String[] traineeIds = new String[TrainingSys.getCoachTrainees(c.getId()).length];
				traineeIds = TrainingSys.getCoachTrainees(c.getId());
				if (traineeIds == null || traineeIds.length == 0)
					textArea.setText("You have no trainees!");
				else {
					textArea.setText(TrainingSys.displayCoachTrainees(c.getId()));
				}
			}
		});
		btnNewButton.setBounds(204, 44, 172, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Workout to Selected");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() != null) {
					addWorkout = new AddWorkout(TrainingSys.searchTrainee(Integer.parseInt((String) comboBox.getSelectedItem())));
					addWorkout.setTitle("Create Workout");
					addWorkout.setVisible(true);
				} else {
					textArea.setText("You have no trainees selected!");
				}
			}
		});
		btnNewButton_1.setBounds(10, 44, 184, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingSys.writeToBinary();
			}
		});
		btnNewButton_2.setBounds(520, 10, 85, 21);
		contentPane.add(btnNewButton_2);
	}

}
