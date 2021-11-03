import java.awt.*;
import javax.swing.*;

public class Start {
    static int SCALE = 32;
    static int WIDTH = 11;
    static int HEIGHT = 20;
    private Start(int WIDTH, int HEIGHT)
    {
        JFrame window = new JFrame("Tetris");
        window.setSize(WIDTH*SCALE+6+(SCALE*4),HEIGHT*SCALE+28);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));
        window.setIconImage(image);
        window.add(new Panel());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
    public static void main(String[] args) {SwingUtilities.invokeLater(() -> new Start(11,20));}
}
