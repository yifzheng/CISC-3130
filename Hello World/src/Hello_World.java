
public class Hello_World {
	public static void main(String[] args) {
		String str = "Hello World!"; // declares a string Hello World!
		for (int i = 0; i < str.length(); i++) { // sets a loop for the length of the string times
			System.out.println(printStr(str, i)); // uses the method printStr() to print a part of the String until it prints the full String
		}
		for (int j = str.length() - 2; j > -1; j--){ // loops for str.length() - 1 times
			System.out.println(printStr(str, j)); // prints the String in parts in reverse
		}
	}
	public static String printStr(String s, int x) { // a method to return a string with x number of characters
		if (x == 0) {
			return "" + s.charAt(0); // if x is 0, returns the character at index 0
		}
		else {
			return s.charAt(0) + printStr(s.substring(1), x - 1); // returns the character at index 0 and calls the method again with a new String where the character at the previous index 0 is gone
		}
	}
}
