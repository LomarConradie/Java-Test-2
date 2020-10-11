/* DQ61ZP3G5 | Lomar Conradie | ITJA321 | Take Home Test 3 | Question 5 */
package question5;
    import java.math.BigInteger;
    import java.rmi.registry.LocateRegistry; 
    import java.rmi.registry.Registry; 
    import java.util.*; 
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.JFrame;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/*This is the Client class.
The Client class creates the GUI, table and loads the data
from the table into the GUI table to be displayed.
The registry is obtained and the remote object is looked
up to call its remote methods. After the object methods are
obtained, the Client class builds the GUI and uses a try catch to
obtain the registry details, get records from the databse table
and load it into the GUI table.
*/
public class Client extends JFrame{
   private static Client ClientGui;
   
   private Client(){}
    
  public void GUI()throws Exception{   
    try { 
        JFrame frame = new JFrame("NERSA Sales Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        Registry reg = LocateRegistry.getRegistry(null);
          
        Sales sl = (Sales) reg.lookup("Sales");
          
        String columns[] = {"saleID", "Province", "Litres"};
        
        DefaultTableModel tblmodel = new DefaultTableModel(columns,0);
        JTable tbl = new JTable(tblmodel);
        
        List<Province> list = (List)sl.getProvince();
        for(Province s:list){
         int id = s.getID();
         String province = s.getProvince();
         BigInteger litres = s.getLitres();
         Object[] data = new Object[]{id,province,litres};
         tblmodel.addColumn(data);
        }
        JScrollPane scroll = new JScrollPane(tbl);
        tbl.setFillsViewportHeight(true);
        frame.add(scroll);
    }catch(Exception e){
        System.err.println("Client exception: "+e.toString());
        e.printStackTrace();
    }
  }  
    
   public static void main(String[] args) { 
    SwingUtilities.invokeLater(new Runnable(){
    public void run(){
        ClientGui = new Client();
        try {
            ClientGui.GUI();
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}); 
    }
    
}
