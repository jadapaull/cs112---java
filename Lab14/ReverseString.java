// This program inputs a string from args[0], reverses it,
// and prints out the result.

class ReverseString {
	// Reverse the chars in 'input' and return the result.
	static String StringToCharsReverse(String input) {
		char output[] = new char[input.length()];
		int i = input.length();
		while (i > 0) {
			output[input.length()-i] = input.charAt(i-1);
			i=i-1;

			System.out.println(output);
		}
		return new String(output);
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("ERROR: need input arg");
			return;
		}
		String input = args[0];	//"It was the best of times, it was the worst of times." 
		System.out.println(StringToCharsReverse(input));
	}
}