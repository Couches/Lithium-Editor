package src;

import java.awt.*;
import java.util.*;
import java.util.List;

class RenderPane2D extends RenderPane
{
    Entity entities[] = {
        new Entity(new Mesh("res\\models\\monkey.obj"), new Vector3(50, 50, 50), new Vector3(50, 50, 50), new Vector3(50, 50, 50)),
        new Entity(new Mesh("res\\models\\monkey.obj"), new Vector3(225, 175, 175), new Vector3(35, 35, 35),  new Vector3(50, 50, 50)),
        new Entity(new Mesh("res\\models\\monkey.obj"), new Vector3(350, 250, 250), new Vector3(20, 20, 20),  new Vector3(50, 50, 50)),
    };

    private boolean antialiasing = false;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (antialiasing) g2d.setRenderingHints(rh);

        g2d.setStroke(new BasicStroke(1));

        //g2d.drawLine(20 - cameraX, 20 - cameraY, 100 - cameraX, 100 - cameraY);

        //renderEntity(new Entity(new Mesh("res\\models\\cone.obj"), 50, 50, 50, 50, 50, 50), g2d);
        for (int i = 0; i < entities.length; i++)
        {
            Render.renderEntity2D(entities[i], g2d, wireframe, cameraX, cameraY);
        }
    }

    
}