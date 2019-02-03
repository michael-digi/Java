public abstract class DateList {
	
	public DateNode first = new DateNode (null); //From our DateNode class we created
	public DateNode last = first; //First is equal to null (empty dummy node), therefore both first and last are empty currently
    public int length = 0; //Entire list is empty
    
  /**
   * @return length to the getLength method
   */
    
    public int getLength() 
    {
		return length;
	}
 
  /**
   * @param d is of type Date212
   * This simply adds to the linked list in a way that is unsorted, and sequential to how it is read from the file. It is saying to
   * add another node to the end of the list, if there are still more to add.
   */
    
    public void append (Date212 d) 
    {
		DateNode n = new DateNode(d);
		
		last.next = n;
		last = n;
		length++;
	}
    
   /**
    * @param d is of type Date212
    * The insert method will be more complicated, and call on our compareTo method from our Date212 class to compare each date and insert
    * them into the list in proper order. If the list is empty it simply returns and does nothing.
    */
   
    public void insert (Date212 d) 
    {
	   // if list empty just return
	  if (first.next == null)
	  {
		    append(d);
		    return;  
	   }
	   
	   
	   DateNode n = new DateNode(d);
	   DateNode h = first;
	   
	   while (h.next != null && n.data.compareTo(h.next.data) > 0 ) 
 
   /** 
    * While list is not empty and new node is greater than previous node, move the node up and insert new
    * node 
    */
	   {
		   h=h.next;
	   }
	   
	   if (h.next == null)
	   {
		   append(d);
		   return;
	   }
	   
	   n.next = h.next;
	   h.next = n;
	   length++;
   }
   
    public String toString () 
    {
		DateNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + "\n ";
			p = p.next;
		}
		return returnString;
	}
	   
}