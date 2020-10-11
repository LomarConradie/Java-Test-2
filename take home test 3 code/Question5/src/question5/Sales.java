/* DQ61ZP3G5 | Lomar Conradie | ITJA321 | Take Home Test 3 | Question 5 */
package question5;
    import java.rmi.Remote;
    import java.util.*;
/*This is the Sales remote interface that invokes a method to load
the database data into a list.
*/            
public interface Sales extends Remote{
    public List<Province> getProvince() throws Exception;
}
