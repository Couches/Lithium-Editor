package src;

import java.awt.event.*;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends ProgramController
{
    JMenuBar menuBar = new JMenuBar();
    
    // TODO: Add mnemonics for key shortcuts
    // TODO: Add remaining menus

    Display display;

    //File menu
    JMenu file = new JMenu("File");

    JMenuItem fileNew = new JMenuItem("New");
    JMenuItem fileOpen = new JMenuItem("Open");
    JMenuItem fileSave = new JMenuItem("Save");
    JMenuItem fileSaveAs = new JMenuItem("Save As");
    JMenuItem fileExit = new JMenuItem("Exit");
        

    //Edit menu
    JMenu edit = new JMenu("Edit");

    JMenuItem editUndo = new JMenuItem("Undo");
    JMenuItem editRedo = new JMenuItem("Redo");
    JMenuItem editCut = new JMenuItem("Cut");
    JMenuItem editCopy = new JMenuItem("Copy");
    JMenuItem editPaste = new JMenuItem("Paste");



    public MenuBar(Display display)
    {
        this.display = display;

        //Add menu items to File menu
        file.add(fileNew);
        file.add(fileOpen);
        file.addSeparator();
        file.add(fileSave);
        file.add(fileSaveAs);
        file.addSeparator();
        file.add(fileExit);

        //File menu action listeners
        fileNew   .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { fileNew();    }});
        fileOpen  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { fileOpen();   }});
        fileSave  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { fileSave();   }});
        fileSaveAs.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { fileSaveAs(); }});
        fileExit  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { fileExit();   }});

        //File menu accelerators
        fileNew.   setAccelerator(KeyStroke.getKeyStroke("control N"      ));
        fileOpen.  setAccelerator(KeyStroke.getKeyStroke("control O"      ));
        fileSave.  setAccelerator(KeyStroke.getKeyStroke("control S"      ));
        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
        fileExit  .setAccelerator(KeyStroke.getKeyStroke("alt F4"));

        //Add menu items to Edit menu
        edit.add(editUndo);
        edit.add(editRedo);
        edit.addSeparator();
        edit.add(editCut);
        edit.add(editCopy);
        edit.add(editPaste);

        //Edit menu action listeners
        editUndo .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { editUndo();  }});
        editRedo .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { editRedo();  }});
        editCut  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { editCut();   }});
        editCopy .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { editCopy();  }});
        editPaste.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { editPaste(); }});
        
        menuBar.add(file);
        menuBar.add(edit);

        display.getFrame().setJMenuBar(menuBar);
    }

    //File functions
    private void fileNew()
    {
        System.out.println("New file");
    }

    private void fileOpen()
    {
        System.out.println("Open file");
    }

    private void fileSave()
    {
        System.out.println("Save");
    }

    private void fileSaveAs()
    {
        System.out.println("Save as");
    }

    private void fileExit()
    {
        requestClose();
    }

    //Edit functions
    private void editUndo()
    {
        System.out.println("Undo");
    }

    private void editRedo()
    {
        System.out.println("Redo");
    }

    private void editCut()
    {
        System.out.println("Cut");
    }

    private void editCopy()
    {
        System.out.println("Copy");
    }

    private void editPaste()
    {
        System.out.println("Paste");
    }
}
