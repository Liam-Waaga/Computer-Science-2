import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        
        
        int num_of_players = -1;
        
        boolean play_again = true;
        
        Scanner stdin = new Scanner(System.in);
        
        System.out.printf("If you don't know the full rules of casino blackjack, look at them here\nhttps://bicyclecards.com/how-to-play/blackjack\n");
        
        ArrayList<Player> players = new ArrayList<Player>();
        
        System.out.printf("How many players? (1-9): ");
        
        {
            boolean isnt_int;
            while ((isnt_int = !stdin.hasNextInt()) || (num_of_players = stdin.nextInt()) < 1 || num_of_players > 9) {
                System.out.printf("How many players? (1-9): ");
                if (isnt_int)
                    stdin.next();
            }

        }
        System.out.printf("Now agree among yourselves the betting limits\n");
        System.out.println();

        for (int i = 0; i < num_of_players; i++) {
            System.out.printf("Player %s what is your name?: ", i + 1);
            players.add(new Player(stdin.next()));
            
            int chips;
            while (true) {
                System.out.printf("%s how many chips do you have?: ", players.get(i));
                if (stdin.hasNextInt()) {
                    chips = Math.abs(stdin.nextInt());
                    break;
                } else {
                    stdin.next();
                }
            }
            players.get(i).setChips(chips);
            System.out.println();
        }
        
        while (play_again) {

            for (int i = 0; i < num_of_players; i++) {
                if (players.get(i).getChips() <= 0) {
                    System.out.printf("%s has lost all their chips, they can no longer play\n", players.remove(i--));
                    num_of_players--;
                }
            }
            
            Player dealer = new Player("Dealer");
            
            DeckOfCards deck = new DeckOfCards();
            
            deck.shuffle();
            
            dealer.getHands().add(new Hand());
            
            dealer.getHands().get(0).addCard(deck.dealCard());
            dealer.getHands().get(0).addCard(deck.dealCard());
            
            if (dealer.getHands().get(0).calculateHand() == 21)
                dealer.getHands().get(0).blackJack();
            
            
            
            for (int i = 0; i < num_of_players; i++) {
                players.get(i).getHands().add(new Hand());
                players.get(i).getHands().get(0).addCard(deck.dealCard());
                players.get(i).getHands().get(0).addCard(deck.dealCard());
        
                if (players.get(i).getHands().get(0).calculateHand() == 21) {
                    players.get(i).getHands().get(0).blackJack();
                }

                int bet;
                while (true) {
                    System.out.printf("%s what would you like your bet to be? You have %s chips: ",
                        players.get(i), players.get(i).getChips());
                    if (stdin.hasNextInt()) {
                        if ((bet = stdin.nextInt()) <= 0 || bet > players.get(i).getChips())
                            continue;
                        players.get(i).addChips(-bet);
                        players.get(i).getHands().get(0).setInitialBet(bet);
                        break;
                    } else {
                        stdin.next();
                    }
                }
            }

            System.out.println();

            
            for (int i = 0; i < num_of_players; i++) {
                System.out.printf("%s has a %s and a %s\n",
                    players.get(i).getName(), 
                    players.get(i).getHands().get(0).getCard(0),
                    players.get(i).getHands().get(0).getCard(1)
                );
            }

            System.out.printf("Dealers up card is a %s\n", dealer.getHands().get(0).getCard(0));

            if (dealer.getHands().get(0).getCard(0).getFace().equals("Ace")) {
                for (int i = 0; i < num_of_players; i++) {
                    int bet = -1;
                    while (true) {
                        System.out.printf("%s, would you like an insurance bet? (0-%s): ", players.get(i), players.get(i).getHands().get(0).getBet() / 2);
                        if (stdin.hasNextInt()) {
                            bet = stdin.nextInt();
                            if (bet >= 0 && bet <= players.get(i).getHands().get(0).getBet() / 2 && bet <= players.get(i).getChips())
                                break;
                        } else {
                            stdin.next();
                        }
                    }
                    players.get(i).addChips(-bet);
                    players.get(i).getHands().get(0).insuranceBet(bet);
                }
            }

            if (dealer.getHands().get(0).hasBlackjack()) {
                System.out.printf("Dealer has a Blackjack\n");
                for (int i = 0; i < num_of_players; i++) {
                    System.out.printf("You have won %s from insurance betting.\n",
                        players.get(i).getHands().get(0).getInsuranceBet());
                    players.get(i).addChips(players.get(i).getHands().get(0).getInsuranceBet());
                }
            }

            if (dealer.getHands().get(0).getCard(0).getFace().equals("Ace")
                && !dealer.getHands().get(0).hasBlackjack()) {
                    System.out.printf("Everyone has lost insurance bets\n");
            }


            System.out.println();

            /* Main player loop */
            for (int i = 0; i < num_of_players; i++) {
                if (dealer.getHands().get(0).hasBlackjack())
                    break;
                for (int j = 0; j < players.get(j).getHands().size(); j++) {
                    hitstand:
                    while (true) {
                        if (!players.get(i).getHands().get(0).isSplit() &&
                            players.get(i).getChips() >= players.get(i).getHands().get(0).getBet() &&
                            players.get(i).getHands().get(0).calculateHand() > 8 &&
                            players.get(i).getHands().get(0).calculateHand() < 12) {
                                String in = "";
                                while (true) {
                                    System.out.printf("%s would you like to double down? (y/n): ", players.get(i));
                                    in = stdin.next();
                                    if (in.equals("y")) {
                                        int bet = players.get(i).getHands().get(0).getBet();
                                        players.get(i).addChips(-bet);
                                        players.get(i).getHands().get(0).doubleDown(deck.dealCard());
                                        break hitstand;
                                    } else if (in.equals("n")) {
                                        break;
                                    }
                                }
                        }
                        if (players.get(i).getHands().get(j).calculateHand() == 21) {
                            System.out.printf("%s's hand %s has %s. Your total is %s. You have a Blackjack.\n", 
                                players.get(i).getName(), j + 1, players.get(i), players.get(i).getHands().get(j).calculateHand());
                            players.get(i).getHands().get(j).blackJack();
                            break hitstand;
                        }
                        if (players.get(i).getHands().get(j).canSplit()) {
                            input:
                            while (true) {
                                System.out.printf("You have a %s. Do you want to split?: (y/n): ", players.get(i).getHands().get(j));
                                String in = stdin.next();
                                
                                if (in.equals("y")) {

                                    players.get(i).getHands().add(players.get(i).getHands().get(j).split());

                                    players.get(i).getHands().get(j).addCard(deck.dealCard());
                                    players.get(i).getHands().get(j + 1).addCard(deck.dealCard());

                                    if (players.get(i).getHands().get(j).getCard(0).getFace().equals("Ace")) {
                                        j++;
                                        break hitstand;
                                    }

                                    continue hitstand;

                                } else if (in.equals("n")) {
                                    break input;
                                } else {
                                    continue input;
                                }
                            }
                        }
                        System.out.printf("%s's hand %s has %s. Your total is %s. Would you like to hit or stand? (h or s): ",
                            players.get(i).getName(), j + 1, players.get(i).getHands().get(j), players.get(i).getHands().get(j).calculateHand());
                        input:
                        while (true) {
                            String in = stdin.next();
                            
                            if (in.equals("h")) {
                                players.get(i).getHands().get(j).addCard(deck.dealCard());
                                if (players.get(i).getHands().get(j).calculateHand() >= 21)
                                    break hitstand;
                                break input;
                            } else if (in.equals("s")) {
                                break hitstand;
                            } else {
                                continue input;
                            }
                        }
                    }
                    if (!players.get(i).getHands().get(j).hasDoubledDown()) {
                        if (players.get(i).getHands().get(j).calculateHand() > 21) {
                            players.get(i).getHands().get(j).bust();
                            System.out.printf("%s's hand %s has %s. Your total is %s. You have bust.\n", players.get(i).getName(), j + 1, players.get(i).getHands().get(j), players.get(i).getHands().get(j).calculateHand());
                        } else if (players.get(i).getHands().get(j).calculateHand() == 21) {
                            System.out.printf("%s's hand %s has %s. Your total is %s.\n", players.get(i).getName(), j + 1, players.get(i), players.get(i).getHands().get(j).calculateHand());
                        }
                    } else {
                        System.out.printf("%s's hand %s has %s. Your total is %s. You have also doubled down.\n", players.get(i).getName(), j + 1, players.get(i).getHands().get(j), players.get(i).getHands().get(j).calculateHand());
                    }
                    System.out.println();
                }
            }

            dealer.getHands().get(0).playDealer(deck);

            for (int i = 0; i < 3; i++) {
                System.out.printf(".");
                try {Thread.sleep(1000);} catch (Exception e) {}
            }

            System.out.println();
            System.out.println();

            if (dealer.getHands().get(0).hasBust()) {
                System.out.printf("Dealer has %s, and has Bust\n", dealer.getHands().get(0));
            } else {
                System.out.printf("Dealer has %s, and has %s\n", dealer.getHands().get(0), dealer.getHands().get(0).calculateHand());
            }

            for (int i = 0; i < num_of_players; i++) {
                for (int j = 0; j < players.get(i).getHands().size(); j++) {
                    System.out.printf("%s's hand %s has %s\n",
                        players.get(i).getName(), j + 1,
                        players.get(i).getHands().get(j).hasWon(dealer.getHands().get(0), players.get(i)));
                }
            }
            play_again = false;
            System.out.printf("Would you like to keep playing?: (Y/n): ");            
            if (!stdin.next().equals("n"))
                play_again = true;
            for (int i = 0; i < num_of_players; i++)
                players.get(i).clearHands();
            System.out.println();

        }

        stdin.close();
    }
}