package src;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBar
{
    JMenuBar menuBar = new JMenuBar();
    
    // TODO: Add mnemonics for key shortcuts
    // TODO: Add remaining menus

    JMenu file = new JMenu("File");

    JMenuItem fileNew = new JMenuItem("New");
    JMenuItem fileOpen = new JMenuItem("Open");

    JMenuItem fileSave = new JMenuItem("Save");
    JMenuItem fileSaveAs = new JMenuItem("Save As");
        
    JMenu edit = new JMenu("Edit");

    JMenuItem editUndo = new JMenuItem("Undo");
    JMenuItem editRedo = new JMenuItem("Redo");

    JMenuItem editCut = new JMenuItem("Cut");
    JMenuItem editCopy = new JMenuItem("Copy");
    JMenuItem editPaste = new JMenuItem("Paste");

    public MenuBar(Display display)
    {
        file.add(fileNew);
        file.add(fileOpen);
        file.addSeparator();
        file.add(fileSave);
        file.add(fileSaveAs);

        edit.add(editUndo);
        edit.add(editRedo);
        edit.addSeparator();
        edit.add(editCut);
        edit.add(editCopy);
        edit.add(editPaste);
        
        menuBar.add(file);
        menuBar.add(edit);

        display.getFrame().setJMenuBar(menuBar);
    }
}
