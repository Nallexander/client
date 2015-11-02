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
	    Registry reg = LocateRegistry.getRegistry(server, port);
	    RMICall method = (RMICall) reg.lookup("RMICall");
	    String output = method.callFunction(input_lg);
	    return output;
	    }
	catch (RemoteException e){
	    System.err.println("Exception: " + e.toString());
	    e.printStackTrace();
	}
	catch (NotBoundException e){
	    System.err.println("Exception: " + e.toString());
	    e.printStackTrace();
	}
	
	
	/* TODO: Provide the code to perform an RMI call
	   to the method named "callFunction" (without the
	   quotes) of the interface "RMICall". The method
	   has the following signature:

	   public String callFunction(LabGroup lg);

	   The remote object is to be located using an RMI
	   registry at the server and port which are given
	   as input to this method (i.e. runCommand).
	   When the remote method is called, the given
	   input_lg LabGroup object is to be used as input.
	   This method (i.e. runCommand) is to return the
	   string that was returned from th
	*/
	return "";
    }
}
