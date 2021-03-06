package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RenderPane extends JPanel implements MouseListener, MouseMotionListener
{
    //Viewport settings
    public boolean wireframe = true;

    //Camera mouse movement variables
    private int staticX = 0;
    private int staticY = 0;

    public int cameraX = 0;
    public int cameraY = 0;

    private int startX;
    private int startY;

    private int walkX;
    private int walkY;
    
    public JLabel cameraLabel = new JLabel();
    private JButton wireframeButton = new JButton();

    public RenderPane()
    {
        addMouseListener(this);
        addMouseMotionListener(this);

        add(cameraLabel);
        add(wireframeButton);

        wireframeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                wireframe = !wireframe;
                update();
            }
        });

        

        setBackground(new Color(120, 120, 120));

        update();
    }
    
    public void update()
    {
        setBorder(BorderFactory.createLineBorder(Color.white));

        cameraLabel.setText("Camera X:" + cameraX + " Camera Y:" + cameraY); 
        wireframeButton.setText("Wireframe: " + (wireframe ? "On" : "Off"));
    }

    public RenderPane getRenderPane()
    {
        return this;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        startX = (int) -e.getPoint().getX();
        startY = (int) -e.getPoint().getY();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        staticX = -cameraX;
        staticY = -cameraY;

        walkX = 0;
        walkY = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        walkX = startX + (int) e.getPoint().getX();
        walkY = startY + (int) e.getPoint().getY();

        cameraX = -staticX - walkX;
        cameraY = -staticY - walkY;

        update();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        
    }
}
