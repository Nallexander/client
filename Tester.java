/*
 * Class used to test projects
 */

import java.security.NoSuchAlgorithmException;

class Tester {

    public static void main(String[] args) {

	String server = "";
	int socket_port = CommonStuffClient.DEFAULT_SOCKET_PORT;
	int rmi_port = CommonStuffClient.DEFAULT_RMI_PORT;

	if (args.length <= 2) {
	    System.out.println("Usage: java Tester [server name] [socket port] [rmi port]");
	    System.exit(0);
	}

	server = args[0];
	try {
	    socket_port = Integer.parseInt(args[1]);
	    rmi_port = Integer.parseInt(args[2]);
	} catch (NumberFormatException e) {
	    System.out.println("Could not parse given port numbers. Using defaults.");
	}

	/* TODO: Perhaps add a random salt before hashing */
	LabGroup socket_lg = SocketClient.getLabGroup();
	String socket_exp_res = "";
	LabGroup rmi_lg = RMIClient.getLabGroup();
	String rmi_exp_res = "";

	try {
	    socket_exp_res = CommonStuffClient.hashString("Socket: " + socket_lg.toString());
	    rmi_exp_res = CommonStuffClient.hashString("RMI: " + rmi_lg.toString());

	    testSocketClient(server, socket_port, socket_lg, socket_exp_res);
	    testRMIClient(server, rmi_port, rmi_lg, rmi_exp_res);
	} catch (java.security.NoSuchAlgorithmException e) {
	    System.out.println("There was an error. " +
			       "Please contact your lab assistant.");
	}
    }

    private static void testSocketClient(String server, int port, LabGroup input_lg, String exp_response) {
	/* Use socket client to execute the remote command
	   and receive the response*/
	String socket_response = "";

	System.out.println("[Tester] Testing socket client:\n" +
			   "[Tester] Executing remote command...");
	socket_response = SocketClient.runCommand(input_lg, server, port);

	System.out.println("[Tester] Received response: '" + socket_response + "'");
	if (socket_response.equals(exp_response)) {
	    System.out.println("[Tester] This is the expected response.\n" +
			       "[Tester] Congratulations!");
	} else {
	    System.out.println("[Tester] Unfortunately, this is not the expected response.");
	}
    }

    private static void testRMIClient(String server, int port, LabGroup input_lg, String exp_response) {
	String rmi_response = "";

	System.out.println("[Tester] Testing RMI client:\n" +
			   "[Tester] Executing remote command...");
	rmi_response = RMIClient.runCommand(input_lg, server, port);

	System.out.println("[Tester] Received response: '" + rmi_response + "'");
	if (rmi_response.equals(exp_response)) {
	    System.out.println("[Tester] This is the expected response.\n" +
			       "[Tester] Congratulations!");
	} else {
	    System.out.println("[Tester] Unfortunately, this is not the expected response.");
	}
    }
}
