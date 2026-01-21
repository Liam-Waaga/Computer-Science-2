import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private Card doubleDownCard = null;
    private boolean hasBust = false;
    private boolean blackJack = false;
    private boolean isSplit = false;

    private boolean runHasWon = false;

    private int bet = 0;
    private int insuranceBet = 0;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void doubleDown(Card card) {
        this.bet *= 2;
        this.doubleDownCard = card;
    }

    public boolean hasDoubledDown() {
        return doubleDownCard != null;
    }

    public void setInitialBet(int bet) {
        if (this.bet == 0)
            this.bet = bet;
    }

    public int getBet() {
        return bet;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int getNumOfCards() {
        return cards.size();
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public int calculateHand() {
        int aces = 0;
        int total = 0;
        for (int i = 0; i < cards.size(); i++) {
            String val = cards.get(i).getFace();
            if (val.equals("Ace"))
                aces++;
            else if (val.equals("Deuce"))
                total += 2;
            else if (val.equals("Three"))
                total += 3;
            else if (val.equals("Four"))
                total += 4;
            else if (val.equals("Five"))
                total += 5;
            else if (val.equals("Six"))
                total += 6;
            else if (val.equals("Seven"))
                total += 7;
            else if (val.equals("Eight"))
                total += 8;
            else if (val.equals("Nine"))
                total += 9;
            else if (val.equals("Ten"))
                total += 10;
            else if (val.equals("Jack"))
                total += 10;
            else if (val.equals("Queen"))
                total += 10;
            else if (val.equals("King"))
                total += 10;
        }
        total += aces;
        while (aces > 0) {
            if (total + 10 <= 21) {
                aces--;
                total += 10;
            } else {
                break;
            }
        }
        return total;
    }

    public String toString() {
        if (cards.size() == 0)
            return "nothing";
        String out = "a " + cards.get(0).toString();
        for (int i = 1; i < cards.size(); i++) {
            out += " and a " + cards.get(i).toString();
        }
        if (doubleDownCard != null)
            out += " and a double down card";

        return out;
    }

    public void bust() {
        this.hasBust = true;
    }

    public void blackJack() {
        this.blackJack = true && !isSplit;
    }

    public boolean hasBust() {
        return this.hasBust;
    }

    public boolean hasBlackjack() {
        return this.blackJack;
    }

    public boolean canSplit() {
        return getNumOfCards() == 2 && this.cards.get(0).equals(this.cards.get(1));
    }

    public Hand split() {
        Hand other = new Hand();
        other.addCard(this.cards.remove(1));
        this.isSplit = true;
        other.isSplit = true;

        other.bet = this.bet;
        return other;
    }

    public boolean isSplit() {
        return isSplit;
    }

    public void playDealer(DeckOfCards deck) {
        /* if it is 21 off the bat, deal must have a blackjack */
        if (calculateHand() == 21)
            blackJack();

        /* play until hand value >17 */
        while (calculateHand() < 17)
            addCard(deck.dealCard());

        /* see if we bust */
        if (calculateHand() > 21)
            bust();
    }

    public String hasWon(Hand dealer, Player player) {
        if (doubleDownCard != null) {
            cards.add(doubleDownCard);
        }
        
        if (hasBust()) {
            this.runHasWon = true;
            return "Bust";
        } else if (calculateHand() == dealer.calculateHand()) {
            if (!this.runHasWon) player.addChips(this.bet);
            this.runHasWon = true;
            return "Pushed";
        } else if (hasBlackjack()) {
            if (!this.runHasWon) player.addChips((int)(this.bet * 2.5));
            this.runHasWon = true;
            return "Blackjack";
        } else if (dealer.hasBust()) {
            if (!this.runHasWon) player.addChips(this.bet * 2);
            this.runHasWon = true;
            return "Won";
        } else if (calculateHand() > dealer.calculateHand()) {
            if (!this.runHasWon) player.addChips(this.bet * 2);
            this.runHasWon = true;
            return "Won";
        } else {
            this.runHasWon = true;
            return "Lost";
        }
    }

    public void insuranceBet(int bet) {
        this.insuranceBet = Math.min(bet, this.bet / 2);
    }

    public int getInsuranceBet() {
        return this.insuranceBet;
    }
}