import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


/**
 * this class makes a gui and adds strings to a list of stocks
 * 
 * @author (Adam Arato) 
 * @version (April 24)
 */
public class stockGui extends JFrame
{
    ArrayList<String> stock = new ArrayList<String>();
        /**
     * gets a list of existing stocks to add to that list
     */
    public stockGui(ArrayList<String> s){
        stock = s;
    }
    
        /**
     * pulls up a gui that can be used to add stock values to the stock array list
     * 
     * @param none
     * @return  none 
     */
    public void setStock(){
        JFrame frame;
        JPanel panel;
        JButton buttonA, buttonB;
        JLabel label;
        JTextField tf;

        //ArrayList<String> tempStock = new Arraylist();

        setSize(500, 200);
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame = new JFrame();
        panel = new JPanel();
        panel.setSize(200,200);
        panel.setLayout(new GridLayout(3, 2));
        tf = new JTextField();
        tf.setSize(50, 50);

        frame.add(panel);
        //frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton  = new JButton("press this after each stock");
        startButton.setSize(50, 50);
        startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    stock.add(tf.getText());
                    tf.setText("");
                }
            });

        JButton menu = new JButton("Menu");
        menu.setSize(50,50);
        menu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    Gui g = new Gui(getStock());
                    g.menu();
                }
            });

        panel.add(new JLabel("Enter the stock you want"));
        panel.add(tf);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        panel.add(startButton);
        panel.add(menu);
    }

    /**
     * This is the part that actually returns the modified stock list.
     * 
     * @param none
     * @return ArrayList<String> the modified ArrayList of strings with the new stocks 
     */
    public String[] addStock(){
        //setStock();
        if(stock.size() !=0){
            String[] tempStock = new String[stock.size()];
            for(int i = 0; i<stock.size(); i++){
                tempStock[i] = stock.get(i);
            }
            return tempStock;
        }else{
            String[] tempStock = new String[2];
            tempStock[0] = "NO ENTRY";
            return tempStock;
        }
    }
    
        /**
     * Symply used to get the stock arraylist
     * 
     * @param  none
     * @return ArrayList<String> returns the arraylist of stocks 
     */
    public ArrayList<String> getStock(){
        return stock;
    }

}
