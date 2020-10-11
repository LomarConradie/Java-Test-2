/*Lomar Conradie | DQ61ZP3G5 | Take Home Test 3 | ITJA321 | Question 4*/
package edurekacalculator;
    import java.rmi.*;
//this is the server object interface called Calculate that decalres the four arithmetic calculation methods
public interface Calculate extends Remote{
    //addition mehtod
    public int add (int num1, int num2) throws RemoteException;
    //subtraction method
    public int subtract (int num1, int num2) throws RemoteException;
    //division method
    public int divide (int num1, int num2) throws RemoteException;
    //multiplication method
    public int multiply (int num1, int num2) throws RemoteException;
}