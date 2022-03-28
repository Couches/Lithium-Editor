package src;

import java.awt.event.*;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends ProgramController
{
    JMenuBar menuBar = new JMenuBar();
    
    // TODO: Add key shortcuts
    // TODO: Add remaining menus

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

        //Add menu items to File menu
        file.add(fileNew);
        file.add(fileOpen);
        file.addSeparator();
        file.add(fileSave);
        file.add(fileSaveAs);
        file.addSeparator();
        file.add(fileExit);

        //File menu action listeners
        fileNew   .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { newFile();      }});
        fileOpen  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { openFile();     }});
        fileSave  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { save();         }});
        fileSaveAs.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { saveAs();       }});
        fileExit  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { requestClose(); }});

        //File menu accelerators
        fileNew.   setAccelerator(KeyStroke.getKeyStroke("control N"      ));
        fileOpen.  setAccelerator(KeyStroke.getKeyStroke("control O"      ));
        fileSave.  setAccelerator(KeyStroke.getKeyStroke("control S"      ));
        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
        fileExit  .setAccelerator(KeyStroke.getKeyStroke("alt F4"         ));

        //Add menu items to Edit menu
        edit.add(editUndo);
        edit.add(editRedo);
        edit.addSeparator();
        edit.add(editCut);
        edit.add(editCopy);
        edit.add(editPaste);

        //Edit menu action listeners
        editUndo .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { undo();  }});
        editRedo .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { redo();  }});
        editCut  .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { cut();   }});
        editCopy .addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { copy();  }});
        editPaste.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { paste(); }});

        //Edit menu accelerators
        editUndo .setAccelerator(KeyStroke.getKeyStroke("control Z"));
        editRedo .setAccelerator(KeyStroke.getKeyStroke("control Y"));
        editCut  .setAccelerator(KeyStroke.getKeyStroke("control X"));
        editCopy .setAccelerator(KeyStroke.getKeyStroke("control C"));
        editPaste.setAccelerator(KeyStroke.getKeyStroke("control V"));
        
        menuBar.add(file);
        menuBar.add(edit);

        display.getFrame().setJMenuBar(menuBar);
    }
}
