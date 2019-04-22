import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] argv) {
        Grid g = new Grid();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(0,0,100,200);
        JLabel grid = new JLabel(g.getGrid());
        frame.getContentPane().add(grid,BorderLayout.CENTER);
        grid.setHorizontalAlignment(SwingConstants.CENTER);
        grid.setVerticalAlignment(SwingConstants.CENTER);
        JLabel coords = new JLabel(g.point.getCoords());
        frame.getContentPane().add(coords,BorderLayout.PAGE_END);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==27){
                    frame.dispose();
                }else if(e.getKeyCode()==32){
                    g.toggleBorder();
                    grid.setText(g.getGrid());
                }else{
                    g.point.move(e.getKeyCode());
                    grid.setText(g.getGrid());
                    coords.setText(g.point.getCoords());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}