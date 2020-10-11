/*Lomar Conradie | DQ61ZP3G5 | Take Home Test 3 | ITJA321 | Question 4*/
package edurekacalculator;
    import java.rmi.RemoteException;
    import java.rmi.server.UnicastRemoteObject;
//this is the Calculator class that invokes the methods of the Calculate interface
public class Calculator extends UnicastRemoteObject implements Calculate{
    //constructor of the Calculator class that uses super() to call the parent class
    protected Calculator() throws RemoteException{
        super();
    }
    //these are the methods that are invoked in the calculate interface
    public int add (int num1, int num2) throws RemoteException{
        return num1 + num2;
    }
    
    public int subtract (int num1, int num2) throws RemoteException{
        return num1 - num2;
    }
    
    public int divide (int num1, int num2) throws RemoteException{
        return num1 / num2;
    }
    
    public int multiply (int num1, int num2) throws RemoteException{
        return num1 * num2;
    }
}
