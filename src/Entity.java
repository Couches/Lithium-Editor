package src;

public class Entity
{
    private Mesh mesh;

    public Matrix4 matrix = new Matrix4(
        new Vector4(.1f, 0.0f, 0.0f, 0.0f),
        new Vector4(0.0f, .1f, 0.0f, 0.0f),
        new Vector4(0.0f, 0.0f, .1f, 0.0f),
        new Vector4(0.0f, 0.0f, 0.0f, 1f)
    );

    public Vector3 translation;
    public Vector3 scale;
    public Vector3 rotation;

    public Entity(Mesh mesh, Vector3 rotation, Vector3 scale, Vector3 translation)
    {
        this.mesh = mesh;

        this.translation = translation;
        this.rotation = rotation;
        this.scale = scale;
    }

    //Getters

    public Mesh getMesh()
    {
        return this.mesh;
    }

    public Vector3 getTranslation()
    {
        return translation;
    }

    public Vector3 getScale()
    {
        return scale;
    }

    public Vector3 getRotation()
    {
        return rotation;
    }
}
