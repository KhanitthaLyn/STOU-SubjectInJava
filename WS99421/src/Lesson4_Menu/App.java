package Lesson4_Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class App extends JFrame implements ActionListener{

  JMenuItem exitmenu, newmenu;
  
  public App() {
	// 1) JFrame Initialization
	setTitle("Menu");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(500,500);
	setLocation(800, 100);
	setLocationRelativeTo(null);

	// 2) set jframe container
	JPanel maincontainer = new JPanel();
	setContentPane(maincontainer);
	maincontainer.setBackground(new Color(230,10,68));
	
	// 3) Menu
	// 3.1) create menu bar
	JMenuBar menubar = new JMenuBar();
	this.setJMenuBar(menubar);
	// 3.2 create menu
	JMenu filemenu = new JMenu("File");
	menubar.add(filemenu);
	
	JMenu projectmenu = new JMenu("Project");
	menubar.add(projectmenu);
	
	newmenu = new JMenuItem("New");
	newmenu.addActionListener(this);
	filemenu.add(newmenu);
	
	JMenuItem savemenu = new JMenuItem("Save");
	filemenu.add(savemenu);

	filemenu.addSeparator();
	
	exitmenu = new JMenuItem("Exit");
	exitmenu.addActionListener(this);
	filemenu.add(exitmenu);
  }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitmenu) {
			System.out.println("Exit");
			System.exit(0);
		}
		else if(e.getSource()==newmenu) {
			Lesson2_Component.App newapp = new Lesson2_Component.App();
			newapp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			newapp.setVisible(true);
		}
	}

}
