package Lesson1_SimpleJFrame;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame{
  public App() {
	// 1) JFrame Initialization
	this.setTitle("My Application");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setSize(500,100);
	this.setLocation(800, 100);
	this.setLocationRelativeTo(null);
	this.setResizable(true);
	// 2) set jframe container
	JPanel maincontainer = new JPanel();
	this.setContentPane(maincontainer);
	// -- set background color
//	maincontainer.setBackground(Color.red);
//	Color mybackgroundcolor = new Color(230,10,68);
//	maincontainer.setBackground(mybackgroundcolor);
	maincontainer.setBackground(new Color(230,10,68));
	this.setVisible(true);
  }
}
