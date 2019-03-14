public class TEST2 {
	
	 static public void main(String[] args) { 
	    	String  text = "+000+-0-+--------" ;
	    	 String bonTruc = "" ;
	    	 
	    
	
				
					
				 
					//System.out.println(text.charAt(i)) ;
					//System.out.println(text.charAt(i+1)) ;
					System.out.println(text);
					System.out.println(text.replace("000+-0-+","00000000") );
					
					bonTruc = text.replace("000+-0-+","00000000") ;
				
					//Create a string array to store the names of your friends
					
					String array[] = bonTruc.split("");
						for (int i = 0; i < array.length; i++) {
						
							System.out.print(array[i]);
						     //   arrayOfDigit[i] = scan.nextLine();
					
						}
					for (int i=0; i<bonTruc.length() ;i++){
						
				    	if (array[i] ==  "+"  ){
				    		
				    	System.out.println(bonTruc.replace("+","1")); 
				    	}	
				    	  break ;
					}
					for (int i=0; i<bonTruc.length() ;i++){
						
				    	 if  ( array[i] ==  "-" ){
				    		
				    		System.out.println(bonTruc.replace("-","1")); 
				    	}
				    	//else
				    	//	System.out.println(bonTruc);
				 	
				    		
				    	  break ;
				   
				   
					}	} 
				
		
				   
		    
	  
	    
	
			} 
			
