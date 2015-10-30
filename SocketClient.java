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
	    Socket socket = new Socket(server, port);
	    ObjectOutputStream sendToServer = new ObjectOutputStream(socket.getOutputStream());
	    BufferedReader receiveFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
	    sendToServer.writeObject(input_lg);
	    String output = receiveFromServer.readLine();
	    return output;
	}
	catch (UnknownHostException e){
	    System.err.println("UnknownHostException: " + e.getMessage());
	}
	catch (IOException e) {
	    System.err.println("IOException: " + e.getMessage());
	}
	return "";

    }
}
