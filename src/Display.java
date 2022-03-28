package src;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.FlowLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Display extends ProgramController
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    ImageIcon icon = new ImageIcon("res\\images\\LithiumEditor128x.png");

    public Display(String title, int width, int height)
    {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

        // Prints out Look and Feel options into console
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }

        frame.setIconImage(icon.getImage());

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        frame.setTitle(title);
        frame.add(panel);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                requestClose();
            }
        });
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
