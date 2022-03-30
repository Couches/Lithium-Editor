package src;

import java.awt.*;
import java.util.*;
import java.util.List;

class RenderPane2D extends RenderPane
{
    Entity entities[] = {
        new Entity(new Mesh("res\\models\\monkey.obj"), 50, 50, 50, 50, 50, 50),
        new Entity(new Mesh("res\\models\\donut.obj"), 250, 50, 250, 50, 50, 50),
        new Entity(new Mesh("res\\models\\cone2.obj"), -150, 0, 0, 100, 100, 100)
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
            renderEntity(entities[i], g2d, wireframe);
        }
    }

    public void renderEntity(Entity entity, Graphics2D g2d, boolean wireframe)
    {
        ArrayList<Vector3> vertices = entity.getMesh().getVertices();
        List<Triangle> triangles = entity.getMesh().getTriangles();

        if (wireframe)
        {
            for (int i = 0; i < triangles.size() - 1; i++)
            {
                g2d.setColor(Color.BLACK);
    
                // myPath.lineTo(vertices.get(faces.get(i)[0]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[0]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[1]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[1]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[2]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[2]).getY() * entity.getScaleY() - cameraY);
    
                g2d.drawPolygon(
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].getX() * entity.getScaleX() - cameraX + entity.getTranslationX()),
                        (int) (-triangles.get(i).triangle[1].getX() * entity.getScaleX() - cameraX + entity.getTranslationX()),
                        (int) (-triangles.get(i).triangle[2].getX() * entity.getScaleX() - cameraX + entity.getTranslationX()),
                    },
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].getY() * entity.getScaleY() - cameraY + entity.getTranslationZ()),
                        (int) (-triangles.get(i).triangle[1].getY() * entity.getScaleY() - cameraY + entity.getTranslationZ()),
                        (int) (-triangles.get(i).triangle[2].getY() * entity.getScaleY() - cameraY + entity.getTranslationZ())
                    },
                3);
            }
        }
        else
        {
            for (int i = 0; i < triangles.size() - 1; i++)
            {
                g2d.setColor(Color.BLACK);
    
                // myPath.lineTo(vertices.get(faces.get(i)[0]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[0]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[1]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[1]).getY() * entity.getScaleY() - cameraY);
                // myPath.lineTo(vertices.get(faces.get(i)[2]).getX() * entity.getScaleX() - cameraX, vertices.get(faces.get(i)[2]).getY() * entity.getScaleY() - cameraY);
    
                g2d.fillPolygon(
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].getX() * entity.getScaleX() - cameraX + entity.getTranslationX()),
                        (int) (-triangles.get(i).triangle[1].getX() * entity.getScaleX() - cameraX + entity.getTranslationX()),
                        (int) (-triangles.get(i).triangle[2].getX() * entity.getScaleX() - cameraX + entity.getTranslationX()),
                    },
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].getY() * entity.getScaleY() - cameraY + entity.getTranslationZ()),
                        (int) (-triangles.get(i).triangle[1].getY() * entity.getScaleY() - cameraY + entity.getTranslationZ()),
                        (int) (-triangles.get(i).triangle[2].getY() * entity.getScaleY() - cameraY + entity.getTranslationZ())
                    },
                3);
            }
        }

        
    }
}