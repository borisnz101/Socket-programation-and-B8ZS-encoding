
	
	public class TEST2 {

static String text = "+-000-+0+-+-00000+0" ;

static String bonTruc = "" ;

static String bonTruc1 = "" ;

　

static public void main(String[] args) {

//System.out.println(text.charAt(i)) ;

//System.out.println(text.charAt(i+1)) ;

System.out.println(text);

System.out.println(text.replace("000+-0-+","00000000") );

bonTruc = text.replace("000+-0-+","00000000") ;

System.out.println(containsChar(bonTruc, '-'));

bonTruc1 = containsChar(bonTruc, '-') ;

System.out.println("-------------------------") ;

System.out.println(replacesign (bonTruc1 ) );

}

public static String replacesign (String s ) {

String good = "" ;

for (int i=0; i<s.length() ;){

if (s.charAt(i) == '+' ){

//System.out.println(s.replace("+","1"));

good= s.replace("+","1") ;

}

break ;

}

return good;

}

　

　

public static String containsChar(String s, char search) {

String good = "" ;

for (int i=0; i<s.length() ;i++){

//	System.out.println(s.charAt(i)) ;

//i++ ;

try {

if (s.charAt(i) == '-') {

//System.out.println(s.replace("-","1"));

good = s.replace("-","1") ;

}}

catch (IndexOutOfBoundsException e) {

// this should never happen...

}

}

return good;

　

　
　

　

}

//if (s.charAt(i) == '+') {

//System.out.println(s.replace("+","1"));

//good = s.replace("+","1") ;

}

