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
        new Entity(new Mesh("res\\models\\monkey.obj"), new Vector3(0.0f, 0.0f, 0.0f), new Vector3(1000.0f, 500.0f, 2000.0f), new Vector3(100.0f, 50.0f, 10.0f)),
    };

    private boolean orthographic = true;
    
    private JButton projectionButton = new JButton();
    private JSlider fieldOfViewSlider = new JSlider(1, 175, 90);
    private JLabel fieldOfViewLabel = new JLabel();

    private JPanel sliderContainer = new JPanel();
    private JSlider xRotationSlider = new JSlider(0, (int) 360, 0);
    private JSlider yRotationSlider = new JSlider(0, (int) 360, 0);
    private JSlider zRotationSlider = new JSlider(0, (int) 360, 0);

    private static final Vector3 WORLD_UP = new Vector3(0, 1, 0);

    Vector3 cameraPos = new Vector3();

    private float yaw, pitch;

    private float fov = 90.0f;
    private float aspectRatio = 1.0f;
    private float zNear = 0.1f;
    private float zFar = 1000.0f;

    public RenderPane3D()
    {
        updatePane3D();

        add(projectionButton);
        add(fieldOfViewSlider);
        add(fieldOfViewLabel);

        sliderContainer.add(new JLabel("X Rotation:"));
        sliderContainer.add(xRotationSlider);

        sliderContainer.add(new JLabel("Y Rotation:"));
        sliderContainer.add(yRotationSlider);

        sliderContainer.add(new JLabel("Z Rotation:"));
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
            renderEntity(entities[i], cameraPos, g2d);
        }
    }

    public void updatePane3D()
    {
        projectionButton.setText("Projection: " + (orthographic ? "Orthographic" : "Perspective"));
        fieldOfViewLabel.setText("Field Of View: " + fov);

        repaint();
    }



    public void renderEntity(Entity entity, Vector3 cameraPos, Graphics2D g2d)
    {
        Vector3 front = new Vector3();

        front.x = (float) Math.cos(Math.toRadians(yaw)) * (float) Math.cos(Math.toRadians(pitch));
        front.y = (float) Math.sin(Math.toRadians(pitch));
        front.z = (float) Math.sin(Math.toRadians(yaw)) * (float) Math.cos(Math.toRadians(pitch));

        front = Vector3.normalize(front);

        Vector3 right = Vector3.normalize(front.cross(WORLD_UP));
        Vector3 up = Vector3.normalize(right.cross(front));

        List<Triangle> triangles = entity.getMesh().getTriangles();
            
        Matrix4 projection = Matrix4.perspective(fov, aspectRatio, zNear, zFar);

        Vector3 p0, p1, p2;
        Matrix4 view = new Matrix4();
        Matrix4 model = entity.matrix;

        

        

        model = model.rotate(model, (float) Math.toRadians(entity.getRotation().x), new Vector3(1.0f, 0.0f, 0.0f));
        model = model.rotate(model, (float) Math.toRadians(entity.getRotation().y), new Vector3(0.0f, 1.0f, 0.0f));
        model = model.rotate(model, (float) Math.toRadians(entity.getRotation().z), new Vector3(0.0f, 0.0f, 1.0f));

        model = model.scale(model, entity.getScale());

        model = model.translate(model, entity.getTranslation());

        Vector4 sp0, sp1, sp2;

        for (int i = 0; i < triangles.size() - 1; i++)
        {
            p0 = triangles.get(i).triangle[0];
            p1 = triangles.get(i).triangle[1];
            p2 = triangles.get(i).triangle[2];
            
            view = Matrix4.lookAt(cameraPos, cameraPos.add(front), up);

            //System.out.println(view.c[0].toString() + " " + view.c[1].toString() + " " + view.c[2].toString() + " " + view.c[3].toString());

            sp0 = projection.mul(view.mul(model.mul(new Vector4(p0, 1.0f))));
            sp1 = projection.mul(view.mul(model.mul(new Vector4(p1, 1.0f))));
            sp2 = projection.mul(view.mul(model.mul(new Vector4(p2, 1.0f))));

            //System.out.println(sp0.toString() + " " + sp1.toString() + " " + sp2.toString());

            g2d.drawPolygon(
                new int[]{
                    (int) (sp0.x) - cameraX, 
                    (int) (sp1.x) - cameraX, 
                    (int) (sp2.x) - cameraX, 
                },
                new int[]{
                    (int) (sp0.y) - cameraY, 
                    (int) (sp1.y) - cameraY, 
                    (int) (sp2.y) - cameraY,
                },
            3);

            updatePane3D();
        }
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
                //FOV SLIDER
                fov = (float) fieldOfViewSlider.getValue() / 10.0f;
                repaint();
                updatePane3D();
            }
            
        });

        xRotationSlider.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                //rotationX = (float) xRotationSlider.getValue() / 10;
                entities[0].rotation.x = (float) xRotationSlider.getValue();
                repaint();
                updatePane3D();
            }
            
        });

        yRotationSlider.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                //rotationY = (float) yRotationSlider.getValue() / 10;
                entities[0].rotation.y = (float) yRotationSlider.getValue();
                repaint();
                updatePane3D();
            }
            
        });

        zRotationSlider.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                //rotationZ = (float) zRotationSlider.getValue();
                entities[0].rotation.z = (float) zRotationSlider.getValue();
                repaint();
                updatePane3D();
            }

        });

        
    }
}