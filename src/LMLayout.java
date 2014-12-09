import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LMLayout extends JFrame implements ActionListener{
	
//	private static final long serialVersionUID = 1L;
	
	protected Login LoginPanel;
	protected Signup SignupPanel;
	protected Search SearchPanel;
	protected AddBook AddBookPanel;
	
	protected static JPanel mainPanel;
	
	protected static CardLayout cl;	
	
	public LMLayout(){
		super("Library Managerment Program");
		setSize(750,750);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addLayout();
		setVisible(true);
	}
	
	public void addLayout(){
		mainPanel = new JPanel();
		mainPanel.setLayout( new CardLayout());

		//Login 화면---------------------------------- 
		LoginPanel = new Login();
		mainPanel.add(LoginPanel,"login");
		
		LoginPanel.signupbt.addActionListener(this);
		LoginPanel.loginbt.addActionListener(this);
		
		//Signup 화면-------------------------------------------
		SignupPanel = new Signup();
		mainPanel.add(SignupPanel, "signup");
		
		SignupPanel.okbt.addActionListener(this);
		SignupPanel.cancelbt.addActionListener(this);
		
		//Search 화면-------------------------------------------
		SearchPanel = new Search();
		mainPanel.add(SearchPanel, "search");
		
		SearchPanel.searchbt.addActionListener(this);
		//SearchPanel.cancelbt.addActionListener(this);
		
		
		Container con=getContentPane();
		con.add(mainPanel);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		cl = (CardLayout)mainPanel.getLayout();
		
		if (o == LoginPanel.loginbt){
			LoginPanel.login();
		}

		if (o == LoginPanel.signupbt)
			cl.show(mainPanel, "signup");
			
		
		if (o == SignupPanel.okbt){
			if (SignupPanel.signup())
			cl.show(mainPanel, "login");
		}
		
		if (o == SignupPanel.cancelbt)	
			cl.show(mainPanel, "login");  
		
		if (o == SearchPanel.searchbt)	
			SearchPanel.search(); 
	}
	
	private final KeyListener textInputHander = new KeyListener(){
		public void keyPressed(KeyEvent e)
		{
		//	if(e.getKeyCode() == KeyEvent.VK_ENTER)
		//		inputtext = idtext_login.getText();
		}
		        
		public void keyTyped(KeyEvent e) {
            
        }

        public void keyReleased(KeyEvent e) {
            
        }
	};
}
