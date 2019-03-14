public class TEST2 {
	
	 static public void main(String[] args) { 
	    	String  text = "+000+-0-+--------" ;
	    	 String bonTruc = "" ;
	    	 
	    
	
				
					
				 
					//System.out.println(text.charAt(i)) ;
					//System.out.println(text.charAt(i+1)) ;
					System.out.println(text);
					System.out.println(text.replace("000+-0-+","00000000") );
					
					bonTruc = text.replace("000+-0-+","00000000") ;
				
				
					
						}
					for (int i=0; i<bonTruc.length() ;i++){
						
				    	if (bonTruc.charAt(i) ==  "+"  ){
				    		
				    	System.out.println(bonTruc.replace("+","1")); 
				    	}	
				    	  break ;
					}
					for (int i=0; i<bonTruc.length() ;i++){
						
				    	 if  ( bonTruc.charAt(i)==  "-" ){
				    		
				    		System.out.println(bonTruc.replace("-","1")); 
				    	}
				    	//else
				    	//	System.out.println(bonTruc);
				 	
				    		
				    	  break ;
				   
				   
					}	} 
				
		
				   
		    
	  
	    
	
			} 
			
