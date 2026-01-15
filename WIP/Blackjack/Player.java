import java.util.ArrayList;


public class Player {

    private String name;
    private ArrayList<Hand> hands;


    public Player(String name) {
        this.name = name;
    }

    public ArrayList<Hand> getHands() {
        return hands;
    }

    public String getName() {
        return name;
    }
}
