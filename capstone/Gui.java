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
    public ArrayList<String> stock = new ArrayList<String>();
    JLabel l = new JLabel("empty");
    public stockGui sg = new stockGui();

    public void menu(){
        JFrame frame;
        JPanel panel;
        JLabel label;
        JButton buttonA, buttonB, buttonC;

        setSize(500, 200);
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame = new JFrame();
        panel = new JPanel();
        panel.setSize(200,200);
        //i think this makes everything change with the window size
        panel.setLayout(new GridLayout(3, 2));
        frame.add(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonA = new JButton("frequency");
        buttonB = new JButton("stocks");
        buttonC = new JButton("start program");

        //JButton startButton  = new JButton("Start");
        buttonA.setSize(50, 50);
        buttonB.setSize(50, 50);
        buttonC.setSize(50, 50);
        buttonA.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    setFrequency();
                    //frame.dispose();
                    setVisible(false);
                }
            });

        buttonB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    sg.setStock();
                    String[] tempstock = sg.addStock();
                    //sg.visibleStock(false);
                    if(!(tempstock[0].equals("NO ENTRY"))){
                        for(int i = 0; i<tempstock.length; i++){
                            stock.add(tempstock[i]);
                        }
                    }
                    setVisible(true);
                    //System.out.println(stock.size());
                }
            });

        buttonC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    //Gui g = new Gui();
                    setVisible(false);
                    start();
                    //frame.dispose();
                }
            });
        panel.add(buttonA);
        panel.add(buttonB);
        panel.add(buttonC);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void setFrequency(){
        JFrame frame;
        JPanel panel;
        JButton buttonA, buttonB;
        JLabel label;
        final JTextField tf;

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

        JButton startButton  = new JButton("Enter");
        startButton.setSize(50, 50);
        startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Gui g = new Gui();
                    changeFrequency(tf.getText());
                    //g.changeLabel("enter a new frequency if you want to change");
                    //panel.add(l);
                }
            });

        JButton menu = new JButton("Menu");
        menu.setSize(50,50);
        menu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Gui g = new Gui();
                    g.menu();
                    setVisible(false);
                }
            });
        String lable = "Enter the Frequency you want";
        l = new JLabel(lable);
        panel.add(l);
        panel.add(tf);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        panel.add(startButton);
        panel.add(menu);
    }

    public void changeFrequency(String f){
        frequency = f;
    }

    public void addStock(String s){
        stock.add(s);
    }

    //not used right now
    public void changeLabel(String l1){
        l=new JLabel(l1);
    }

    public String getFrequency(){
        return frequency;
    }

    public ArrayList getStock(){
        return stock;
    }

    public void start(){
        String url = "http://finance.yahoo.com/q?uhb=uh3_finance_vert&fr=&type=2button&s=GOOG%2C";
        webProg d = new webProg(url);
        //ArrayList<String> test = getStock();
        int ae = sg.getStock().size();
        d.action3(sg.getStock());
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