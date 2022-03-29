package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mesh
{
    ArrayList<Vector3> vertices = new ArrayList<Vector3>();

    ArrayList<Integer> indices = new ArrayList<Integer>();

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

    public ArrayList<Integer> getIndices()
    {
        return this.indices;
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
                    vertices.add(new Vector3(Double.parseDouble(next[1]), Double.parseDouble(next[2]), Double.parseDouble(next[3])));
                }

                //Adds face indices to indices list by splitting row on " " and "/"

                if (next[0].equals("f"))
                {
                    indices.add(Integer.parseInt(next[1]) - 1);
                    indices.add(Integer.parseInt(next[2]) - 1);
                    indices.add(Integer.parseInt(next[3]) - 1);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
