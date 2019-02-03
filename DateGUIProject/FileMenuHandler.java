import java.util.TreeMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * FileMenuHandler first directs the program what to do if the user clicks either "Open" or "Quit" from the drop-down menu. 
 * It then refers down to openFile(), which, if the user selects a file, calls the readFile function, which then tokenizes into separate dates
 * and checks their validity.
 */


public class FileMenuHandler implements ActionListener {

	JFrame myFrame;
	
	public FileMenuHandler (JFrame jf)
	{
		myFrame = jf;
		
	}
	
	/**
	 * actionPerformed handles what menu selection the user chose, either Open or Quit. If they selected Open, the method openFile() is called. If Quit is called,
	 * the program exits.
	 */
	
	public void actionPerformed(ActionEvent event)
	{
		String menuName = event.getActionCommand();
		
		if (menuName.equals("Open")) 
			openFile();
		
		else if (menuName.equals("Quit"))
			System.exit(0);
			
	}
	
	/**
	 * openFile has no return, it simply creates a JFileChooser and stores the users action as an int value (yes/no). Once the file is selected by the user, the 
	 * readFile() method is called, and the selected file is fed into it.
	 */
	
	private void openFile() 
	{
		JFileChooser chooser = new JFileChooser();
		int status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION)
		readFile(chooser.getSelectedFile());
	}

/**
 * @param chosenFile 
 * The readFile method will take in a variable of type File called chosenFile. The program then gets the filepath name of the file and feeds that into the pre-existing 
 * TextFileInput method, and the program proceeds as it did in Project 2.
 */

public void readFile(File chosenFile)
{
		String chosenFileName = chosenFile.getAbsolutePath();
		TextFileInput text = new TextFileInput(chosenFileName);
		
//		Container cPane = myFrame.getContentPane();
//	    
//		TextArea left = new TextArea();
//		TextArea right = new TextArea();
//		
//		cPane.add(left);
//		cPane.add(right);
//		
//		myFrame.add(left);
//	    myFrame.add(right);
//		
		//SortedDateList ListSorted =  new  SortedDateList();
	    
	    UnsortedDateList ListUnsorted = new UnsortedDateList();
/**
 * TreeMap is declared and takes in a Date212 and String as a ket/value pair. The new TreeMap takes the Date212Comparator class we created
 * as an argument, so anything passed through TreeMap is also passed through the Comparator and organized. The TreeMap is being used in place of
 * the sorted linked list, and will be appended to a textarea and displayed on the GUI the same way. This time, a TreeMap is being added (with ".put") instead
 * of one of the lists.
 */
		
		TreeMap <Date212, String> dateMap = new TreeMap (new Date212Comparator());
		
		String line = text.readLine();
		
		while (line != null)
		{	
		  StringTokenizer st = new StringTokenizer (line , ","); /**StringTokenizer to split each string up by each line and using commas as delimeters*/
			
			while (st.hasMoreTokens()) /**While there are more tokens*/
			{
				String date = st.nextToken(); /**Store new token in a string variable to be manipulated*/
				
				if (Date212.check(date)) /**Refers to boolean check() method that is in our Date212 */
				{
					Date212 formatDate = new Date212(date);
					
					ListUnsorted.add(formatDate);
					dateMap.put(formatDate, date);
					//ListSorted.add(formatDate);
				}   
				
				else
				{
					try 
					{
						throw new IllegalDate212Exception ("Invalid date: " + date);
					}
					catch (Exception x)
					{
						System.out.println (x);
					}
				}
				
			}
			
			line = text.readLine();
		}
		
	Container cPane = myFrame.getContentPane();
	    
		TextArea left = new TextArea();
		TextArea right = new TextArea();
		
		cPane.add(left);
		cPane.add(right);
		
		myFrame.add(left);
	    myFrame.add(right);
		
		
		left.append(ListUnsorted.toString());
		
		
			for (Date212 d : dateMap.keySet()) //Needs to iterated through, selecting only the key values, because the default toString for TreeMap is not the format we want
		{
			right.append(d + "\n");
		}

			myFrame.setVisible(true);
			
	   //right.append(dateMap.toString());
	}

}
	
	




