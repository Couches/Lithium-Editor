package src;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

import javax.swing.*;

class RenderPane3D extends RenderPane
{
    Entity entities[] = {
        new Entity(new Mesh("res\\models\\monkey.obj"), 50, 50, 50, 50, 50, 50),
    };

    private boolean orthographic = true;
    
    private JButton projectionButton = new JButton();

    //Projection matrix

    private Matrix4x4 matrixProjection;

    private float nearPlane = 0.1f;
    private float farPlane = 1000.0f;
    private float fieldOfView = 90.0f;
    private float aspectRatio = this.getHeight() / this.getWidth();
    private float fieldOfViewRadius = (float) (1.0f / Math.tan((fieldOfView * 0.5f) / (180.0f * Math.PI)));
    

    public RenderPane3D()
    {
        matrixProjection.matrix[0][0] = aspectRatio * fieldOfViewRadius;
        matrixProjection.matrix[1][1] = fieldOfViewRadius;
        matrixProjection.matrix[2][2] = farPlane / (farPlane - nearPlane);
        matrixProjection.matrix[3][2] = (-farPlane * nearPlane) / (farPlane - nearPlane);
        matrixProjection.matrix[2][3] = 1.0f;
        matrixProjection.matrix[3][3] = 0.0f;

        add(projectionButton);
        projectionButton.setText("Projection: " + (orthographic ? "Orthographic" : "Perspective"));

        projectionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                orthographic = !orthographic;
                projectionButton.setText("Projection: " + (orthographic ? "Orthographic" : "Perspective"));
            }
        });
    }

    private boolean antialiasing = false;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (antialiasing) g2d.setRenderingHints(rh);

        g2d.setStroke(new BasicStroke(1));

        for (int i = 0; i < entities.length; i++)
        {
            renderEntity(entities[i], g2d, wireframe, orthographic);
        }
    }

    public void renderEntity(Entity entity, Graphics2D g2d, boolean wireframe, boolean orthographic)
    {
        ArrayList<Vector3> vertices = entity.getMesh().getVertices();
        List<int[]> faces = entity.getMesh().getFaces();

        for (int i = 0; i < faces.size() - 1; i++)
        {
            
        }
    }

    private void multiplyMatrixVector(Vector3 i, Vector3 o, Matrix4x4 m)
    {
        float ox = o.getX();
        float oy = o.getY();
        float oz = o.getZ();
        float w;

        ox = i.getX() * m.matrix[0][0] + i.getY() * m.matrix[1][0] + i.getZ() * m.matrix[2][0] + m.matrix[3][0];
        oy = i.getX() * m.matrix[0][1] + i.getY() * m.matrix[1][1] + i.getZ() * m.matrix[2][1] + m.matrix[3][1];
        oz = i.getX() * m.matrix[0][2] + i.getY() * m.matrix[1][2] + i.getZ() * m.matrix[2][2] + m.matrix[3][2];
        w  = i.getX() * m.matrix[0][3] + i.getY() * m.matrix[1][3] + i.getZ() * m.matrix[2][3] + m.matrix[3][3];

        if (w != 0.0)
        {
            ox /= w;
            oy /= w;
            oz /= w;
        }
    }
}