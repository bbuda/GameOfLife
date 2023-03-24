import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private Field field;
    public GridPanel(Field field) {
        this.field = field;
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = Math.min(getWidth() / field.getColumns(), getHeight() / field.getRows());
        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getColumns(); col++) {
                if (field.getCell(row, col).isAlive()) {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
            }
        }
    }
}