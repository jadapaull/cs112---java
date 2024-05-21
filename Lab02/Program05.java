public class Program05 {
	public static void main(String[] args) {
		int radius = 5; // 5 centimeters
		int height = 10 ;//centimeters
		double baseArea = 3.1415 *(radius * radius);
		double coneVolume = (baseArea * height)/3 ;
		System.out.println("The volume of our cone is " + coneVolume);
	}
}