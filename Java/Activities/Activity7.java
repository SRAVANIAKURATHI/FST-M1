package Activities;

interface BicycleParts {
	public int tyres = 2;
	public int maxSpeed = 40;
}

interface BicycleOperations {
	public void applyBrake(int decrement);

	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {

	int gears;
	int currentspeed;

	public Bicycle(int gears, int currentspeed) {
		this.gears = gears;
		this.currentspeed = currentspeed;
	}

	public void applyBrake(int decrement) {
		System.out.println("Speed reduced to " + (currentspeed - decrement));
	}

	@Override
	public void speedUp(int increment) {
		System.out.println("Speed increased to " + (currentspeed + increment));
	}

	public String bicycleDesc() {
		return ("No of gears are " + gears + "\nSpeed of bicycle is " + maxSpeed);
	}
}

class MountainBike extends Bicycle {
	int seatheight;

	public MountainBike(int seatheight, int gears, int currentspeed) {
		super(gears, currentspeed);
		this.seatheight = seatheight;

	}
	public void setHeight(int newValue) {
	    seatheight = newValue;
	}
	public String bicycleDesc() {
		return (super.bicycleDesc()+ "\nSeat Height of bicycle is " + seatheight);
	}
	
}

public class Activity7 {

	public static void main(String[] args) {
		MountainBike mb=new MountainBike(2, 3, 25);
		System.out.println(mb.bicycleDesc());
		mb.applyBrake(10);
		mb.speedUp(20);

	}

}
