package Main;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

public class Game_Panel extends JPanel implements Runnable{

    // Sceen Settings
    final int originaltilesize = 16; //16*16 Tiles
    final int scale = 3;

    final int tilesize = originaltilesize * scale; //48 Tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; //16 zu 12
    final int screenwidth = tilesize * maxScreenCol; //768 pixels
    final int screenheight = tilesize * maxScreenRow; //576 pixels

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Set default Position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;




    public Game_Panel() {
        this.setPreferredSize(new Dimension(screenwidth,screenheight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawIntervall = 1000000000/FPS; // 0.01666 Seonds
        double nextDrawTime = System.nanoTime() + drawIntervall;
        long timer = System.nanoTime();
        int drawCount = 0;

        while (gameThread != null) {


            //1 Update: info character positons
            update();
            //2 Draw: draw the screen with updated info
            repaint();
            drawCount++;


            long timer2 = System.nanoTime();
            if (timer2 - timer >= 1000000000){
                System.out.println(drawCount);
                drawCount = 0;
                timer = timer2;
            }


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0 ){
                    remainingTime = 0;
                }

                Thread.sleep((long)  remainingTime);

                nextDrawTime += drawIntervall;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void update() {

        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true){
            playerY += playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tilesize, tilesize);

        g2.dispose();
    }
}

