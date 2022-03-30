package src;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class RenderPane3D extends RenderPane
{
    Entity entities[] = {
        new Entity(new Mesh("res\\models\\cube.obj"), 100, 100, 100, 10, 10, 10),
    };

    private boolean orthographic = true;
    
    private JButton projectionButton = new JButton();
    private JSlider fieldOfViewSlider = new JSlider(0, 250, 10);
    private JLabel fieldOfViewLabel = new JLabel();

    private JPanel sliderContainer = new JPanel();
    private JSlider xRotationSlider = new JSlider(0, (int) (10 * 6.28319), 0);
    private JSlider yRotationSlider = new JSlider(0, (int) (10 * 6.28319), 0);
    private JSlider zRotationSlider = new JSlider(0, (int) (10 * 6.28319), 0);

    private float rotationX = 0.0f;
    private float rotationY = 0.0f;
    private float rotationZ = 0.0f;

    //Projection matrix

    private Matrix4x4 matrixProjection = new Matrix4x4();

    Matrix4x4 matrixRotationZ = new Matrix4x4();
    Matrix4x4 matrixRotationX = new Matrix4x4();

    private float nearPlane = 0.1f;
    private float farPlane = 1000.0f;
    private float fieldOfView = 10.0f;
    private float aspectRatio = 1.0f;
    private float fieldOfViewRadius;

    
    

    public RenderPane3D()
    {
        updatePane3D();

        add(projectionButton);
        add(fieldOfViewSlider);
        add(fieldOfViewLabel);

        sliderContainer.add(xRotationSlider);
        sliderContainer.add(yRotationSlider);
        sliderContainer.add(zRotationSlider);

        add(sliderContainer);
        
        addJElementListeners();
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
        List<Triangle> triangles = entity.getMesh().getTriangles();

        g2d.setColor(Color.BLACK);

        for (int i = 0; i < triangles.size() - 1; i++)
        {
            Triangle triangleProjected = new Triangle();

            Triangle triangleTranslated = triangles.get(i);

            triangleTranslated.triangle[0].z = 0.0f;
            triangleTranslated.triangle[1].z = 0.0f;
            triangleTranslated.triangle[2].z = 0.0f;

            multiplyMatrixVector(triangleTranslated.triangle[0], triangleProjected.triangle[0], matrixRotationX);
            multiplyMatrixVector(triangleTranslated.triangle[1], triangleProjected.triangle[1], matrixRotationX);
            multiplyMatrixVector(triangleTranslated.triangle[2], triangleProjected.triangle[2], matrixRotationX);

            multiplyMatrixVector(triangleProjected.triangle[0], triangleProjected.triangle[0], matrixRotationZ);
            multiplyMatrixVector(triangleProjected.triangle[1], triangleProjected.triangle[1], matrixRotationZ);
            multiplyMatrixVector(triangleProjected.triangle[2], triangleProjected.triangle[2], matrixRotationZ);

            

            g2d.drawPolygon(
                new int[]
                {
                    (int) (-triangleProjected.triangle[0].getX() * 50) - cameraX,
                    (int) (-triangleProjected.triangle[1].getX() * 50) - cameraX,
                    (int) (-triangleProjected.triangle[2].getX() * 50) - cameraX,
                },
                new int[]
                {
                    (int) (-triangleProjected.triangle[0].getY() * 50) - cameraY,
                    (int) (-triangleProjected.triangle[1].getY() * 50) - cameraY,
                    (int) (-triangleProjected.triangle[2].getY() * 50) - cameraY,
                }, 
            3);
        }
    }

    private void multiplyMatrixVector(Vector3 i, Vector3 o, Matrix4x4 m)
    {
        float w;

        o.setX(i.getX() * m.matrix[0][0] + i.getY() * m.matrix[1][0] + i.getZ() * m.matrix[2][0] + m.matrix[3][0]);
        o.setY(i.getX() * m.matrix[0][1] + i.getY() * m.matrix[1][1] + i.getZ() * m.matrix[2][1] + m.matrix[3][1]);
        o.setZ(i.getX() * m.matrix[0][2] + i.getY() * m.matrix[1][2] + i.getZ() * m.matrix[2][2] + m.matrix[3][2]);
        w  =   i.getX() * m.matrix[0][3] + i.getY() * m.matrix[1][3] + i.getZ() * m.matrix[2][3] + m.matrix[3][3];

        if (w != 0.0f)
        {
            o.setX(o.getX() / w);
            o.setY(o.getY() / w);
            o.setZ(o.getZ() / w);
        }
    }

    public void updatePane3D()
    {
        //Update fov radius to fieldOfView changes

        float fieldOfViewRadius = (float) (1.0f / (float) Math.tan((fieldOfView * 0.5f) / (180.0f * (float) Math.PI)));

        matrixProjection.matrix[0][0] = aspectRatio * fieldOfViewRadius;
        matrixProjection.matrix[1][1] = fieldOfViewRadius;
        matrixProjection.matrix[2][2] = farPlane / (farPlane - nearPlane);
        matrixProjection.matrix[3][2] = (-farPlane * nearPlane) / (farPlane - nearPlane);
        matrixProjection.matrix[2][3] = 1.0f;
        matrixProjection.matrix[3][3] = 1.0f;

        //Update rotations

        

        //Rotation X
        matrixRotationX.matrix[0][0] = (float) Math.cos(rotationX);
        matrixRotationX.matrix[0][1] = (float) Math.sin(rotationX);
        matrixRotationX.matrix[1][0] = (float)-Math.sin(rotationX);
        matrixRotationX.matrix[1][1] = (float) Math.cos(rotationX);
        matrixRotationX.matrix[2][2] = 1;
        matrixRotationX.matrix[3][3] = 1;

        //Rotation Z
        matrixRotationZ.matrix[0][0] = 1;
        matrixRotationZ.matrix[0][1] = (float) Math.cos(rotationZ);
        matrixRotationZ.matrix[1][0] = (float) Math.sin(rotationZ);
        matrixRotationZ.matrix[1][1] = (float)-Math.sin(rotationZ);
        matrixRotationZ.matrix[2][2] = (float) Math.cos(rotationZ);
        matrixRotationZ.matrix[3][3] = 1;

        projectionButton.setText("Projection: " + (orthographic ? "Orthographic" : "Perspective"));
        fieldOfViewLabel.setText("Field Of View: " + fieldOfView);
    }

    private void addJElementListeners()
    {
        projectionButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                orthographic = !orthographic;
                projectionButton.setText("Projection: " + (orthographic ? "Orthographic" : "Perspective"));
            }
        });

        fieldOfViewSlider.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                fieldOfView = (float) fieldOfViewSlider.getValue();
                repaint();
                updatePane3D();
            }
            
        });

        xRotationSlider.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                rotationX = (float) xRotationSlider.getValue() / 10;
                repaint();
                updatePane3D();
            }
            
        });

        zRotationSlider.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                rotationZ = (float) zRotationSlider.getValue() / 10;
                repaint();
                updatePane3D();
            }
            
        });
    }
}