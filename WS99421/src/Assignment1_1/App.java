package Assignment1_1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App extends JFrame{
  public App() {
	// 1) JFrame Initialization
	this.setTitle("Simple Component");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	this.setSize(800,700);
//	this.setLocation(200, 100);
	this.setBounds(100, 100, 1000, 500);
	this.setResizable(true);
	// 2) set jframe container
	
	// 2.1) layout manager
	FlowLayout mylayout;
	mylayout = new FlowLayout(FlowLayout.LEFT);
	
	JPanel maincontainer = new JPanel(mylayout);
	this.setContentPane(maincontainer);
	// -- set background color
	maincontainer.setBackground(new Color(255,0,0));

	// 3) Add components
	// Font
	Font myfont;
	myfont = new Font("Tahoma",Font.BOLD|Font.ITALIC,20);
	// JLable
	JLabel lbl1 = new JLabel("Name");
	lbl1.setBorder(BorderFactory.createLineBorder(Color.yellow, 4));
	maincontainer.add(lbl1);

	// JTextField
	JTextField txt1 = new JTextField(10);
	txt1.setFont(myfont);
	maincontainer.add(txt1);
	// add JButton
	JButton btn1 = new JButton("Register");
	btn1.setBackground(Color.yellow);
	btn1.setForeground(Color.green);
	// change font
	btn1.setText("ลงทะเบียน");
	
	btn1.setFont(myfont);	
	maincontainer.add(btn1);

	JButton btn2 = new JButton();
	btn2.setText("Enroll");
	maincontainer.add(btn2);
	
	JButton btn3 = new JButton();
	btn3.setText("Withdraw");
	maincontainer.add(btn3);
	
	
	this.setVisible(true);
  }
}
