import java.util.ArrayList;


public class Player {

    private String name;
    private ArrayList<Hand> hands;


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
}
