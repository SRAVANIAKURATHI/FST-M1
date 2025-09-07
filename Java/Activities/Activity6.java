package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;

	public Plane(int maxpassengers) {
		passengers = new ArrayList<>();
		this.maxPassengers = maxpassengers;

	}

	public void onboard(String ele) {
		if (passengers.size() < maxPassengers)
			passengers.add(ele);
		else {
			System.out.println("Plane is full");
		}
	}

	public Date takeOff() {
		lastTimeTookOf = new Date();
		return lastTimeTookOf;

	}

	public void land() {
		lastTimeLanded = new Date();
		passengers.clear();
	}

	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}

	public List<String> getPassesngers() {
		return passengers;
	}
}

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		Plane plane = new Plane(10);
		plane.onboard("Priya");
		plane.onboard("Harshith");
		plane.onboard("Kavya");
		plane.onboard("Janith");
		plane.onboard("Kasi");
		System.out.println("Plane take off at " + plane.takeOff());
		System.out.println("Passengers on th plane are "+plane.getPassesngers());
		Thread.sleep(5000);
		plane.land();
		System.out.println("Plane landed at "+plane.getLastTimeLanded());
	}

}
