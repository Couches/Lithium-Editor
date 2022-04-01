package src;

import java.util.List;

public class Vector3
{
    public float x, y, z;
    
    private float magnitude = magnitude(this);

    public Vector3()
    {
        
    }

    public Vector3(List<Float> coords)
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

    public Vector3(Vector4 v)
    {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public void magnitude()
    {
        this.magnitude = (float) Math.sqrt(
        (
            x * x +
            y * y +
            z * z 
        ));
    }

    public static float magnitude(Vector3 v)
    {
        return (float) Math.sqrt(
        (
            v.x * v.x +
            v.y * v.y +
            v.z * v.z 
        ));
    }

    public Vector3 normalize()
    {
        return new Vector3
        (
            x / magnitude,
            y / magnitude,
            z / magnitude
        );
    }

    public static Vector3 normalize(Vector3 v)
    {
        return new Vector3
        (
            v.x / magnitude(v),
            v.y / magnitude(v),
            v.z / magnitude(v)
        );
    }

    public static float dot(Vector3 v1, Vector3 v2)
    {
        return (float)
        (
            (v1.x * v2.x) +
            (v1.y * v2.y) +
            (v1.z * v2.z)
        );
    }

    public Vector3 cross(Vector3 v1)
    {
        return new Vector3
        (
            (y * v1.z) - (z * v1.y),
            (z * v1.x) - (x * v1.z),
            (x * v1.y) - (y * v1.x)
        );
    }

    public static Vector3 cross(Vector3 v1, Vector3 v2)
    {
        return new Vector3
        (
            (v1.y * v2.z) - (v1.z * v2.y),
            (v1.z * v2.x) - (v1.x * v2.z),
            (v1.x * v2.y) - (v1.y * v2.x)
        );
    }

    public static Vector3 mul(Vector3 v, float n)
    {
        return new Vector3(v.x * n, v.y * n, v.z * n);
    }

    public Vector3 add(Vector3 v1)
    {
        return new Vector3
        (
            x + v1.x,
            y + v1.y,
            z + v1.z
        );
    }

    public static Vector3 add(Vector3 v1, Vector3 v2)
    {
        return new Vector3
        (
            v1.x + v2.x,
            v1.y + v2.y,
            v1.z + v2.z
        );
    }

    public Vector3 subtract(Vector3 v1)
    {
        return new Vector3
        (
            x - v1.x,
            y - v1.y,
            z - v1.z
        );
    }

    public static Vector3 subtract(Vector3 v1, Vector3 v2)
    {
        return new Vector3
        (
            v1.x - v2.x,
            v1.y - v2.y,
            v1.z - v2.z
        );
    }

    public String toString()
    {
        return (this.x + " " + this.y + " " + this.z);
    }
}
