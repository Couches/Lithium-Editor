package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mesh
{
    ArrayList<Vector3> vertices = new ArrayList<Vector3>();

    List<Triangle> triangles = new ArrayList<Triangle>();

    //Constructor for empty mesh

    public Mesh()
    {

    }

    //Constructor for mesh from file

    public Mesh(String src)
    {
        this.newMeshFromOBJ(src);
    }

    public ArrayList<Vector3> getVertices()
    {
        return this.vertices;
    }

    public List<Triangle> getTriangles()
    {
        return this.triangles;
    }

    //Creates mesh from an OBJ file

    public void newMeshFromOBJ(String src)
    {
        File obj = new File(src);

        Scanner scanner = null;

        try
        {
            scanner = new Scanner(obj);

            while (scanner.hasNextLine())
            {
                String next[] = scanner.nextLine().split(" ");

                //Adds vertices to vertice list by splitting row on " "

                if (next[0].equals("v"))
                {
                    vertices.add(new Vector3(Float.parseFloat(next[1]), Float.parseFloat(next[2]), Float.parseFloat(next[3])));
                }

                //Separates face coordinates and adds to face list on "/"

                if (next[0].equals("f"))
                {
                    triangles.add(new Triangle(
                        vertices.get(Integer.parseInt(next[1].split("/")[0]) - 1),
                        vertices.get(Integer.parseInt(next[2].split("/")[0]) - 1),
                        vertices.get(Integer.parseInt(next[3].split("/")[0]) - 1)
                    ));
                }

                
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
