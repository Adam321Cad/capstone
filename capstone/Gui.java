import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui
{
    private static final int FRAME_WIDTH = 150;
    private static final int FRAME_HEIGHT = 150;
    
    private JFrame frame;
    private JPanel panel;
    private JButton buttonA, buttonB;
    private JLabel label;
    public Gui()
    {
        frame = new JFrame();
        panel = new JPanel();
        //buttonA = new JButton("A");
        //buttonB = new JButton("B");
        //panel.add(buttonA);
        //panel.add(buttonB);
        JTextField tf = new JTextField();
        panel.add(tf);
        //label = new JLabel("no button clicked");
        //panel.add(label);
/*
        frame.add(panel);

        ActionListener listener = new ClickListener();
        buttonA.addActionListener(listener);
        buttonB.addActionListener(listener);
*/
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void main(){
        
    }

}
