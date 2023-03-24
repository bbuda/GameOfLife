public class Cell {
    private boolean alive;
    private boolean nextAlive;

    public Cell() {
        alive = Math.random() < 0.5;
        nextAlive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setNextAlive(boolean nextAlive) {
        this.nextAlive = nextAlive;
    }

    public void update() {
        alive = nextAlive;
        nextAlive = false;
    }
}