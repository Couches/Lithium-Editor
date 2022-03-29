package src;

import javax.swing.JPanel;

import java.awt.GridLayout;

class EditorPane extends JPanel
{
    public EditorPane(Display display)
    {
        this.setLayout(new GridLayout(2, 2));

        add(new RenderPane2D());
        add(new RenderPane2D());
        add(new RenderPane2D());
        add(new RenderPane2D());

        display.addElement(this);
    }

    
}