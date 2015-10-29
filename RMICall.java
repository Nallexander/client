/*
 * RMI call interface
 */

import java.rmi.*;
import java.rmi.server.*;

public interface RMICall extends Remote {
    public String callFunction(LabGroup lg)
	throws RemoteException;
}
