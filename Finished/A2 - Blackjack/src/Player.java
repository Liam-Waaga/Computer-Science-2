import java.util.ArrayList;


public class Player {

    private String name;
    private ArrayList<Hand> hands;

    private int chips = 0;

    public void addChips(int chips) {
        this.chips += chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getChips() {
        return chips;
    }

    public Player(String name) {
        this.name = name;
        this.hands = new ArrayList<Hand>();
    }

    public ArrayList<Hand> getHands() {
        return hands;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }

    public void clearHands() {
        hands = new ArrayList<Hand>();
    }
}
