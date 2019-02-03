/**
 * This class is what will be used for the date node, and where each "link" in the linked list will be stored and moved around. It
 * will allow us to insert and move around the dates so they are in order. "next" is set to null as we need something to refer to the next,
 * empty node*/
   

public class DateNode { 

   protected Date212 data;
   protected DateNode next;

/**
 * @param d is a variable of type Date212 and will be used to represent the nodes we will be working with to create the linked lists.
 */
   
   public DateNode (Date212 d)
   {
      data = d;
      next = null;
   }  
}  