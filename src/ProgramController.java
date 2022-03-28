package src;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class ProgramController
{
    private static boolean saved = false;
    private static String fileName = "temp";

    private static JFrame frame;

    public ProgramController(JFrame frame)
    {
        this.frame = frame;
    }

    //File functions
    public static void newFile()
    {
        System.out.println("New file");
    }

    public static void openFile()
    {
        System.out.println("Open file");
    }

    public static void save()
    {
        System.out.println("Save");
        saved = true;
    }

    public static void saveAs()
    {
        System.out.println("Save as");
    }

    //Edit functions
    public static void undo()
    {
        System.out.println("Undo");
    }

    public static void redo()
    {
        System.out.println("Redo");
    }

    public static void cut()
    {
        System.out.println("Cut");
    }

    public static void copy()
    {
        System.out.println("Copy");
    }

    public static void paste()
    {
        System.out.println("Paste");
    }

    //Close function that makes sure file cannot be closed without saving, unless wanted
    public static void requestClose()
    {
        if (!saved)
        {
            JOptionPane saveChanges = new JOptionPane();
            saveChanges.showConfirmDialog(frame, "Save changes to \"" + fileName + "\" before closing?", "Lithium Editor", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, Display.icon32x);
        }
    }
}
