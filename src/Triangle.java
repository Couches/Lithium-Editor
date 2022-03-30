package src;

public class Triangle
{
    public Vector3 triangle[] = new Vector3[3];

    public Triangle()
    {
        triangle[0] = new Vector3(0, 0, 0);
        triangle[1] = new Vector3(0, 0, 0);
        triangle[2] = new Vector3(0, 0, 0);
    }

    public Triangle(Vector3 point1, Vector3 point2, Vector3 point3)
    {
        triangle[0] = point1;
        triangle[1] = point2;
        triangle[2] = point3;
    }
}
