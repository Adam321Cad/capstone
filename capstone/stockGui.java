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

public class stockGui extends JFrame
{
    ArrayList<String> stock = new ArrayList<String>();
    public void setStock(){
        JFrame frame;
        JPanel panel;
        JButton buttonA, buttonB;
        JLabel label;
        final JTextField tf;

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
                }
            });

        JButton menu = new JButton("Menu");
        menu.setSize(50,50);
        menu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                }
            });

        panel.add(new JLabel("Enter the stock you want"));
        panel.add(tf);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        panel.add(startButton);
        panel.add(menu);
    }
    
    public void visibleStock(boolean c){
        setVisible(c);
    }

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
    
    public ArrayList<String> getStock(){
        return stock;
    }

}
