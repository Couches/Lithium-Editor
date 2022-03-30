package src;


import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.GradientPaint;


import java.awt.geom.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import javax.swing.JLabel;

class RenderPane2D extends RenderPane
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RenderingHints rh2 = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        g2d.setRenderingHints(rh2);

        g2d.setStroke(new BasicStroke(1));

        //g2d.drawLine(20 - cameraX, 20 - cameraY, 100 - cameraX, 100 - cameraY);

        //renderEntity(new Entity(new Mesh("res\\models\\cone.obj"), 50, 50, 50, 50, 50, 50), g2d);
        renderEntity(new Entity(new Mesh("res\\models\\monkey.obj"), 250, 50, 250, 50, 50, 50), g2d, wireframe);
    }

    public void renderEntity(Entity entity, Graphics2D g2d, boolean wireframe)
    {
        Path2D myPath = new Path2D.Double();

        ArrayList<Vector3> vertices = entity.getMesh().getVertices();
        List<int[]> faces = entity.getMesh().getFaces();

        if (wireframe)
        {
            for (int i = 0; i < faces.size() - 1; i++)
            {
                g2d.setColor(Color.BLACK);
    
                // myPath.lineTo(vertices.get(faces.get(i)[0]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[0]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[1]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[1]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[2]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[2]).getY() * entity.getScaleY() - cameraY);
    
                g2d.drawPolygon(
                    new int[]{
                        (int) (-vertices.get(faces.get(i)[0]).getX() * entity.getScaleX() - cameraX),
                        (int) (-vertices.get(faces.get(i)[1]).getX() * entity.getScaleX() - cameraX),
                        (int) (-vertices.get(faces.get(i)[2]).getX() * entity.getScaleX() - cameraX),
                    },
                    new int[]{
                        (int) (-vertices.get(faces.get(i)[0]).getY() * entity.getScaleY() - cameraY),
                        (int) (-vertices.get(faces.get(i)[1]).getY() * entity.getScaleY() - cameraY),
                        (int) (-vertices.get(faces.get(i)[2]).getY() * entity.getScaleY() - cameraY)
                    },
                3);
            }
        }
        else
        {
            for (int i = 0; i < faces.size() - 1; i++)
            {
                g2d.setColor(Color.BLACK);
    
                // myPath.lineTo(vertices.get(faces.get(i)[0]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[0]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[1]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[1]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[2]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[2]).getY() * entity.getScaleY() - cameraY);
    
                g2d.fillPolygon(
                    new int[]{
                        (int) (vertices.get(faces.get(i)[0]).getX() * entity.getScaleX() - cameraX),
                        (int) (vertices.get(faces.get(i)[1]).getX() * entity.getScaleX() - cameraX),
                        (int) (vertices.get(faces.get(i)[2]).getX() * entity.getScaleX() - cameraX),
                    },
                    new int[]{
                        (int) (vertices.get(faces.get(i)[0]).getY() * entity.getScaleY() - cameraY),
                        (int) (vertices.get(faces.get(i)[1]).getY() * entity.getScaleY() - cameraY),
                        (int) (vertices.get(faces.get(i)[2]).getY() * entity.getScaleY() - cameraY)
                    },
                3);
            }
        }

        
    }
}