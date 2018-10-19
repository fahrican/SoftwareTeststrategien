import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Range;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dezibelwiedergabe {

	private JFrame frame;
	private JTextField textFieldDecibel;
	private JTextField textFieldDays;
	private JTextField textFieldEuro;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dezibelwiedergabe window = new Dezibelwiedergabe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dezibelwiedergabe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldDecibel = new JTextField();
		textFieldDecibel.setBounds(81, 30, 130, 26);
		frame.getContentPane().add(textFieldDecibel);
		textFieldDecibel.setColumns(10);
		
		JLabel lblDezibel = new JLabel("Decibel:");
		lblDezibel.setBounds(6, 30, 84, 26);
		frame.getContentPane().add(lblDezibel);
		
		JLabel lblTage = new JLabel("Days:");
		lblTage.setBounds(6, 81, 61, 16);
		frame.getContentPane().add(lblTage);
		
		textFieldDays = new JTextField();
		textFieldDays.setBounds(81, 76, 130, 26);
		frame.getContentPane().add(textFieldDays);
		textFieldDays.setColumns(10);
		
		JButton btnNewButton = new JButton("calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				int decibel, days, euro;
				Range range = new Range();
				try {
					
					decibel = Integer.parseInt(textFieldDecibel.getText());
					if (range.checkForCorrectRange(10, 150, decibel) == -1) {
						JOptionPane.showMessageDialog(null, "Decibel must be between 10 and 150", "Invalid number!", 0);
					}
					
					days = Integer.parseInt(textFieldDays.getText());
					if (range.checkForCorrectRange(1, 31, days) == -1) {
						JOptionPane.showMessageDialog(null, "Day must be between 1 and 31", "Invalid number!", 0);
					}

					if (range.checkForCorrectRange(10, 150, decibel) != -1 && range.checkForCorrectRange(1, 31, days) != -1) {
					
						euro = decibel * days;
						textFieldEuro.setText(String.valueOf(euro));
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Please enter a valid number", "Invalid number!", 0);
				}
			}
		});
		btnNewButton.setBounds(122, 131, 89, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblEuro = new JLabel("Euro:");
		lblEuro.setBounds(6, 228, 61, 16);
		frame.getContentPane().add(lblEuro);
		
		textFieldEuro = new JTextField();
		textFieldEuro.setBounds(81, 223, 130, 26);
		frame.getContentPane().add(textFieldEuro);
		textFieldEuro.setColumns(10);
		
		btnNewButton_1 = new JButton("clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldDays.setText("");
				textFieldDecibel.setText("");
				textFieldEuro.setText("");
			}
		});
		btnNewButton_1.setBounds(6, 131, 89, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	
}
