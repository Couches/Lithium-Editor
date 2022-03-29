package src;

import javax.swing.JLabel;

class RenderPane3D extends RenderPane
{
    public RenderPane3D()
    {
        add(new JLabel("3D Viewport"));
    }

    public void update()
    {
        //TODO add camera Z position to camera label update
        cameraLabel.setText("Camera X: " + cameraX + "  Camera Y: " + cameraY + "  Camera Z: " + null);
    }
}