import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login extends JPanel implements ActionListener{
	
	protected Database DB = new Database();
	
	protected JButton loginbt, signupbt;
	private TextField  idText, pwText;
	private JLabel idLabel, pwLabel;
	
	protected Login() {
		setSize(750,750);
		setLayout(null);
		setBackground(Color.PINK);
	
		idLabel = new JLabel("ID: ");
		idLabel.setBounds(250, 285, 40,20);
		add(idLabel);
		
		idText = new TextField("");
		idText.setBounds(300,285,200,20);
		add(idText);
		
		pwLabel = new JLabel("PW: ");
		pwLabel.setBounds(250, 330, 40,20);
		add(pwLabel);
		
		pwText = new TextField("");
		pwText.setBounds(300,330,200,20);
		add(pwText);
		
		loginbt = new JButton("Login");
		loginbt.setBounds(250, 400, 100, 50);
		loginbt.addActionListener(this);
		add(loginbt);
		
		signupbt = new JButton("Signup");
		signupbt.setBounds(400, 400, 100, 50);
		signupbt.addActionListener(this);
		add(signupbt);
		
		setVisible(true);
	}
	
	public boolean login(){
		String id = idText.getText().trim();
		String pw = pwText.getText().trim();
		
		if (id == null || pw == null || id.length() == 0 || pw.length() == 0){
			JOptionPane.showMessageDialog(this, "Please insert ID and PW");
			return false;
		}
		
		if (DB.SEARCH_LOGIN(id, pw) == true){
			JOptionPane.showMessageDialog(this, "Login Success!");
			LMLayout.cl.show(LMLayout.mainPanel,"search");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(this, "Login Failed!");
			//LMLayout.cl.show(LMLayout.mainPanel,"search");
			return false;
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if( o == loginbt){
			
		}
		
		if (o == signupbt){

		}
	}
}
