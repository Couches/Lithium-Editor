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
    private int staticX = 0;
    private int staticY = 0;

    private int cameraX = 0;
    private int cameraY = 0;

    private int startX, startY;
    private int walkX, walkY;

    JLabel cameraXLabel = new JLabel("Camera X: " + cameraX);
    JLabel cameraYLabel = new JLabel("Camera Y: " + cameraY);

    public RenderPane()
    {
        addMouseListener(this);
        addMouseMotionListener(this);

        add(cameraXLabel);
        add(cameraYLabel);

        setBackground(new Color(120, 120, 120));

        update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.CYAN);
        g.fillRect(-cameraX, -cameraY, this.getWidth(), this.getHeight());

        System.out.println("Painted");
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
