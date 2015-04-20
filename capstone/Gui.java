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
    public Gui(){
        setSize(500, 1000);
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame = new JFrame();
        panel = new JPanel();
        panel.setSize(500,200);
        panel.setLayout(new GridLayout(3, 1));
        JTextField tf = new JTextField();
        tf.setSize(400, 400);
        panel.add(tf);
        tf.setSize(400, 400);
        //JTextArea textArea = new JTextArea(5,20);
        panel.add(tf);
        //ActionListener listener = new ClickListener();
        //label = new JLabel("no button clicked");
        //panel.add(label);
        frame.add(panel);
        //frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
