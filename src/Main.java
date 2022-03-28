package src;

public class Main
{
    private static final int WINDOW_WIDTH = 1080;
    private static final int WINDOW_HEIGHT = 720;

    public static void main(String[] args)
    {
        Display display = new Display("Lithium Editor", WINDOW_WIDTH, WINDOW_HEIGHT);
        GUIHandler guiHandler = new GUIHandler(display);
    }
}
