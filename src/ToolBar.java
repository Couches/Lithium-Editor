package src;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

public class ToolBar
{
    JToolBar toolBar = new JToolBar();

    JButton newLightButton = new JButton(new ImageIcon("res\\images\\new-light.png"));
    JButton newEntityButton = new JButton(new ImageIcon("res\\images\\new-entity.png"));
    JButton newScriptButton = new JButton(new ImageIcon("res\\images\\new-script.png"));
    JButton compileMapsButton = new JButton(new ImageIcon("res\\images\\compile-maps.png"));

    public ToolBar(Display display)
    {
        newLightButton.setToolTipText("New light");
        newEntityButton.setToolTipText("New entity");
        newScriptButton.setToolTipText("New script");
        compileMapsButton.setToolTipText("Compile maps");
        
        toolBar.setOrientation(SwingConstants.VERTICAL);

        toolBar.add(newLightButton);
        toolBar.add(newEntityButton);
        toolBar.add(newScriptButton);
        toolBar.addSeparator();
        toolBar.add(compileMapsButton);

        display.getFrame().add(toolBar, BorderLayout.WEST);
    }
}
