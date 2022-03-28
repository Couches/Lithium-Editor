package src;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileGenerator
{
    String fileName;

    File mapFile;
    FileWriter fileWriter;
    PrintWriter printWriter;

    public void generateFile(String userInput)
    {
        //Properly formats user input to valid name then applies to file
        userInput = userInput.replaceAll(" ", "_");
        
        if (!userInput.contains(".lmsrc"))
            userInput += ".lmsrc";

        this.mapFile = new File(userInput);
    }

    public void openFile(String file)
    {

    }
}
