package Lesson3_Listener;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class showView extends JFrame{
	JLabel lblinput;
	
	public showView() {
		setSize(200,200);
		// container
		JPanel container = new JPanel();
		container.setBackground(Color.orange);
		setContentPane(container);
		
		JLabel lblname = new JLabel("Name : ");
		container.add(lblname);
		
		lblinput = new JLabel("xxxxxxxx");
		lblinput.setFont(new Font("Tahoma",Font.BOLD,24));
		container.add(lblinput);
		
	}
//	public void setlabeltext(String str) {
//		lblinput.setText(str);
//	}
	
	
}
