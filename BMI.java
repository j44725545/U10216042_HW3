import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JLayeredPane;


public class BMI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Height;
	private JTextField textField_Weight;
	private JTextField textField_BMI;
	private JTextField textField_Age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI frame = new BMI();
					frame.setTitle("BMI");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			double height = Double.parseDouble(textField_Height.getText());
			double Weight = Double.parseDouble(textField_Weight.getText());
			double BMI = Weight/Math.pow(height*0.01,2);
			textField_BMI.setText(String.format("%.2f", BMI));
		}
	}

	/**
	 * Create the frame.
	 */
	public BMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("BMI");
		lblNewLabel.setBounds(302, 42, 41, 19);
		layeredPane.add(lblNewLabel);
		
		textField_Height = new JTextField();
		textField_Height.setBounds(115, 76, 116, 25);
		layeredPane.add(textField_Height);
		textField_Height.setColumns(10);
		
		textField_Weight = new JTextField();
		textField_Weight.setBounds(115, 114, 116, 25);
		layeredPane.add(textField_Weight);
		textField_Weight.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Height(cm)");
		lblNewLabel_1.setBounds(14, 79, 87, 19);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Weight(kg)");
		lblNewLabel_2.setBounds(14, 114, 87, 19);
		layeredPane.add(lblNewLabel_2);
		
		JButton btnCaculate = new JButton("calculate");
		btnCaculate.setBounds(115, 160, 99, 27);
		layeredPane.add(btnCaculate);
		
		textField_BMI = new JTextField();
		textField_BMI.setBounds(262, 76, 116, 25);
		layeredPane.add(textField_BMI);
		textField_BMI.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(14, 42, 57, 19);
		layeredPane.add(lblNewLabel_3);
		
		textField_Age = new JTextField();
		textField_Age.setBounds(115, 39, 116, 25);
		layeredPane.add(textField_Age);
		textField_Age.setColumns(10);
		
		btnCaculate.addActionListener(new ButtonListener());
	}
}
