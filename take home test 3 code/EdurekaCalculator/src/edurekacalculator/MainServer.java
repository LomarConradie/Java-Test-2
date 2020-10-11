/*Lomar Conradie | DQ61ZP3G5 | Take Home Test 3 | ITJA321 | Question 4*/
package edurekacalculator;
    import java.rmi.Naming;

public class MainServer{
    //main server class and the methods used to invoke the object interface methods
    MainServer(){
    //try catch to ensure exceptions do not occur at runtime    
        try{
            Calculate c = new Calculator();
            Naming.rebind("rmi://localhost:1099/Calculate",c);
        }catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new MainServer();
        System.out.println("Server is ready");
    }
}
