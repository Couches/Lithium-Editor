package src;

import javax.swing.JOptionPane;

public class ProgramController extends FileGenerator
{
    private boolean saved = true;
    private String fileName;

    //File functions
    public void newFile()
    {
        generateFile((String) JOptionPane.showInputDialog(Display.frame, "Enter new file name:", "Lithium Editor",
            JOptionPane.INFORMATION_MESSAGE, Display.icon32x, null, ""));
    }

    public void openFile()
    {
        System.out.println("Open file");
    }

    public void save()
    {
        System.out.println("Save");
        saved = true;
    }

    public void saveAs()
    {
        System.out.println("Save as");
    }

    //Edit functions
    public void undo()
    {
        System.out.println("Undo");
    }

    public void redo()
    {
        System.out.println("Redo");
    }

    public void cut()
    {
        System.out.println("Cut");
    }

    public void copy()
    {
        System.out.println("Copy");
    }

    public void paste()
    {
        System.out.println("Paste");
    }

    //Close function that makes sure file cannot be closed without saving, unless wanted
    public void requestClose()
    {
        if (!saved)
        {
            switch(JOptionPane.showConfirmDialog(Display.frame, "Save changes to \"" + fileName + "\" before closing?", "Lithium Editor", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, Display.icon32x))
            {
                case 0:
                    save();
                    System.out.println("Exited with saving...");
                    System.exit(1);
                    break;
                case 1:
                    System.out.println("Exited without saving...");
                    System.exit(1);
                    break;
                case 2:
                    System.out.println("Canceled...");
                    break;
            }
        } 
        else
        {
            System.exit(1);
        }
    }
}
