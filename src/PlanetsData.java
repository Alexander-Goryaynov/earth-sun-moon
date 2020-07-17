import java.util.ArrayList;

public class PlanetsData {

	private int sunX;
	private int sunY;
	private int earthX;
	private int earthY;
	private int moonX;
	private int moonY;
	private ArrayList<Integer> moonTraectory;
	private static final int earthR = 200;
	private static final int earthExcentricity = 2;
	private static final int moonR = 20;
	// angles (radian)
	private double earthAngle = 0;
	private double moonAngle = 0;
	// angular velocity
	private double earthAngularVelocity = 0.01;
	private double moonAngularVelocity = 0.16;
	// perihelion and aphelion imitation 
	private int earthDelta = 100;
	private int moonDelta = 5;
	
	public PlanetsData() {
		sunX = 300;
		sunY = 150;
		earthX = sunX + earthR + earthDelta;
		earthY = sunY;
		moonX = earthX + moonR + moonDelta;
		moonY = earthY;
		moonTraectory = new ArrayList<>();
	}
	
	public void movePlanets() {
		earthAngle += earthAngularVelocity;
		// full circle
		if (earthAngle >= 2 * Math.PI) {
			earthAngle = 0;
		}
		recalculateEarthCoords(earthAngle);;
		moonAngle += moonAngularVelocity;
		// full circle
		if (moonAngle >= 2 * Math.PI) {
			moonAngle = 0;
		}
		recalculateMoonCoords(moonAngle);
		if (moonTraectory.size() >= 100000) {
			moonTraectory.clear();
		}
		moonTraectory.add(moonX);
		moonTraectory.add(moonY);
	}
	
	public void recalculateEarthCoords(double earthAngle) {
		earthX = sunX + (int)(earthR * Math.cos(earthAngle)) + earthDelta;
		earthY = sunY + (int)(earthR / earthExcentricity * Math.sin(earthAngle));
	}
	
	public void recalculateMoonCoords(double moonAngle) {
		moonX = earthX + (int)(moonR * Math.cos(moonAngle)) + moonDelta;
		moonY = earthY + (int)(moonR * Math.sin(moonAngle));
	}
	
	public int getSunX() {
		return sunX;
	}

	public int getSunY() {
		return sunY;
	}

	public int getEarthX() {
		return earthX;
	}

	public int getEarthY() {
		return earthY;
	}

	public int getMoonX() {
		return moonX;
	}

	public int getMoonY() {
		return moonY;
	}

	public ArrayList<Integer> getMoonTraectory() {
		return moonTraectory;
	}

	public double getEarthAngle() {
		return earthAngle;
	}
	
}
