package src;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;


public class Display
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    ImageIcon icon = new ImageIcon("res\\images\\LithiumEditor128x.png");
    GUIHandler guiHandler = new GUIHandler(this);

    public Display(String title, int width, int height)
    {
        frame.setIconImage(icon.getImage());

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        frame.setTitle(title);
        frame.add(panel);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public JFrame getFrame()
    {
        return frame;
    }
}
