package src;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;

import java.awt.GridLayout;

class EditorPane extends JPanel
{
    private RenderPane frontRenderPane = new RenderPane(0);
    private RenderPane topRenderPane = new RenderPane(1);
    private RenderPane leftRenderPane = new RenderPane(2);
    private RenderPane rightRenderPane = new RenderPane(3);

    public EditorPane(Display display)
    {
        this.setLayout(new GridLayout(2, 2));

        this.add(frontRenderPane);
        this.add(topRenderPane);
        this.add(leftRenderPane);
        this.add(rightRenderPane);

        display.addElement(this);
    }
}