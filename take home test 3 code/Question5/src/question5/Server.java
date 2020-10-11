/* DQ61ZP3G5 | Lomar Conradie | ITJA321 | Take Home Test 3 | Question 5 */
package question5;
    import java.rmi.Remote;
    import java.rmi.registry.Registry; 
    import java.rmi.registry.LocateRegistry; 
    import java.rmi.server.UnicastRemoteObject; 
/*This is the Server class that extends the implementation class.
IT creates a remote object and registers it on the registry with the bind called
"Sales".
*/
public class Server extends ConnectionImpl{
    
    public Server(){}
    
    public static void main(String[] args) {
        try{
            ConnectionImpl obj = new ConnectionImpl();
            Sales sl = (Sales) UnicastRemoteObject.exportObject((Remote) obj,0);
            Registry reg = LocateRegistry.getRegistry();
            reg.bind("Sales",sl);
            System.err.println("Server is ready");
        }catch(Exception e){
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
