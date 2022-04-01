package src;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.JPanel;

public class Render extends RenderPane3D
{
    public static void renderEntity2D(Entity entity, Graphics2D g2d, boolean wireframe, int offsetX, int offsetY)
    {
        ArrayList<Vector3> vertices = entity.getMesh().getVertices();
        List<Triangle> triangles = entity.getMesh().getTriangles();

        if (wireframe)
        {
            for (int i = 0; i < triangles.size() - 1; i++)
            {
                g2d.setColor(Color.BLACK);

                g2d.drawPolygon(
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].x * entity.getScale().x - offsetX + entity.getTranslation().x),
                        (int) (-triangles.get(i).triangle[1].x * entity.getScale().x - offsetX + entity.getTranslation().x),
                        (int) (-triangles.get(i).triangle[2].x * entity.getScale().x - offsetX + entity.getTranslation().x),
                    },
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].y * entity.getScale().y - offsetY + entity.getTranslation().y),
                        (int) (-triangles.get(i).triangle[1].y * entity.getScale().y - offsetY + entity.getTranslation().y),
                        (int) (-triangles.get(i).triangle[2].y * entity.getScale().y - offsetY + entity.getTranslation().y)
                    },
                3);
            }
        }
        else
        {
            for (int i = 0; i < triangles.size() - 1; i++)
            {
                g2d.setColor(Color.BLACK);

                g2d.fillPolygon(
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].x * entity.getScale().x - offsetX + entity.getTranslation().x),
                        (int) (-triangles.get(i).triangle[1].x * entity.getScale().x - offsetX + entity.getTranslation().x),
                        (int) (-triangles.get(i).triangle[2].x * entity.getScale().x - offsetX + entity.getTranslation().x),
                    },
                    new int[]{
                        (int) (-triangles.get(i).triangle[0].y * entity.getScale().y - offsetY + entity.getTranslation().y),
                        (int) (-triangles.get(i).triangle[1].y * entity.getScale().y - offsetY + entity.getTranslation().y),
                        (int) (-triangles.get(i).triangle[2].y * entity.getScale().y - offsetY + entity.getTranslation().y)
                    },
                3);
            }
        }
    }

    public void renderEntity3D(Entity entity, Graphics2D g2d)
    {
        
    }
}
