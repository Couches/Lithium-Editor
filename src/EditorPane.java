package src;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;

import java.awt.GridLayout;

class EditorPane extends JPanel
{
    private RenderPane frontRenderPane = new RenderPane();
    private RenderPane topRenderPane = new RenderPane();
    private RenderPane leftRenderPane = new RenderPane();
    private RenderPane rightRenderPane = new RenderPane();

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