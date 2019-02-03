public class Date212 {
   
	private int year; 
	private int month;
    private int day;
    
    /**
     * @param date is of type String and the date from our text file is ded into it
     * @return is boolean, it will return true if the length is correct (8 characters) and false if it does not or catches an exception.
     */
    
    public static boolean check(String date) /** This is used in the main method to check the tokens and to see if the length of them is valid*/
    {
    	try 
    	{
    		Integer.parseInt(date);
    		if (date.length() == 8)
    			return true;
    		
    		else 
    			return false;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    }
    
    /**
     * @param d is of type String and is passed into Date212 to be parsed and passed into the other Date212 int constructor to be checked.
     */
    
    
    Date212 (String d) 
    /**
     * This constructor accepts a string, which will be our 8 digit date, extracts the year/month/day via substring, parses them as int,
     * then feeds it into the Date212 constructor (which can only accept int). */
    {
    	this   (Integer.parseInt(d.substring(0,4)), Integer.parseInt(d.substring(4,6)), Integer.parseInt(d.substring(6,8)));
    }

    /**
     * @param y is the year and does not need to be checked
     * @param m is the month and needs to be checked to make sure it is between 1 and 12
     * @param d is the day and needs to be checked to make sure it is between 1 and 31
     */
    
    Date212 (int y, int m, int d) 
    /**
     * This accepts the parsed substrings from the other Date212 constructor and simply validates their format (i.e, there cannot be 
     * a 13th or zero month. */
    {
    	year = y;
    	
    	if (m > 12 || m < 1)
    		throw new IllegalDate212Exception ("Invalid month");
    	month = m;
    	
    	if (d > 31 || d < 1)
    		throw new IllegalDate212Exception ("Invalid day");
    	day = d;
    	
    }
   

    public String toString() 
    /**
     * This is the formatting for how we want the date to be displayed to the GUI. The "this" method allows us to call the other constructor
     * from within this constructor. This was created in the DateList class */
    {
    	return (this.month+"/"+ this.day+"/"+ this.year);
    }
    
    /**
     * @param d is of type Date212. 
     * @return The algebraic difference between two months and feeds them into the compareTo function.
     * This is used in the DateList class to compare the value of the dates by converting them into whole numbers (so a date 2016/10/11
     * becomes 20160000 + 1000 + 11) and then subtracts this from another date which is converted to the same format. Depending on if we want the list in ascending or
     * descending order, we will compare the result to greater than or less than zero and move the node to the appropriate place. 
     */
     
     public int compareTo (Date212 d) 
   
    {
    	return (this.year * 10000 + this.month * 100 + this.day)-(d.year * 10000 + d.month * 100 + d.day);
    }
}