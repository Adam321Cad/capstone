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
 * rmStock can make a gui and remove stocks from the arrayList stock
 * 
 * @author (Adam Arato) 
 * @version (april 24)
 */
public class rmStock extends JFrame
{
    public ArrayList<String> remStock = new ArrayList<String>();
    public ArrayList<String> stock;
    
    /**
     * just gets all of the stocks here so that this class can remove them
     */
    public rmStock(ArrayList<String> s){
        stock = s;
    }
    
    /**
     * sets up the gui that is used to make an ArrayList of stocks that need to be removed.
     * 
     * @param none
     * @return none
     */
    public void removeStock(){
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
                    remStock.add(tf.getText());
                    tf.setText("");
                }
            });

        JButton menu = new JButton("Menu");
        menu.setSize(50,50);
        menu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    Gui g = new Gui(getrmStock());
                    g.menu();
                }
            });

        panel.add(new JLabel("Enter the stock you want to remove"));
        panel.add(tf);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        panel.add(startButton);
        panel.add(menu);
    }
    
    /**
     * returns the modified arraylist of stocks after removing the stocks selected by the removeStock() method
     * 
     * @param none
     * @return ArrayList<String> returns the modified arraylist of stocks after removing all of stocks that are also in remStock arraylist
     */
    public ArrayList<String> getrmStock(){
        ArrayList<Integer> dex = new ArrayList<Integer>();
        /*
        System.out.println("START");        
        for(int i = 0; i<stock.size(); i++){
            System.out.println(stock.get(i));
        }
        System.out.println("LINE");
        for(int i = 0; i<remStock.size(); i++){
            System.out.println(remStock.get(i));
        }
        System.out.println("LINE");
        */
        for(int i = 0; i<remStock.size(); i++){
            for(int j = 0; j<stock.size(); j++){
                if(remStock.get(i).equals(stock.get(j))){
                    dex.add(j);
                }
            }
        }
        
        for(int i = 0; i<dex.size(); i++){
            int d = dex.get(i);
            stock.remove(d);
            //stock.remove(dex.get(i));
            //stock.remove(0);
        }
        int rmCount = dex.get(0);
        int bla = stock.size();
        /*
        for(int i = 0; i<stock.size(); i++){
            System.out.println(stock.get(i));
        }
        
        for(int i = 0; i<rmStock.size(); i++){
            System.out.println(rmStock.get(i));
        }*/
        
        
        return stock;
    }
    
    
}
