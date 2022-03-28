package src;

import java.awt.Graphics;

public class Cube
{
    private double xPosition;
    private double yPosition;
    private double zPosition;

    Vector3[] vertices = {
        new Vector3 (0, 0, 0),
        new Vector3 (1, 0, 0),
        new Vector3 (1, 1, 0),
        new Vector3 (0, 1, 0),
        new Vector3 (0, 1, 1),
        new Vector3 (1, 1, 1),
        new Vector3 (1, 0, 1),
        new Vector3 (0, 0, 1),
    };

    int[] triangles = {
        0, 2, 1, //face front
        0, 3, 2,
        2, 3, 4, //face top
        2, 4, 5,
        1, 2, 5, //face right
        1, 5, 6,
        0, 7, 4, //face left
        0, 4, 3,
        5, 4, 7, //face back
        5, 7, 6,
        0, 6, 7, //face bottom
        0, 1, 6
    };

    public Cube(double xPosition, double yPosition, double zPosition, double xScale, double yScale, double zScale)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.zPosition = zPosition;

        for (int i = 0; i < vertices.length; i++)
        {
            vertices[i].scale(xScale, yScale, zScale);
        }
    }

    public Cube(double xPosition, double yPosition, double zPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.zPosition = zPosition;
    }

    public void drawCube(int viewpoint, Graphics g, double cameraX, double cameraY)
    {
        if (viewpoint == 0) //FRONT
        {
            for (int i = 0; i < triangles.length; i++)
            {
                g.drawLine(
                    (int) (vertices[triangles[i]].getX() + xPosition + cameraX),
                    (int) (vertices[triangles[i]].getY() - yPosition + cameraY),
                    (int) (vertices[triangles[(i + 1) % triangles.length]].getX() + xPosition + cameraX),
                    (int) (vertices[triangles[(i + 1) % triangles.length]].getY() - yPosition + cameraY)
                );
                
                System.out.println(vertices[triangles[i]].getX() + " " + vertices[triangles[i]].getY());
            }
        }

        if (viewpoint == 1) //TOP
        {
            for (int i = 0; i < triangles.length; i++)
            {
                g.drawLine(
                    (int) (vertices[triangles[i]].getX() + xPosition + cameraX),
                    (int) (vertices[triangles[i]].getZ() + zPosition + cameraY),
                    (int) (vertices[triangles[(i + 1) % triangles.length]].getX() + xPosition + cameraX),
                    (int) (vertices[triangles[(i + 1) % triangles.length]].getZ() + zPosition + cameraY)
                );
                
                System.out.println(vertices[triangles[i]].getX() + " " + vertices[triangles[i]].getZ());
            }
        }

        if (viewpoint == 2) //LEFT
        {
            for (int i = 0; i < triangles.length; i++)
            {
                g.drawLine(
                    (int) (vertices[triangles[i]].getZ() + zPosition + cameraX),
                    (int) (vertices[triangles[i]].getY() - yPosition + cameraY),
                    (int) (vertices[triangles[(i + 1) % triangles.length]].getZ() + zPosition + cameraX),
                    (int) (vertices[triangles[(i + 1) % triangles.length]].getY() - yPosition + cameraY)
                );
                
                System.out.println(vertices[triangles[i]].getZ() + " " + vertices[triangles[i]].getY());
            }
        }
    }
}
