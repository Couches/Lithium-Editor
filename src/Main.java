package src;

public class Main
{
    public static final int WINDOW_WIDTH = 1080;
    public static final int WINDOW_HEIGHT = 720;

    public static void main(String[] args)
    {
        Display display = new Display("Lithium Editor", WINDOW_WIDTH, WINDOW_HEIGHT);
        GUIHandler guiHandler = new GUIHandler(display);
        
        Matrix4 matrix = new Matrix4(
            new Vector4(1, 5, 9, 4), 
            new Vector4(2, 6, 1, 5),
            new Vector4(3, 7, 2, 6),
            new Vector4(4, 8, 3, 7)
        );
    }
}
