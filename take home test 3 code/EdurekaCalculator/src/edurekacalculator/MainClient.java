/*Lomar Conradie | DQ61ZP3G5 | Take Home Test 3 | ITJA321 | Question 4*/
package edurekacalculator;
    import java.awt.GridBagConstraints;
    import java.awt.GridBagLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.net.MalformedURLException;
    import java.rmi.*;
    import javax.swing.JButton;
    import javax.swing.JComboBox;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JTextField;
    import javax.swing.SwingUtilities;
//the MainClient class extends into a GUI frame and implements actionlisteners to determine if the button was clicked 
public class MainClient extends JFrame implements ActionListener{
    private static MainClient ClientGui;
    public static JButton calc_btn;
    public static JTextField number1_txt, number2_txt;
    public static JComboBox symbol_txt;
    public static JLabel answer_txt;
//this method is used to invoke the GUI and build it    
    public void CreateNDisplay(){ 
        JFrame frame = new JFrame("Edureka Calculator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel app_lbl = new JLabel("Edureka Calculator App v1.0    ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainpanel.add(app_lbl,c);
        
        JLabel developer_lbl = new JLabel("Developer: L.U Conradie");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        mainpanel.add(developer_lbl, c);

        JLabel number1_lbl = new JLabel("Input 1st Number:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        mainpanel.add(number1_lbl, c);
        
        JTextField number1_txt = new JTextField("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        mainpanel.add(number1_txt, c);   
        
        JLabel symbol_lbl = new JLabel("Choose Symbol:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        mainpanel.add(symbol_lbl, c);
        
        String[] symbols = new String[] {"+","-","/","*"};
        JComboBox<String> symbol_txt = new JComboBox<>(symbols);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        mainpanel.add(symbol_txt, c);

        JLabel number2_lbl = new JLabel("Input 2nd Number:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        mainpanel.add(number2_lbl, c);
        
        JTextField number2_txt = new JTextField("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        mainpanel.add(number2_txt, c);

        JButton calc_btn = new JButton("Calculate");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        mainpanel.add(calc_btn, c);
        
        JLabel answer_txt = new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        mainpanel.add(answer_txt, c);
        
        frame.add(mainpanel);
    }
    //this is the main method of the program. It may throw specific RMI exceptions
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException{
        //this method calls the GUI method and runs the code to build the interface
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){                
                ClientGui = new MainClient();
                ClientGui.CreateNDisplay();
            }});
        //this is the actionlistener for the Calc_btn click
        calc_btn.addActionListener((ActionEvent e) -> {
        //the symbols in the combobox are loaded into a string
            String getSymbol = (String) symbol_txt.getSelectedItem();
        //if statement to check if text boxes are empty
            if((("".equals(number1_txt.getText()))&&("".equals(number2_txt.getText())))||(("".equals(number1_txt.getText()))||("".equals(number2_txt.getText())))){
        //error message that says the text boxes may not be empty        
                JOptionPane.showMessageDialog(null,"Please Enter Numbers First","Error",JOptionPane.ERROR_MESSAGE);
            }else{
        //loading the text box data into integers        
                int number1 = Integer.parseInt(number1_txt.getText());
                int number2 = Integer.parseInt(number2_txt.getText());
        //try catch for the RMI and method invocations from the object interface in the registry        
                try {
        //accessing the registry and obtaining the methods used to calculate the input            
                    Calculate c = (Calculate)Naming.lookup("//127.0.0.1:1099/Calculate");
        //if the user chose the addition symbol            
                    if(getSymbol == "+"){
                        int result = c.add(number1, number2);
                        answer_txt.setText(Integer.toString(result));
        //if the user chose the subtraction symbol                
                    }else if(getSymbol == "-"){
                         int result = c.subtract(number1, number2);
                        answer_txt.setText(Integer.toString(result));
        //if the user chose the division symbol                
                    }else if(getSymbol == "/"){
                        int result = c.divide(number1, number2);
                        answer_txt.setText(Integer.toString(result));
        //if the user chose the multiplication symbol                
                    }else if(getSymbol == "*"){
                        int result = c.multiply(number1, number2);
                        answer_txt.setText(Integer.toString(result));                        
                    }
                }catch(Exception b){
                    System.out.println("Exception: "+b);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
