package src;

import java.util.List;

public class Vector3
{
    public float x, y, z;

    public Vector3(List<Integer> coords)
    {
        this.x = coords.get(0);
        this.y = coords.get(1);
        this.z = coords.get(2);
    }

    public Vector3(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public float getZ()
    {
        return this.z;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setZ(float z)
    {
        this.z = z;
    }

    public void scale(float xScale, float yScale, float zScale)
    {
        this.x *= xScale;
        this.y *= yScale;
        this.z *= zScale;
    }

    public void scaleX(float xScale)
    {
        this.x *= xScale;
    }

    public void scaleY(float yScale)
    {
        this.y *= yScale;
    }

    public void scaleZ(float zScale)
    {
        this.z *= zScale;
    }

    public void translateX(float x)
    {
        this.x += x;
    }

    public void translateY(float y)
    {
        this.y += y;
    }

    public void translateZ(float z)
    {
        this.z += z;
    }
}
