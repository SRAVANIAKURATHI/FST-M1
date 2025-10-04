package Activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	public static void main(String[] args) {
		List<String> myList= new ArrayList<>();
		myList.add("Blue");
		myList.add("Amber");
		myList.add("Cola");
		myList.add("Disco");
		myList.add("Emerald");
		for(String i:myList)
		{
			System.out.println(i);
		}
		System.out.println("The third element is "+ myList.get(2));
		
//		Use contains() method to check if a name exists in the ArrayList.
		System.out.println(myList.contains("Black"));
//		Use size() method to print the number of names in the ArrayList.
		System.out.println("The size of the list is "+myList.size());
//		Use remove() method to remove a name from the list and print the size() of the list again.
		myList.remove(4);
		System.out.println("The size after removal is "+ myList.size());
		
	}
		

}
