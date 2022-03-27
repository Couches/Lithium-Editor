package src;

import javax.swing.UIManager;

public class Main
{
    private static final int WINDOW_WIDTH = 1080;
    private static final int WINDOW_HEIGHT = 720;

    public static void main(String[] args)
    {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

        // Prints out Look and Feel options into console
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }

        try {
  
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }

        Display display = new Display("Lithium Editor", WINDOW_WIDTH, WINDOW_HEIGHT);
    }    
}
