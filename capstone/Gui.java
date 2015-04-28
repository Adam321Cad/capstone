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
 * Has the main gui and menu. It also calles all the other methos in the program
 * 
 * @author (Adam Arato) 
 * @version (April 24)
 */
public class Gui extends JFrame
{
    private static final int FRAME_WIDTH = 150;
    private static final int FRAME_HEIGHT = 150;
    /*
    private JFrame frame;
    private JPanel panel;
    private JButton buttonA, buttonB;
    private JLabel label;
    public JTextField tf;
    public JTextField tf2;
     */

    public String frequency;
    public ArrayList<String> stock;
    private JPanel panel;
    JLabel l = new JLabel("empty");
    stockGui sg;
    rmStock rm; 
    //public stockGui sg = new stockGui();

    /**
     * This contructor is to be used by other guis so that the menu can be brought back up and the arraylist of stocks can keep being passed back here
     */
    public Gui(ArrayList<String> s){
        stock = s;
    }

    /**
     * this contructor is only used by the main class to get the menu up and running
     */
    public Gui(){
        stock = new ArrayList<String>();
    }

    /**
     * this will pull up a menu for my program it sets up the gui and the buttons
     * 
     * 
     * no parameters or return statment
     */
    public void menu(){
        JFrame frame;
        JLabel label;
        JButton buttonA, buttonB, buttonC;

        setSize(500, 200);
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame = new JFrame();
        panel = new JPanel();
        panel.setSize(200,200);
        //i think this makes everything change with the window size
        panel.setLayout(new GridLayout(4, 2));
        frame.add(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonA = new JButton("remove Stock");
        buttonB = new JButton("add Stocks");
        buttonC = new JButton("start program");

        //JButton startButton  = new JButton("Start");
        buttonA.setSize(50, 50);
        buttonB.setSize(50, 50);
        buttonC.setSize(50, 50);
        buttonA.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    rm = new rmStock(stock);
                    rm.removeStock();
                    stock = rm.getrmStock();
                }
            });

        buttonB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    sg = new stockGui(stock);
                    sg.setStock();
                    String[] tempstock = sg.addStock();
                    //sg.visibleStock(false);
                    if(!(tempstock[0].equals("NO ENTRY"))){
                        for(int i = 0; i<tempstock.length; i++){
                            stock.add(tempstock[i]);
                        }
                    }
                    //setVisible(true);
                    //System.out.println(stock.size());
                }
            });

        buttonC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    //Gui g = new Gui();
                    //setVisible(false);
                    start();
                    //frame.dispose();
                }
            });
        panel.add(buttonA);
        panel.add(buttonB);
        panel.add(buttonC);
        //test();
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * used to display the stock info in a JLabel at the botton the gui
     * 
     * @param  ArrayList<String> this takes an array list of strings and ups it in a JLable
     * @return     no return
     */
    public void disp(ArrayList<String> l){
        //JTextField tf = new JTextField();
        //tf.setSize(50, 50);
        //panel.add(tf);
        JLabel label;
        String li = "";
        for(int i = 0; i<l.size(); i++){
            li+= l.get(i);
            li= li+"\n";
        }
        label = new JLabel(li);
        panel.add(label);
        panel.add(label);
        setVisible(false);
        setVisible(true);
        //tf.setText(li);

    }

    /**
     * Just returns and the stocks arraylist
     * 
     * @param  none
     * @return     returns an arraylist of stocks 
     */
    public ArrayList getStock(){
        return stock;
    }

    /**
     * starts the webprog class, this will get all of the information that the gui has collected and send it to the webscraper.
     * 
     * @param  none
     * @return none
     */
    public void start(){
        String url = "http://finance.yahoo.com/q?uhb=uh3_finance_vert&fr=&type=2button&s=GOOG%2C";
        webProg d = new webProg(url);
        //ArrayList<String> test = getStock();
        //int ae = sg.getStock().size();

        for(int i = 0; i<stock.size(); i++){
            int count = 0;
            for(int j = 0; j<stock.size();j++){
                if(stock.get(i).equals(stock.get(j))){
                    count++;
                }
            }
            if(count>1){
                stock.remove(i);
            }
        }

        int ae = stock.size();

        ArrayList<String> l = d.action3(stock);
        disp(l);
    }

    /*
    public class ClickListener implements ActionListener
    {
    public void actionPerformed(ActionEvent event)
    {
    label.setText("Button "+event.getActionCommand() +" was clicked");
    }

    }*/

}