import javax.swing.*;

import java.awt.*;



/**
* Display for our dates. Required two separate text areas, one for unsorted and one for sorted. The DateGUI accepts no parameters.
* It calls createFileMenu() after setting the JFrame Dimensions.
*/

public class DateGUI extends JFrame {
	
	JFrame myFrame = new JFrame();

	public DateGUI () {
	
	myFrame.setSize(400, 200);
	myFrame.setLocation(100, 200);
	myFrame.setTitle("Dates");
	myFrame.setLayout(new GridLayout (1,2));
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	createFileMenu();
	myFrame.setVisible(true); 
	
}

/**
 * createFileMenu accepts no arguments. It adds a Jmenubar, filemenu "File", and menu items "Open" and "Quit". It then adds the MenuBar to the JFrame.
 */

private void createFileMenu() {
	
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem item;
	
	FileMenuHandler fmh = new FileMenuHandler(myFrame);
	
	item = new JMenuItem("Open"); 
	item.addActionListener(fmh);
	fileMenu.add(item);
	
	fileMenu.addSeparator(); 
	
	item = new JMenuItem("Quit"); 
	item.addActionListener(fmh);
	fileMenu.add(item);
	
	menuBar.add(fileMenu);
	
	myFrame.setJMenuBar(menuBar);
	
	}

}