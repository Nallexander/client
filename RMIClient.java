/*
 * RMI client skeleton 
 */

import java.net.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

class RMIClient extends DISClient {

    static RMICall rmi_call = null;

    /**
     * Method used to perform an RMI call
     * @param input_lg The LabGroup object to be used as
     * input for the RMI call
     * @param server The server where the RMI registry
     * is located
     * @param port The port to call the RMI registry at
     * @return The return string from the RMI call
     */

    public static String runCommand(LabGroup input_lg, String server, int port) {
	try {
	    //Create a Registry with the specified server and port to receive the object from the server
	    Registry reg = LocateRegistry.getRegistry(server, port);
	    //Get the correct method from the object
	    RMICall method = (RMICall) reg.lookup("RMICall");
	    //Use the method on input_lg
	    String output = method.callFunction(input_lg);
	    //Return the string resulting from the method
	    return output;
	    }
	//Catch-clauses for handling exceptions
	catch (RemoteException e){
	    System.err.println("Exception: " + e.toString());
	    e.printStackTrace();
	}
	catch (NotBoundException e){
	    System.err.println("Exception: " + e.toString());
	    e.printStackTrace();
	}
	//Default return, only used when handling an error. 
	return "Error";
    }
}
