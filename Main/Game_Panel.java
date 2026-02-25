package Main;

import javax.swing.*;
import java.awt.*;

public class Game_Panel extends JPanel {

    // Sceen Settings
    final int originaltilesize = 16; //16*16 Tiles
    final int scale = 3;

    final int tilesize = originaltilesize * scale; //48 Tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; //16 zu 12
    final int screenwidth = tilesize * maxScreenCol; //768 pixels
    final int screenheight = tilesize * maxScreenRow; //576 pixels

    public Game_Panel() {
        this.setPreferredSize(new Dimension(screenwidth,screenheight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
}
