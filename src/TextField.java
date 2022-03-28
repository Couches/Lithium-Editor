package src;

import java.awt.Dimension;

import javax.swing.JTextArea;

public class TextField
{
    JTextArea textField = new JTextArea("Hello! Open or create a new map to start.");

    public TextField(Display display)
    {
        textField.setSize(new Dimension(500, 500));

        display.getPanel().add(textField);
    }
}
