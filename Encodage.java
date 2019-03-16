import java.util.Arrays;
import java.util.Scanner;

public class Encodage {

		
	public static String encode(String s) {
		
		String s;
		String txtEncoded = "";

		/*Scanner scan = new Scanner(System.in);
		System.out.println("please enter the binary code");
		text = scan.nextLine();*/

		// boolean previousDigitZero = false;
		boolean previousOnePositive = false;
		StringBuilder encodedString = new StringBuilder(s);

		for (int j = 0; j < s.length(); j++) {
			if (encodedString.charAt(j) == '1') {
				if (previousOnePositive) {
					encodedString.setCharAt(j, '-');
				} else {
					encodedString.setCharAt(j, '+');
				}

				previousOnePositive = !previousOnePositive;
				// previousDigitZero = false;

				txtEncoded = encodedString.toString();

			}
			for (int i = 0; i < s.length();) {

				// System.out.println(text.charAt(i)) ;
				// System.out.println(text.charAt(i+1)) ;

				if (s.charAt(i) == s.charAt(i + 1)) {
					System.out.println(txtEncoded.replace("00000000", "000-+0+-"));

					break;
				} else {
					System.out.println(txtEncoded.replace("00000000", "000+-0-+"));

					break;
				}

			}
		}

	} return txtEncoded;
}

