package src;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextField
{
    JTextArea textField = new JTextArea("Hello! Open or create a new map to start.");

    public TextField(Display display)
    {
        display.getPanel().add(textField);
    }
}
