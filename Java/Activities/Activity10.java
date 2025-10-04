package Activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {
	public static void main(String[] args) {
		Set<Object> hs=new HashSet<>();
		hs.add("raga");
		hs.add('i');
		hs.add(6);
		hs.add(3.24);
		hs.add("Black");
		hs.add(34325);
		for(Object ele:hs)
		{
			System.out.println(ele);
		}
		
		//print the size of the HashSet using the size() method.
		System.out.println("The size of the set is "+hs.size());
		
		//Remove an element using the remove() method.
		System.out.println(hs.remove("Black"));
		
		//remove an element that is not present in the Set.
		System.out.println(hs.remove('o'));
		
		//contains() method to check if an item is in the Set or not
		System.out.println("Is this present in the set "+hs.contains("blue"));
		
		//Print the updated set
		for(Object ele:hs)
		{
			System.out.println(ele);
		}
		
		
	}

}
