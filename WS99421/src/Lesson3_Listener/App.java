package Lesson3_Listener;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	// add JButton
	// font
	Font myfont;
	myfont = new Font("Tahoma",Font.BOLD|Font.ITALIC,20);


	JButton btn2 = new JButton();
	btn2.setText("Enroll");
//	maincontainer.add(btn2);
	
	JButton btn3 = new JButton();
	btn3.setText("Withdraw");
//	maincontainer.add(btn3);
	
	// JLabel
	JLabel lbl1 = new JLabel("Name");
	lbl1.setBorder(BorderFactory.createLineBorder(Color.yellow, 4));
	maincontainer.add(lbl1);

	// JTextField
	JTextField txt1 = new JTextField(10);
	txt1.setFont(myfont);
	maincontainer.add(txt1);
	
	JButton btn1 = new JButton("Register");
	btn1.setBackground(Color.yellow);
	btn1.setForeground(Color.green);
	// change font
	btn1.setText("ลงทะเบียน");	
	btn1.setFont(myfont);	
	maincontainer.add(btn1);
	btn1.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					showView v = new showView();
//					System.out.println(v.lblinput.getText());
//					v.setlabeltext(txt1.getText());
//					v.lblinput.setText(txt1.getText());
//					System.out.println(txt1.getText());
					v.setVisible(true);					
				}
			}
			);		

	this.setVisible(true);
  }
}
