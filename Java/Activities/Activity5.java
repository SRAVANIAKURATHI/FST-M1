package Activities;

abstract class Book {
	String title;

	abstract void setTitle(String s);

	public String getTitle() {
		return title;
	}

}

class MyBook extends Book {

	@Override
	public void setTitle(String s) {
		title = s;

	}

}

public class Activity5 {
	public static void main(String[] args) {
		String title = "Life and Death";
		MyBook newNovel = new MyBook();
		newNovel.setTitle(title);
		System.out.println("The name of the book is " + newNovel.getTitle());

	}
}