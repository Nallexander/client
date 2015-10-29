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
	    ObjectInputStream receiveFromServer = new ObjectInputStream(socket.getInputStream());
	    System.out.print("Streams created");
	    sendToServer.writeObject(input_lg);
	    oSystem.out.print("Object sent");
	    String output = (String) receiveFromServer.readObject();

	}
	catch (UnknownHostException e){
	    System.err.println("UnknownHostException: " + e.getMessage());
	}
	catch (IOException e) {
	    System.err.println("IOException: " + e.getMessage());
	}
	catch (ClassNotFoundException e){
	    System.err.println("ClassNotFoundException: " + e.getMessage());
	}
	/* TODO: Provide the code to create a socket and
	   connect it to the given port number ("port")
	   at the specified host ("server"). Then send over
	   the given LabGroup object ("input_lg")
	   serialized in the standard Java way and read
	   back an answer (a one line string) from the
	   server. This function (i.e. runCommand) is to
	   return the string that was returned from the
	   server. */

	return "";
    }
}
