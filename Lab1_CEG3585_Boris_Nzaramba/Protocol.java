

public class Protocol{


	public static String encodeBinaryString(String s){
		boolean previousDigitZero = false;
		boolean previousOnePositive = false;
		int zeroCount = 0;
		
		StringBuilder encodedString = new StringBuilder(s);
		
		for (int j=0; j<s.length(); j++){
			if(encodedString.charAt(j) == '1'){
				if(previousOnePositive){
					encodedString.setCharAt(j, '-');
				}
				else{
					encodedString.setCharAt(j, '+');
				}

				previousOnePositive = !previousOnePositive;
				previousDigitZero = false;
				zeroCount = 0;
			}
			else if(encodedString.charAt(j) == '0'){
				zeroCount++;

				if(zeroCount == 8){
					if(previousOnePositive){
						encodedString.setCharAt(j, '+');
						encodedString.setCharAt(j-1, '-');
						encodedString.setCharAt(j-3, '-');
						encodedString.setCharAt(j-4, '+');
					}
					else{
						encodedString.setCharAt(j, '-');
						encodedString.setCharAt(j-1, '+');
						encodedString.setCharAt(j-3, '+');
						encodedString.setCharAt(j-4, '-');
					}

					previousDigitZero = false;
					zeroCount = 0;
				}
				else{
					previousDigitZero = true;
				}
			}
		}
		
		return encodedString.toString();
	}

