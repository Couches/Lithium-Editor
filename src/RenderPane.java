package src;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RenderPane extends JPanel implements MouseListener, MouseMotionListener
{
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

    Mesh sphereMesh = new Mesh("res\\models\\sphere.obj");

    Entity entities[] = { new Entity(sphereMesh), new Entity(sphereMesh), new Entity(sphereMesh) };

    //Specify viewport to set direction of camera on scene
    // 0-front 1-top 2-left 3-right
    public RenderPane()
    {
        addMouseListener(this);
        addMouseMotionListener(this);

        add(cameraLabel);

        setBackground(new Color(120, 120, 120));

        update();
    }
    
    public void update()
    {
        setBorder(BorderFactory.createLineBorder(Color.white));

        cameraLabel.setText("Camera X:" + cameraX + " Camera Y:" + cameraY);   
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
