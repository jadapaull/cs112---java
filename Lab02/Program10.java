public class Program10 {
	static char charFromInt(int n) {
		if (n > 0) {
			return (char) n;
		}
		return 0;
	}

	public static void main(String[] args) {
		
		System.out.print(charFromInt(103));
		System.out.print(charFromInt(121));
		System.out.print(charFromInt(121));
		System.out.print(charFromInt(100));
	}
}