import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Field field = new Field(50, 50);
        GridPanel gridPanel = new GridPanel(field);
        frame.getContentPane().add(gridPanel);
        frame.pack();
        frame.pack();
        frame.setVisible(true);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            field.update();
            gridPanel.repaint();
        }
    }
}