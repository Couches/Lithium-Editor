package src;

public class Vector4
{
    public float x, y, z, w;

    public Vector4()
    {
        this(0, 0, 0, 0);
    }

    public Vector4(float x, float y, float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(float n)
    {
        this.x = n;
        this.y = n;
        this.z = n;
        this.w = n;
    }

    public Vector4(Vector4 v)
    {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.w = v.w;
    }

    public Vector4(Vector3 v, float w)
    {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.w = w;
    }

    public float magnitude()
    {
        return (float) Math.sqrt(
        (
            x * x +
            y * y +
            z * z 
        ));
    }

    public static float magnitude(Vector4 v)
    {
        return v.magnitude();
    }

    public Vector4 normalize()
    {
        float magnitude = magnitude();
        return new Vector4
        (
            x / magnitude,
            y / magnitude,
            z / magnitude,
            w / magnitude
        );
    }

    public static Vector4 normalize(Vector4 v)
    {
        return v.normalize();
    }

    public static float dot(Vector4 v1, Vector4 v2)
    {
        return
            (v1.x * v2.x) +
            (v1.y * v2.y) +
            (v1.z * v2.z) +
            (v1.w * v2.w);
    }

    public static Vector4 cross(Vector4 v1, Vector4 v2)
    {
        return new Vector4
        (
            (v1.y * v2.z) - (v1.z * v2.y),
            (v1.x * v2.z) - (v1.z * v2.x),
            (v1.x * v2.y) - (v1.y * v2.x),
            (float) Math.sqrt(v1.w * v1.w)
        );
    }

    public Vector4 add(Vector4 v1)
    {
        return new Vector4
        (
            x + v1.x,
            y + v1.y,
            z + v1.z,
            w + v1.w
        );
    }

    public static Vector4 add(Vector4 v1, Vector4 v2)
    {
        return new Vector4
        (
            v1.x + v2.x,
            v1.y + v2.y,
            v1.z + v2.z,
            v1.w + v2.w
        );
    }

    public Vector4 mul(Vector4 other)
    {
        return new Vector4(x * other.x, y * other.y, z * other.z, w * other.w);
    }

    public String toString()
    {
        return (this.x + " " + this.y + " " + this.z + " " + this.w);
    }

    public Vector4 mul(float n)
    {
        return new Vector4(this.x * n, this.y * n, this.z * n, this.w * n);
    }
}
