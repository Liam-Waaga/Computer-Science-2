import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        
        
        int num_of_players = -1;
        
        boolean play_again = true;
        
        Scanner stdin = new Scanner(System.in);
        
        
        System.out.printf("TODO, Explain Rules\n");
        
        
        while (play_again) {

            Player dealer = new Player("Dealer");
            ArrayList<Player> players = new ArrayList<Player>();

            DeckOfCards deck = new DeckOfCards();
    
            deck.shuffle();
    
            dealer.getHands().add(new Hand());
    
            dealer.getHands().get(0).addCard(deck.dealCard());
            dealer.getHands().get(0).addCard(deck.dealCard());
            System.out.printf("How many players? (1-6): ");

            {
                boolean isnt_int;
                while ( (isnt_int = !stdin.hasNextInt()) || (num_of_players = stdin.nextInt()) < 1 || num_of_players > 6) {
                    System.out.printf("Must be a number 1 to 6\nHow many players? (1-6): ");
                    if (isnt_int)
                        stdin.next();
                }
    
            }
            
            System.out.println();
            
            for (int i = 0; i < num_of_players; i++) {
                System.out.printf("What is your name?: ");
                players.add(new Player(stdin.next()));
                players.get(i).getHands().add(new Hand());
                players.get(i).getHands().get(0).addCard(deck.dealCard());
                players.get(i).getHands().get(0).addCard(deck.dealCard());
            }

            System.out.println();

            System.out.printf("Dealers up card is a %s\n", dealer.getHands().get(0).getCard(0));
    
            for (int i = 0; i < num_of_players; i++) {
                System.out.printf("%s has a %s and a %s\n",
                    players.get(i).getName(), 
                    players.get(i).getHands().get(0).getCard(0),
                    players.get(i).getHands().get(0).getCard(1)
                );
            }

            System.out.println();

            /* Main player loop */
            for (int i = 0; i < num_of_players; i++) {
                for (int j = 0; j < players.get(j).getHands().size(); j++) {
                    hitstand:
                    while (true) {
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

                                    continue hitstand;

                                } else if (in.equals("n")) {
                                    break input;
                                } else {
                                    continue;
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
                    if (players.get(i).getHands().get(j).calculateHand() > 21) {
                        players.get(i).getHands().get(j).bust();
                        System.out.printf("%s's hand %s has %s. Your total is %s. You have bust.\n", players.get(i).getName(), j + 1, players.get(i).getHands().get(j), players.get(i).getHands().get(j).calculateHand());
                    } else if (players.get(i).getHands().get(j).calculateHand() == 21) {
                        System.out.printf("%s's hand %s has %s. Your total is %s.\n", players.get(i).getName(), j + 1, players.get(i), players.get(i).getHands().get(j).calculateHand());
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
                        players.get(i).getHands().get(j).hasWon(dealer.getHands().get(0)));
                }
            }
            play_again = false;
            System.out.printf("Would you like to play again?: (y/n): ");            
            if (stdin.next().equals("y"))
                play_again = true;

        }

        stdin.close();
    }
}