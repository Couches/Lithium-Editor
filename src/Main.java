package src;

public class Main
{
    private static final int WINDOW_WIDTH = 1080;
    private static final int WINDOW_HEIGHT = 720;

    private static Display display = new Display("Lithium Editor", WINDOW_WIDTH, WINDOW_HEIGHT);
    
    public static void main(String[] args)
    {
        GUIHandler guiHandler = new GUIHandler(display);
        
        display.getFrame().setVisible(true);
    }
}
