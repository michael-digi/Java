

/**
*<p>This program will utilize a GUI menu that includes a "File" button that the user can click on and then select either an "Open" or "Quit" button. The "Quit"
* button will exit out of the program, but the "Open" will allow the user to select a file from their computer. The selected file will be fed into a method, where each
* line will be tokenized into a date, their format validated, and then added to two different linked lists that we have created.
* 
* <p>The first linked list will be unsorted, and simply append the dates as they are read from the text file to the list. The second list will require an insert method, where
* we will write code to compare two dates and then move them to the appropriate place in the list. In this case, starting with the oldest date at the top of the list.
* There will be two subclasses of DateList, UnsortedDateList and SortedDateList, which will have the append and insert method, respectively.
* 
* We will have then print these two lists in separate columns to a GUI, and any string that is not valid will be printed to the console. We will have 9 classes, one to
* create the nodes (DateNode), (IllegalDate212Exception) which is a custom exception to catch an invalid date, one to compare/check the dates (Date212), another where our 
* String/append/insert methods will reside (DateList), a subclass where our append method is (UnsortedDateList), where our insert method is (SortedDateList), our (FileMenuHandler) 
* where we will open and read files and also print to lists, our GUI (DateGUI) and finally our main Project 3, which simply instantiates the GUI.
*  
*  
* <p>@author MichaelDigiorgio 
* Project4
* CSCI 212-11D
* @version"1.6.0_65"
*/


public class Project4 {
/**
 * @param args is just the standard parameter for main profile
 */
	public static void main (String [] args)
	
	{
		DateGUI gui = new DateGUI(); //Entire main is just to call GUI into action
	}
	
}