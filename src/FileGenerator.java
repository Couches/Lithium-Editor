package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileGenerator
{
    String fileName;

    File mapFile;

    String fileInfo = "";

    public void generateFile(String fileName)
    {
        //Properly formats user input to valid name then applies to file
        fileName = fileName.replaceAll(" ", "_");
        
        if (!fileName.contains(".lmsrc"))
            fileName += ".lmsrc";

        this.mapFile = new File(fileName);

        System.out.println(mapFile.getName());
    }

    public void openFile(String filePath)
    {

    }
}
