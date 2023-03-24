import javax.swing.*;
import java.awt.*;

public class Field {
    private Cell[][] cells;

    public Field(int rows, int columns) {
        cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public int getRows() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void update() {
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                int liveNeighbors = countLiveNeighbors(row, col);
                if (cells[row][col].isAlive()) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        cells[row][col].setNextAlive(false);
                    }
                } else {
                    if (liveNeighbors == 3) {
                        cells[row][col].setNextAlive(true);
                    }
                }
            }
        }

        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                cells[row][col].update();
            }
        }
    }

    private int countLiveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int r = (row + i + getRows()) % getRows();
                int c = (col + j + getColumns()) % getColumns();
                if (cells[r][c].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}

