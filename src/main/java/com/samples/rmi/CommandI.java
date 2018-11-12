package com.samples.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface CommandI extends Remote {
    String sayHello() throws RemoteException;
}
