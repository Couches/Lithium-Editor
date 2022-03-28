package src;

import java.awt.Color;

import javax.swing.JPanel;

public class GUIHandler
{
    public GUIHandler(Display display)
    {
        MenuBar menuBar = new MenuBar(display);
        ToolBar toolBar = new ToolBar(display);
        EditorPane editorPane = new EditorPane(display);
        
        display.getFrame().setVisible(true);
    }
}