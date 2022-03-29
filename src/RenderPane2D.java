package src;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

import javax.swing.JLabel;

class RenderPane2D extends RenderPane
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        //g2d.drawLine(20 - cameraX, 20 - cameraY, 100 - cameraX, 100 - cameraY);

        renderEntity(new Entity(new Mesh("res\\models\\cone.obj"), 50, 50, 50, 50, 50, 50), g2d);
        renderEntity(new Entity(new Mesh("res\\models\\donut.obj"), 250, 50, 250, 25, 25, 25), g2d);
    }

    public void renderEntity(Entity entity, Graphics2D g2d)
    {
        int x1, x2, y1, y2;

        ArrayList<Vector3> vertices = new ArrayList<Vector3>();
        vertices = entity.getMesh().getVertices();

        ArrayList<Integer> indices = new ArrayList<Integer>();
        indices = entity.getMesh().getIndices();

        for (int i = 0; i < entity.getMesh().getIndices().size() - 1; i++)
        {
            g2d.drawLine(
                (int) (vertices.get(indices.get(i)).getX() * entity.getScaleX() + entity.getTranslationX()) - cameraX,
                (int) (vertices.get(indices.get(i)).getY() * entity.getScaleY() + entity.getTranslationY()) - cameraY,
                (int) (vertices.get(indices.get(i + 1)).getX() * entity.getScaleX() + entity.getTranslationX()) - cameraX,
                (int) (vertices.get(indices.get(i + 1)).getY() * entity.getScaleY() + entity.getTranslationY()) - cameraY
            );
        }
    }
}