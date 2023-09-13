package studio2;

public class Pi {

	public static void main(String[] args) {

		double xLocation = Math.random() * 2 * Math.PI;
		double yLocation = Math.random() * 2 * Math.PI;
		
		double X = Math.cos(xLocation);
		double Y = Math.sin(yLocation);
		
		System.out.println("The dart landed at (" + X + "," + Y + ") on the board");
	}

}
