package src;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RenderPane extends JPanel implements MouseListener, MouseMotionListener
{
    private int viewpoint;

    private int staticX = 0;
    private int staticY = 0;

    private int cameraX = 0;
    private int cameraY = 0;

    private int startX, startY;
    private int walkX, walkY;

    String viewpoints[] = { "Front", "Top", "Left", "Right" };

    JLabel cameraXLabel = new JLabel("Camera X: " + cameraX);
    JLabel cameraYLabel = new JLabel("Camera Y: " + cameraY);

    Cube cubeList[] = {
        new Cube(0.0, 0.0, 0.0, 250.0, 10.0, 250.0), //Floor Rect
        new Cube(0.0, 25.0, 0.0, 25.0, 25.0, 25.0),
        new Cube(225.0, 25.0, 225.0, 25.0, 25.0, 25.0),
        new Cube(225.0, 25.0, 0.0, 25.0, 25.0, 25.0)
    };

    //Specify viewport to set direction of camera on scene
    // 0-front 1-top 2-left 3-right
    public RenderPane(int viewpoint)
    {
        this.viewpoint = viewpoint;

        addMouseListener(this);
        addMouseMotionListener(this);

        JLabel viewpointLabel = new JLabel("Viewpoint: " + viewpoints[viewpoint]);
        add(viewpointLabel);
        add(cameraXLabel);
        add(cameraYLabel);

        setBackground(new Color(120, 120, 120));

        update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        
        for (int i = 0; i < cubeList.length; i++)
        {
            cubeList[i].drawCube(viewpoint, g, -cameraX, -cameraY);
        }
    }

    public void update()
    {
        cameraXLabel.setText("Camera X: " + cameraX);
        cameraYLabel.setText("Camera Y: " + cameraY);

        setBorder(BorderFactory.createLineBorder(Color.white));
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
