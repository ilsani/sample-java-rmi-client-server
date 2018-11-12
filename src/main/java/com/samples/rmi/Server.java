package com.samples.rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements CommandI {

    public Server() {}

    public String sayHello() {
	return "Hello, world!";
    }

    public void run() {
	try {
	    //Server obj = new Server();
	    //Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

	    CommandI stub = (CommandI) UnicastRemoteObject.exportObject(this, 0);

	    // Bind the remote object's stub in the registry
	    Registry registry = LocateRegistry.createRegistry(9099);
	    //Registry registry = LocateRegistry.getRegistry();
	    registry.bind("CommandI", stub);

	    System.err.println("Server ready");
	} catch (Exception e) {
	    System.err.println("Server exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}
