/* DQ61ZP3G5 | Lomar Conradie | ITJA321 | Take Home Test 3 | Question 5 */
package question5;
    import java.math.BigInteger;
/*This is the Province class that implements the serialized interface.
All the methods used obtain the data from the database table and load them
into private variables which are then implemented through getter and setter
methods.
*/
public class Province implements java.io.Serializable{
    private int id;
    private BigInteger litres;
    private String province;
    
    public int getID(){
        return id;
    }
    
    public BigInteger getLitres(){
        return litres;
    }
    
    public String getProvince(){
        return province;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setLitres(BigInteger litres){
        this.litres = litres;
    }
    
    public void setProvince(String province){
        this.province = province;
    }
}
