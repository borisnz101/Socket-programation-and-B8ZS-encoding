
public class TEST2 {

	static public void main(String[] args) {
		// String text = "+000+-0-+" ;
		// String text = "+000+-0-+000-00" ;
		String text = "+-000-+0+-+-00000+0";
		// String text = "+-0+00-" ;
		String bonTruc = "";
		String a = "";
		String b = "";
		String c = "";

		// System.out.println(text.charAt(i)) ;
		// System.out.println(text.charAt(i+1)) ;
		// System.out.println(text);

		a = text.replace("000+-0-+", "00000000");
		// System.out.println("a est :"+a);
		bonTruc = a.replace("000-+0+-", "00000000");
		// System.out.println("bon truc est :"+bonTruc);

		for (int i = 0; i < bonTruc.length(); i++) {

			// if (bonTruc.charAt(i) == '+' & bonTruc.charAt(i)== '-' ){
			b = bonTruc.replace("+", "1");
			c = b.replace("-", "1");

			// }

			// }
			// for (int i=0; i<b.length() ;i++){

			// if (b.charAt(i)== '-' ){
			// c =b.replace("-","1") ;

			// }

		}
		// System.out.println(bonTruc.replace("+","1"));
		System.out.println(c);

	}

}
