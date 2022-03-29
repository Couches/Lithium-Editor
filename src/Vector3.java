package src;

import java.util.List;

public class Vector3
{
    private double x, y, z;

    public Vector3(List<Integer> coords)
    {
        this.x = coords.get(0);
        this.y = coords.get(1);
        this.z = coords.get(2);
    }

    public Vector3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getZ()
    {
        return this.z;
    }

    public void scale(double xScale, double yScale, double zScale)
    {
        this.x *= xScale;
        this.y *= yScale;
        this.z *= zScale;
    }

    public void scaleX(double xScale)
    {
        this.x *= xScale;
    }

    public void scaleY(double yScale)
    {
        this.y *= yScale;
    }

    public void scaleZ(double zScale)
    {
        this.z *= zScale;
    }
}
