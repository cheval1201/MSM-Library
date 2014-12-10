import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Search extends JPanel implements ActionListener{
	
	protected Database DB = new Database();
	
	protected JButton searchbt, addbookbt, rentstatebt;
	private TextField  searchText, searchResult;
	private JLabel searchLabel;
	
	protected Search() {
		setSize(750,750);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
	
		searchLabel = new JLabel("Search : ");
		searchLabel.setBounds(50, 85, 60,20);
		add(searchLabel);
		
		searchText = new TextField("");
		searchText.setBounds(120,85,480,20);
		add(searchText);
		
		searchbt = new JButton("Search");
		searchbt.setBounds(610, 85, 80, 20);
		searchbt.addActionListener(this);
		add(searchbt);
		
		addbookbt = new JButton("Add new book");
		addbookbt.setBounds(120, 35, 150, 30);
		addbookbt.addActionListener(this);
		add(addbookbt);
		
		rentstatebt = new JButton("My rented books");
		rentstatebt.setBounds(450, 35, 150, 30);
		rentstatebt.addActionListener(this);
		add(rentstatebt);
		
		searchResult = new TextField("");
		searchResult.setBounds(120,130,480,500);
		add(searchResult);
		
		setVisible(true);
	}
	
	public boolean search(){
		String searchWord = searchText.getText().trim();
		
		if (searchWord == null || searchWord.length() == 0 ){
			JOptionPane.showMessageDialog(this, "Please insert one or more word to search");
			return false;
		}
		else return true;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if( o == searchbt){
			
		}

	}
}
