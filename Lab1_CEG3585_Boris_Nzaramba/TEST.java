import java.util.Arrays;
import java.util.Scanner;

public class TEST {
	
	
	    static public void main(String[] args) { 
	    	String  text ;
	    	 String bonTruc = "" ;
	    
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("please enter the binary code" ) ;
	    	text =   scan.nextLine();
	    	
	     
	    
		 //   boolean previousDigitZero = false;
			boolean previousOnePositive = false;
			StringBuilder encodedString = new StringBuilder(text);
			
			for (int j=0; j<text.length(); j++){
				if(encodedString.charAt(j) == '1'){
					if(previousOnePositive){
						encodedString.setCharAt(j, '-');
					}
					else{
						encodedString.setCharAt(j, '+');
					}

					previousOnePositive = !previousOnePositive;
				//	previousDigitZero = false;
				
					 bonTruc = encodedString.toString() ;
							
						
				}
				for (int i=0; i<text.length() ;){
					
				 
					//System.out.println(text.charAt(i)) ;
					//System.out.println(text.charAt(i+1)) ;
					
				    	if (text.charAt(i)== text.charAt(i+1)){
				    		System.out.println(bonTruc.replace("00000000","000-+0+-") );
				    		
				   
				   
				   break ;
				    	}else {
				    		System.out.println(bonTruc.replace("00000000","000+-0-+") );
				    		
				   break ;
				    	}
				    	
				   }
				   }
				    
		    
	  
	    
	
			} 
	    
	    
	} 


	