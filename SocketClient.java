/*
 * Socket client skeleton
 */

import java.net.*;
import java.io.*;

class SocketClient extends DISClient {

    /**
     * Method used to perform a "socket call"
     * @param input_lg The LabGroup object to be used as
     * data for the "socket call"
     * @param server The server to connect to
     * @param port The port to connect on
     * @return The return string from the "socket call"
     */
    public static String runCommand(LabGroup input_lg, String server, int port) {
	System.out.print("in runCommand");
	try{
	    // Create socket, input- and output stream to be used for sending and receiving data to and from the server.
	    Socket socket = new Socket(server, port);
	    ObjectOutputStream sendToServer = new ObjectOutputStream(socket.getOutputStream());
	    BufferedReader receiveFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
	    //Send input_lg to server
	    sendToServer.writeObject(input_lg);
	    //Receive response from server
	    String output = receiveFromServer.readLine();
	    //Return the response
	    return output;
	}
	//Catch-clauses for handling exceptions
	catch (UnknownHostException e){
	    System.err.println("Exception: " + e.toString());
	    e.printStackTrace();
	}
	catch (IOException e) {
	    System.err.println("Exception: " + e.toString());
	    e.printStackTrace();
	}
	//Default return, only used when handling an error. 
	return "Error";

    }
}
