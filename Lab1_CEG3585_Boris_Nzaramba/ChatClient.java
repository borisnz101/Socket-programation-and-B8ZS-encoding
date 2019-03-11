

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;


public class ChatClient extends Applet implements Runnable
{
	static boolean bConnected = false;
	
	static ClientSocketManager connection = new ClientSocketManager();
	
	static String sMyId = null;
	
	static String fromServer = null;
    static String fromUser = null;

    static TextField textField;
    static TextArea textArea;
    
    static String sConnection = "Not Connected to the chat server!";
	
	Thread thread;
	
    public void init()
    {
        textField = new TextField("", 50);
        textArea = new TextArea("No Messages",15, 50);
        Button button = new Button("Connect");
        Button closebutton = new Button("Close");
        Button msgbutton = new Button("Send Message");

        add(textField);
        add(button);
        add(closebutton);
        add(msgbutton);
		add(textArea);
    }

    public void paint(Graphics g)
    {
        Font font = new Font("Arial", Font.PLAIN, 12);
        Font fontb = new Font("Arial", Font.BOLD, 14);
        
        g.setFont(fontb);
        
	    g.drawString(sConnection, 60, 330);
        

    }
	//***********************************************
	// trapping button actions
	//
    //***********************************************
    public boolean action(Event evt, Object arg) {
    	String sTemp = null;
    	String sIP = "";
		
		//******************************************
		// close button pressed
		//******************************************
		if (arg == "Close") {
			try {
				if (bConnected)
					connection.close();
			} catch (IOException e) {}
			
			System.exit(0);
		}
		
		//********************************************
		// connect button pressed
		//******************************************
		if (arg == "Connect" && !bConnected) {
					
			try {
				//
				// get server IP and name of client
				//
				sIP = JOptionPane.showInputDialog("Enter IP of chat server:");
				//
				// get client name used for communication to other people
				//
				sMyId = JOptionPane.showInputDialog("Enter your name:");				
				//
				//get port number
				//
				int nPort = 4444; // default 
				nPort = Integer.parseInt(JOptionPane.showInputDialog("Enter port number:"));
				
				//
				// connect to the socket
				//
				connection.connect(sIP, nPort);								
				bConnected = true;
				connection.write(sMyId);
				//
				// set screen messages
				//
				sConnection = "Connected to the chat server!";							
				//
				// define new thread
				//
				thread = new Thread(this);
				thread.start();	
				
			} catch (UnknownHostException e) {
				bConnected = false;
				sConnection = "Not Connected to the chat server!";
				JOptionPane.showMessageDialog(null,"Don't know about host: " + sIP);
			} catch (IOException e) {
				bConnected = false;
				sConnection = "Not Connected to the chat server!";
				JOptionPane.showMessageDialog(null,"Server is not running!"); }		
		}// end of connect button
		
		//*****************************************************	
		// Send Message button pressed
		//*****************************************************	
		if (arg == "Send Message") {
			if (textField.getText() != null){
				//
				// copy content of the message text into 
				// internal buffer for later processing
				// only one message can be stored into the
				// buffer
				//
				fromUser = textField.getText();
				textField.setText("");
				}
			else
				fromUser = null;
			
		}
		
		//
		// repaint the screen
		//           
        repaint();
		
        return true;
    }
    
    
	//************************************************
	// main
	//
	// main application method for the class
	// it will initialize whole environment
	//
	//************************************************
	public static void main(String args[]){
		String sTemp = null;
		//
		// define window and call standard methods
		//
		ChatClient app = new ChatClient();
		Frame frame = new Frame ("Chatter");
		app.init();
		app.start();
		
		frame.add("Center",app);
		frame.resize(400,400);
		frame.show();
	
	}// end of main

	//***********************************
	// stop
	//***********************************
	public void stop() {
		thread.stop();
	}// end of stop

	//***********************************
	// run - thread method
	//***********************************
	public void run() {
		while (bConnected){  // only check server if connected
			//
			// call function to read/write from/to server
			//
			checkServer();
			try {
				//
				// put thread into some delay to 
				// give more cpu time to other processing
				//
				thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		System.out.println("End of run");
		sConnection = "Not Connected to the chat server!";
		repaint();
	}// end of run

	//***********************************
	// checkServer - this is a main client algorithm when connected
	//***********************************
	public static void checkServer(){
	
	String sTemp = null;
	boolean bLoop = true;
	String sFrameType = null;
 
	try {
		//
		// read from the server socket
		//
		if ((fromServer = connection.read()) != null)
		{	
			//
			// simplified frame types: SEL, POL, ACK, NAC
			//
			//
			// determine what type of frame has been received
			// this is a simplified way of doing
			//
			sFrameType = fromServer.substring(0,3);
			
			//
			// received SELECT type of frame
			//
			if (sFrameType.equals("SEL")) {
				fromServer = fromServer.substring(3,fromServer.length());
				sTemp = textArea.getText();
				
				//
				// put message on screen		
				//
				textArea.setText(sTemp + "\n" + fromServer);
			}		
			//
			// if received frame was POLLING
			// and data to be send 
			// return ACK with data
			// otherwise
			// return NACK frame
			//
			if (sFrameType.equals("POL")) {
				//
				// message in stack to be send to the server
				//
				if (fromUser != null){
					connection.write("ACK"+ sMyId + " says: " + fromUser);
					fromUser = null;
				}
				else
					connection.write("NAC");
			}
		}// end of if anything from server
		else 
		{
			// receiving null indicates connection closed
			bConnected = false;
		}
		//
		// trap exceptions while reading/writing from/to server
		//
	    }catch (InterruptedIOException e) { }	
		 catch (IOException e) { }	

	}// end of checkserver
	

} // end of ChatClient
