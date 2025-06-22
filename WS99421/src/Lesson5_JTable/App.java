package Lesson5_JTable;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class App extends JFrame{
  public App() {
	// 1) JFrame Initialization
	setTitle("JTable");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(500,500);
	// 2) set jframe container
	JPanel maincontainer = new JPanel();
	setContentPane(maincontainer);
	maincontainer.setBackground(new Color(230,10,68));
	
	// JTable
	String[] columnname = {"Name","Surname","Password"};
	String[][] data = {
			           {"Urai","Jaidee","1234"},
			           {"Mana","Rakrien","1234"}
	                  };
	
	// 1) create DefaultTableModel
	DefaultTableModel dtm = new DefaultTableModel(data,columnname);

	// 2) create JTable
	JTable jt = new JTable(dtm);
	
	// 3) create JScrollBar
	JScrollPane jsp = new JScrollPane(jt);
	jsp.setPreferredSize(new Dimension(300,100));
	maincontainer.add(jsp);

	// add
	dtm.addRow(new String[]{"chujai","rakdee","1234"});
	dtm.addRow(new String[]{"chujai","rakdee","1234"});
	dtm.addRow(new String[]{"chujai","rakdee","1234"});
	dtm.addRow(new String[]{"chujai","rakdee","1234"});
	dtm.addRow(new String[]{"chujai","rakdee","1234"});
	dtm.addRow(new String[]{"chujai","rakdee","1234"});
	
	// remove
//	dtm.removeRow(0);
	
	// update
	dtm.setValueAt("uraipaitoon", 0, 0);
	
	// clear
	dtm.setRowCount(0);
  }
}
