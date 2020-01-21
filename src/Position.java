public class Position {
    Character ch;
    int lin, col;
    boolean checked;

    Position(int lin, int col,Character c){
        this.lin = lin;
        this.col = col;
        this.ch = c;
        this.checked = false;
    }

    public String toString() {
        return ch.toString() + ":(" + lin + "," + col +")";
    }

    public boolean equals(Position p) {
        return this.ch == p.ch;
    }
}