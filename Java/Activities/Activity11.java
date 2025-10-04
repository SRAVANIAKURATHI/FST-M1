package Activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
	public static void main(String[] args) {
		Map<Integer, String> colours = new HashMap<>();
		colours.put(1, "Blue");
		colours.put(5, "Black");
		colours.put(8, "Brown");
		colours.put(35, "Beige");
		colours.put(54, "Burgundy");
		
		System.out.println("The Original map: " + colours);

		// Remove one colour using the remove() method
		colours.remove(8);

		//Check if the colour green exists in the Map using the containsValue() method
		System.out.println("Does green colour exist in map: " + colours.containsValue("green"));
		
		//Print the size of the Map using the size() method.
		System.out.println("the size of the Hashmap is " + colours.size());

	}

}
