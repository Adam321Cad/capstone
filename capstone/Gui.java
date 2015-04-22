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

public class Gui extends JFrame
{
    private static final int FRAME_WIDTH = 150;
    private static final int FRAME_HEIGHT = 150;

    private JFrame frame;
    private JPanel panel;
    private JButton buttonA, buttonB;
    private JLabel label;
    public JTextField tf;
    public JTextField tf2;
    public int frequency;
    public String[] stock;
    public Gui(){
        setSize(500, 200);
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame = new JFrame();
        panel = new JPanel();
        panel.setSize(200,200);
        //i think this makes everything change with the window size
        panel.setLayout(new GridLayout(3, 2));
        tf = new JTextField();
        tf2 = new JTextField();
        tf2.setSize(50,50);
        tf.setSize(50, 50);
        
        //JTextArea textArea = new JTextArea(5,20);
        
        //ActionListener listener = new ClickListener();
        //label = new JLabel("no button clicked");
        //panel.add(label);
        frame.add(panel);
        //frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton startButton  = new JButton("Start");
        startButton.setSize(50, 50);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println(tf.getText());
            }
        });
        panel.add(new JLabel("Enter the stocks you want"));
        panel.add(tf);
        panel.add(new JLabel("Enter the frequency you want the resaults"));
        panel.add(tf2);
        panel.add(startButton);
        this.add(panel, BorderLayout.CENTER);
        setVisible(true);
        
        //frame.setVisible(true);
        System.out.println(tf.getText());
    }

    public void main(){

    }
    
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            label.setText("Button "+event.getActionCommand() +" was clicked");
        }

    }

}