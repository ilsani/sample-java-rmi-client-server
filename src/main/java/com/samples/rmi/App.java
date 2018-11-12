package com.samples.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

// java -Djava.security.policy=client.policy -jar target/rmi-client-1.0-SNAPSHOT.jar
    
public class App  {
    
    public static void main( String[] args ) {
        System.out.println( "[CLIENT] Running ..." );
	App app = new App();
	app.run();
    }

    public void run() {
	Server server = new Server();
	server.run();
	createRMILookup();
    }

    private void createRMILookup() {
	try {

	    if (System.getSecurityManager() == null) {
		System.setSecurityManager(new SecurityManager());
	    }
	    
	    String serverHost = "127.0.0.1";
	    String serverPort = "9099";
	    String name = "//" + serverHost + ":" + serverPort + "/" + "CommandI";
	    CommandI cmd = (CommandI)Naming.lookup(name);
	    String result = cmd.sayHello();
	    System.out.println(result);
	} catch (Exception ex) {
	    System.out.println(ex);
	}
    }
    
}
