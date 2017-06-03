import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyGUI {

	private JFrame frame;
	private JTextField txtField1;
	private JButton btnSub;
	private JButton btnMulti;
	private JButton btnDivd;
	private JTextField txtField2;
	private JTextField txtDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGUI window = new MyGUI();
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
	public MyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtField1 = new JTextField();
		txtField1.setBounds(10, 106, 57, 36);
		frame.getContentPane().add(txtField1);
		txtField1.setColumns(10);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double firstNum = Double.parseDouble(txtField1.getText());
				double secondNum = Double.parseDouble(txtField2.getText());
				double result = firstNum + secondNum;
				
				if(txtField2.getText().equals("0")){
					txtDisplay.setText("undef");
				}else{
				txtDisplay.setText(result + "");
				}
			}
		});
		btnAdd.setBounds(87, 109, 72, 30);
		frame.getContentPane().add(btnAdd);
		
		btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double firstNum = Double.parseDouble(txtField1.getText());
				double secondNum = Double.parseDouble(txtField2.getText());
				double result = firstNum - secondNum;
				
				if(txtField2.getText().equals("0")){
					txtDisplay.setText("undef");
				}else{
				txtDisplay.setText(result + "");
				}
			}
		});
		btnSub.setBounds(87, 159, 72, 30);
		frame.getContentPane().add(btnSub);
		
		btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double firstNum = Double.parseDouble(txtField1.getText());
				double secondNum = Double.parseDouble(txtField2.getText());
				double result = firstNum * secondNum;
				
				if(txtField2.getText().equals("0")){
					txtDisplay.setText("undef");
				}else{
				txtDisplay.setText(result + "");
				}
			
			}
		});
		btnMulti.setBounds(87, 218, 72, 30);
		frame.getContentPane().add(btnMulti);
		
		btnDivd = new JButton("/");
		btnDivd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double firstNum = Double.parseDouble(txtField1.getText());
				double secondNum = Double.parseDouble(txtField2.getText());
				double result = firstNum / secondNum;
				
				if(txtField2.getText().equals("0")){
					txtDisplay.setText("undef");
				}else{
				txtDisplay.setText(result + "");
				}
			
			}
		});
		btnDivd.setBounds(87, 271, 72, 30);
		frame.getContentPane().add(btnDivd);
		
		txtField2 = new JTextField();
		txtField2.setColumns(10);
		txtField2.setBounds(206, 106, 57, 36);
		frame.getContentPane().add(txtField2);
		
		txtDisplay = new JTextField();
		txtDisplay.setColumns(10);
		txtDisplay.setBounds(336, 106, 57, 36);
		frame.getContentPane().add(txtDisplay);
	}
}
