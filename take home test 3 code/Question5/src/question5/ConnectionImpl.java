/* DQ61ZP3G5 | Lomar Conradie | ITJA321 | Take Home Test 3 | Question 5 */
package question5;
    import java.math.BigInteger;
    import java.sql.*;
    import java.util.*;
/*The ConnectionImpl class implements the Sales interface.
It uses methods to obtain the list from the Sales interface
and then creates an instance of the Province class. This class
also estanblishes the database connection and loads the records
into the setter methods. These are then loaded into a arraylist.
*/
public class ConnectionImpl implements Sales{
    protected BigInteger Litres;
    public List<Province> getProvince() throws Exception{
        List<Province> list = new ArrayList<Province>();
        
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/nersa";
        
        String USER = "root";
        String PASS = "1234";
        
        Connection con = null;
        Statement stmt = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Conneciton to databse is successful.");
        
        stmt = con.createStatement();
        String sql = "SELECT * from provincialsales";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            int id = rs.getInt("saleID");
            String province = rs.getString("province");
            
            Province prov = new Province();
            prov.setID(id);
            prov.setProvince(province);
            prov.setLitres(new BigInteger(Integer.toString(rs.getInt("litres"))));
            list.add(prov);
        }
        rs.close();
        return list;
    }
}
