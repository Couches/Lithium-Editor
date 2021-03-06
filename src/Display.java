package src;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.Graphics;
import java.awt.Color;


public class Display
{
    public static JFrame frame = new JFrame();

    public static ImageIcon icon32x =  new ImageIcon("res\\images\\LithiumEditor32x.png" );
    public static ImageIcon icon128x = new ImageIcon("res\\images\\LithiumEditor128x.png");
    public static ImageIcon icon256x = new ImageIcon("res\\images\\LithiumEditor256x.png");

    

    public Display(String title, int width, int height)
    {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }

        frame.setIconImage(icon128x.getImage());

        //panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                new ProgramController().requestClose();
            }
        });

        
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public void addElement(JComponent element)
    {
        frame.add(element);
    }
}
