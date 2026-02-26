package Main;

import javax.swing.*;

public class Game {
    public static void main(String[]args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        Game_Panel gamepanel = new Game_Panel();
        window.add(gamepanel);

        window.pack();


        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
