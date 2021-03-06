

import java.io.IOException;

public class ChatServer 
{
    public static void main(String[] args) throws IOException 
    {        
        //get port number from the command line
        int nPort = 4444; // default
        if(args.length != 0) nPort = Integer.parseInt(args[0]);
        
        // Create the server socket manager
        ServerSocketManager ssm= new ServerSocketManager(nPort);
        //
        String msgRcv; // for referencing messages received
        // Setup array of strings to receive messages from clients
        String [] msgs = new String[ServerSocketManager.MAXCLIENTS];
        String [] msgsDecoded = new String[ServerSocketManager.MAXCLIENTS];
        int msgIx = 0; // counting messages added to the array
        // Main Loop       
        boolean bListening = true;
        while(bListening)
        {
        	// Accepted Connections
        	int newClientId = ssm.listenOnSocket();  // Times out
        	if(newClientId != -1)
        	{
        	   msgs[msgIx] = ssm.readClient(newClientId)+" joined"; // Expect name to be received
        	   msgIx++;
        	}
        	
        	// Poll for messages received
        	for(int id = 0; id < ServerSocketManager.MAXCLIENTS; id++)
        	{
        		if(ssm.isClosed(id)==false)
        		{
        			ssm.writeClient(id, "POL");
        		}
        	}
        	
        	// Check responses to POL's
        	for(int id = ssm.pollClients(); id != -1; id = ssm.pollClients())
        	{
        			msgRcv = ssm.readClient(id);
        			if(msgRcv != null) // received a string
        			{
            			if(msgRcv.startsWith("ACK"))
            			{
                			System.out.println("Received ACK from "+id);
            				msgs[msgIx] = msgRcv.substring(3);
            				msgIx++;
            			}
            			else if(msgRcv.startsWith("NAC")) /*no msg*/; 
            			else
            				System.out.println("Unknown message ("+id+"): >"+msgRcv+"<");
        			}
        	}
        	
        	for(int mIx = 0; mIx < msgIx ; mIx++) {
        		msgsDecoded[mIx] = decode(msgs[mIx]);
        	}
        	
        	// Distribute received messages to all clients
        	for(int mIx = 0; mIx < msgIx ; mIx++)
        	{
        		String msgSnd = "SEL"+msgs[mIx];
        		String msgSndDecoded = "SEL"+msgsDecoded[mIx];
        		for(int id = 0 ; id < ServerSocketManager.MAXCLIENTS; id++)
        		{
        			if(ssm.isClosed(id) == false)
        			{
        			    ssm.writeClient(id, msgSnd);
        			    ssm.writeClient(id, msgSndDecoded);
        			}
        		}       		
        	}
        	msgIx = 0;  // Reset index to fill array again
        	
        	// Check for closed connections
        	ssm.closeConnections();        	
        }        
    }// end main 
    
    public static String decode(String d) {
		// String text = "+000+-0-+" ;
		// String text = "+000+-0-+000-00" ;
		// String text = "+-000-+0+-+-00000+0";
		// String text = "+-0+00-" ;
		String bonTruc = "";
		String a = "";
		String b = "";
		String c = "";

		// System.out.println(text.charAt(i)) ;
		// System.out.println(text.charAt(i+1)) ;
		// System.out.println(text);

		a = d.replace("000+-0-+", "00000000");
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

		return c;

	}
}
