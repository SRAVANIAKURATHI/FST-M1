package Activities;


public class Activity2 {
	
	static int a[]= {10, 77, 10, 54, -11, 10};
	static int sum=0;
	
	public static boolean sum()
	{
		for(int element: a) {
			if (element==10)
				sum=sum+element;
		}
		return sum==30;
	}
	
	
	public static void main(String args[])
	{
		
		System.out.println("Result: "+sum());
		
	}

}
