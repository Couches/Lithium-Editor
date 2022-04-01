package src;

public class Matrix4
{
    float _11, _21, _31, _41;
    float _12, _22, _32, _42;
    float _13, _23, _33, _43;
    float _14, _24, _34, _44;

    Vector4 c[] = new Vector4[4];
    
    public Matrix4()
    {
        this(0.0f);
    }

    public Matrix4(float n)
    {
        _11 = n; _21 = n; _31 = n; _41 = n;
        _12 = n; _22 = n; _32 = n; _42 = n;
        _13 = n; _23 = n; _33 = n; _43 = n;
        _14 = n; _24 = n; _34 = n; _44 = n;

        for (int i = 0; i <= 3; i++)
        {
            c[i] = new Vector4(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /**
    * Constructor that takes four Vector4's and converts to floats
    */
    public Matrix4(Vector4 v1, Vector4 v2, Vector4 v3, Vector4 v4)
    {
        _11 = v1.x; _21 = v1.y; _31 = v1.z; _41 = v1.w;
        _12 = v1.x; _22 = v1.y; _32 = v1.z; _42 = v1.w;
        _13 = v1.x; _23 = v1.y; _33 = v1.z; _43 = v1.w;
        _14 = v1.x; _24 = v1.y; _34 = v1.z; _44 = v1.w;

        this.c[0] = v1;
        this.c[1] = v2;
        this.c[2] = v3;
        this.c[3] = v4; 
    }

    /**
    * Multiply the Matrix4 by another Matrix4
    * @param m Matrix4 to multiply
    * @return product of matrices
    */
    public Matrix4 mul(Matrix4 m)
    {
        return new Matrix4
        (
            new Vector4
            (
                (c[0].x * m.c[0].x) + (c[1].x * m.c[0].y) + (c[2].x * m.c[0].z) + (c[3].x * m.c[0].w),
                (c[0].y * m.c[0].x) + (c[1].y * m.c[0].y) + (c[2].y * m.c[0].z) + (c[3].y * m.c[0].w),
                (c[0].z * m.c[0].x) + (c[1].z * m.c[0].y) + (c[2].z * m.c[0].z) + (c[3].z * m.c[0].w),
                (c[0].w * m.c[0].x) + (c[1].w * m.c[0].y) + (c[2].w * m.c[0].z) + (c[3].w * m.c[0].w)
            ),

            new Vector4
            (
                (c[0].x * m.c[1].x) + (c[1].x * m.c[1].y) + (c[2].x * m.c[1].z) + (c[3].x * m.c[1].w),
                (c[0].y * m.c[1].x) + (c[1].y * m.c[1].y) + (c[2].y * m.c[1].z) + (c[3].y * m.c[1].w),
                (c[0].z * m.c[1].x) + (c[1].z * m.c[1].y) + (c[2].z * m.c[1].z) + (c[3].z * m.c[1].w),
                (c[0].w * m.c[1].x) + (c[1].w * m.c[1].y) + (c[2].w * m.c[1].z) + (c[3].w * m.c[1].w)
            ),

            new Vector4
            (
                (c[0].x * m.c[2].x) + (c[1].x * m.c[2].y) + (c[2].x * m.c[2].z) + (c[3].x * m.c[2].w),
                (c[0].y * m.c[2].x) + (c[1].y * m.c[2].y) + (c[2].y * m.c[2].z) + (c[3].y * m.c[2].w),
                (c[0].z * m.c[2].x) + (c[1].z * m.c[2].y) + (c[2].z * m.c[2].z) + (c[3].z * m.c[2].w),
                (c[0].w * m.c[2].x) + (c[1].w * m.c[2].y) + (c[2].w * m.c[2].z) + (c[3].w * m.c[2].w)
            ),

            new Vector4
            (
                (c[0].x * m.c[3].x) + (c[1].x * m.c[3].y) + (c[2].x * m.c[3].z) + (c[3].x * m.c[3].w),
                (c[0].y * m.c[3].x) + (c[1].y * m.c[3].y) + (c[2].y * m.c[3].z) + (c[3].y * m.c[3].w),
                (c[0].z * m.c[3].x) + (c[1].z * m.c[3].y) + (c[2].z * m.c[3].z) + (c[3].z * m.c[3].w),
                (c[0].w * m.c[3].x) + (c[1].w * m.c[3].y) + (c[2].w * m.c[3].z) + (c[3].w * m.c[3].w)
            )
        );
    }

    /**
    * Multiply the Matrix4 by a Vector4
    * @param v Vector4 to multiply
    * @return product
    */
    public Vector4 mul(Vector4 v)
    {
        return new Vector4
        (
            (c[0].x * v.x) + (c[1].x * v.y) + (c[2].x * v.z) + (c[3].x * v.w),
            (c[0].y * v.x) + (c[1].y * v.y) + (c[2].y * v.z) + (c[3].y * v.w),
            (c[0].z * v.x) + (c[1].z * v.y) + (c[2].z * v.z) + (c[3].z * v.w),
            (c[0].w * v.x) + (c[1].w * v.y) + (c[2].w * v.z) + (c[3].w * v.w)
        );
    }

    public static Matrix4 lookAt(Vector3 eye, Vector3 at, Vector3 up)
    {
        Vector3 f = Vector3.normalize(at.subtract(eye));
        Vector3 r = Vector3.normalize(Vector3.cross(f, up));
        Vector3 u = Vector3.cross(r, f);

        return new Matrix4
        (
            new Vector4(r.x, u.x, -f.x, 0.0f),
            new Vector4(r.y, u.y, -f.y, 0.0f),
            new Vector4(r.z, u.z, -f.z, 0.0f),
            new Vector4(-Vector3.dot(r, eye), -Vector3.dot(u, eye), Vector3.dot(f, eye), 1.0f)
        );
    }

    public static Matrix4 perspective(float fov, float aspectRatio, float zNear, float zFar)
    {
        float thFOV = (float)Math.tan(fov / 2.0f);
        
        Matrix4 result = new Matrix4(0.0f);

        result.c[0].x = 1.0f / (aspectRatio * thFOV);
        result.c[1].y = 1.0f / (thFOV);
        result.c[2].z = -(zFar + zNear) / (zFar - zNear);
        result.c[2].w = -1.0f;
        result.c[3].z = -(2.0f * zFar * zNear) / (zFar - zNear);

        return result;
    }

    public Matrix4 rotate(Matrix4 matrix, float angle, Vector3 axis)
    {
        float c = (float) Math.cos(angle);
        float s = (float) Math.sin(angle);

        Vector3 a = Vector3.normalize(axis);
        Vector3 t = Vector3.mul(axis, (1.0f - c));

        Matrix4 rotation = new Matrix4
        (
			new Vector4(c + t.x * a.x, t.x * a.y + s * a.z, t.x * a.z - s * a.y, 0.0f),
			new Vector4(t.y * a.x - s * a.z, c + t.y * a.y, t.x * a.z + s * a.x, 0.0f),
			new Vector4(t.z * a.x + s * a.y, t.z * a.y - s * a.x, c + t.z * a.z, 0.0f),
			new Vector4(0.0f, 0.0f, 0.0f, 1.0f)
		);

        return new Matrix4
        (
			matrix.c[0].mul(rotation.c[0].x).add(matrix.c[1].mul(rotation.c[0].y)).add(matrix.c[2].mul(rotation.c[0].z)),
			matrix.c[0].mul(rotation.c[1].x).add(matrix.c[1].mul(rotation.c[1].y)).add(matrix.c[2].mul(rotation.c[1].z)),
			matrix.c[0].mul(rotation.c[2].x).add(matrix.c[1].mul(rotation.c[2].y)).add(matrix.c[2].mul(rotation.c[2].z)),
			rotation.c[3]
		);
    }

    public Matrix4 scale(Matrix4 matrix, Vector3 scale)
    {
        return new Matrix4
        (
            matrix.c[0].mul(scale.x),
            matrix.c[1].mul(scale.y),
            matrix.c[2].mul(scale.z),
            matrix.c[3]
        );
    }

    public Matrix4 translate(Matrix4 matrix, Vector3 translation)
    {
        return new Matrix4
        (
            matrix.c[0],
            matrix.c[1],
            matrix.c[2],
            
            new Vector4
            (
                matrix.c[3].x + translation.x,
                matrix.c[3].y + translation.y,
                matrix.c[3].z + translation.z,
                matrix.c[3].w
            )
        );
    }
}
 