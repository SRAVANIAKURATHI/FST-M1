package Activities;

class Car {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;

	public Car() {
		tyres = 4;
		doors = 4;
	}

	public void displayCharacteristics() {
		System.out.println("The color of the car is " + color);
		System.out.println("The transmission of the car is " + transmission);
		System.out.println("The make of the car is " + make);
		System.out.println("The no. of tyres are " + tyres);
		System.out.println("The no. of doors are " + doors);
	}

	public void accelarate() {
		System.out.println("Car is moving forward.");
	}

	public void brake() {
		System.out.println("Car has stopped.");
	}

}

public class Activity1 {

	public static void main(String[] args) {

		Car audi = new Car();
		audi.make = 2014;
		audi.color = "Black";
		audi.transmission = "Manual";

		audi.displayCharacteristics();
		audi.accelarate();
		audi.brake();

	}

}
