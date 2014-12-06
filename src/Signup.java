import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Signup extends JPanel implements ActionListener{
	
	protected Database DB = new Database();
	
	protected JButton okbt, cancelbt;
	private TextField  idText, pwText, nameText, departmentText;
	private JLabel idLabel, pwLabel, nameLabel, departmentLabel;
	
	protected Signup() {
		setSize(750,750);
		setLayout(null);
		setBackground(Color.YELLOW);
	
		idLabel = new JLabel("ID: ");
		idLabel.setBounds(250,180, 40,25);
		add(idLabel);
		
		idText = new TextField("");
		idText.setBounds(300,180,200,25);
		add(idText);
		
		pwLabel = new JLabel("PW: ");
		pwLabel.setBounds(250, 230, 40,25);
		add(pwLabel);
		
		pwText = new TextField("");
		pwText.setBounds(300,230,200,25);
		add(pwText);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(250, 280, 40,25);
		add(nameLabel);
		
		nameText = new TextField("");
		nameText.setBounds(300,280,200,25);
		add(nameText);
		
		departmentLabel = new JLabel("Department: ");
		departmentLabel.setBounds(210, 330, 80,25);
		add(departmentLabel);
		
		departmentText = new TextField("");
		departmentText.setBounds(300,330,200,25);
		add(departmentText);
		
		okbt = new JButton("OK");
		okbt.setBounds(250, 400, 100, 50);
		okbt.addActionListener(this);
		add(okbt);
		
		cancelbt = new JButton("Go back\n to Main");
		cancelbt.setBounds(400, 400, 150, 50);
		cancelbt.setMargin(new Insets(0, 0, 0, 0));
		cancelbt.addActionListener(this);
		add(cancelbt);
		
		setVisible(true);
	}
	
	private void clear(){
		idText.setText("");
		pwText.setText("");
		nameText.setText("");
		departmentText.setText("");
	}
	
	public boolean signup(){
		String id = idText.getText().trim();
		String pw = pwText.getText().trim();
		String name = nameText.getText().trim();
		String department = departmentText.getText().trim();
		
		if (id == null || pw == null || id.length() == 0 || pw.length() == 0){
			JOptionPane.showMessageDialog(this, "Please insert ID and PW");
			return false;
		}
		
			DB.ADD_ID(id, pw, name, department);	
			JOptionPane.showMessageDialog(this, "Congratulion! \nSignup Success!! ~(^0^)~");
			clear();
			return true;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if( o == okbt){
		}
		
		if (o == cancelbt){
		}
	}
}
