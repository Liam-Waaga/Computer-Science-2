import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        
        DeckOfCards deck = new DeckOfCards();

        Hand dealer = new Hand();
        ArrayList<Hand> players = new ArrayList<Hand>();
        int num_of_players = -1;

        boolean play_again = true;

        Scanner stdin = new Scanner(System.in);


        deck.shuffle();

        dealer.addCard(deck.dealCard());        
        dealer.addCard(deck.dealCard());

        System.out.printf("TODO, Explain Rules\n");

        
        while (play_again) {
            System.out.printf("How many players? (1-6): ");

            {
                boolean isnt_int;
                while ( (isnt_int = !stdin.hasNextInt()) || (num_of_players = stdin.nextInt()) < 1 || num_of_players > 6) {
                    System.out.printf("Must be a number 1 to 7\nHow many players? (1-6): ");
                    if (isnt_int)
                        stdin.next();
                }
    
            }
            
            System.out.println();
            
            for (int i = 0; i < num_of_players; i++) {
                players.add(new Hand());
                players.get(i).addCard(deck.dealCard());
                players.get(i).addCard(deck.dealCard());
            }

            System.out.printf("Dealers up card is a %s\n", dealer.getCard(0));
    
            for (int i = 0; i < num_of_players; i++) {
                System.out.printf("Player %s has a %s and a %s\n", i + 1, players.get(i).getCard(0), players.get(i).getCard(1));
            }

            System.out.println();

            /* Main player loop */
            for (int i = 0; i < num_of_players; i++) {
                hitstand:
                while (true) {
                    if (players.get(i).calculateHand() == 21) {
                        System.out.printf("Player %s has %s. Your total is %s. You have a Blackjack.\n", i + 1, players.get(i), players.get(i).calculateHand());
                        players.get(i).blackJack();
                        break hitstand;
                    }
                    System.out.printf("Player %s has %s. Your total is %s. Would you like to hit or stand? (h or s): ",
                        i + 1, players.get(i), players.get(i).calculateHand());
                    input:
                    while (true) {
                        String in = stdin.next();
                        
                        if (in.equals("h")) {
                            players.get(i).addCard(deck.dealCard());
                            if (players.get(i).calculateHand() >= 21)
                                break hitstand;
                            break input;
                        } else if (in.equals("s")) {
                            break hitstand;
                        } else {
                            continue input;
                        }
                    }
                }
                if (players.get(i).calculateHand() > 21) {
                    players.get(i).bust();
                    System.out.printf("Player %s has %s. Your total is %s. You have bust.\n", i + 1, players.get(i), players.get(i).calculateHand());
                } else if (players.get(i).calculateHand() == 21) {
                    System.out.printf("Player %s has %s. Your total is %s.\n", i + 1, players.get(i), players.get(i).calculateHand());
                }
                System.out.println();
            }

            while (dealer.calculateHand() < 17)
                dealer.addCard(deck.dealCard());
            if (dealer.calculateHand() > 21)
                dealer.bust();

            for (int i = 0; i < 3; i++) {
                System.out.printf(".");
                try {Thread.sleep(1000);} catch (Exception e) {}
            }
            System.out.println();
            System.out.println();

            // for (int i = 0; i < num_of_players; i++) {
            //     System.out.printf("Player %s has bust: %s\n", i + 1, players.get(i).hasBust());
            // }
            // System.out.printf("Dealer has bust: %s\n", dealer.hasBust());
            if (dealer.hasBust()) {
                System.out.printf("Dealer has %s, and has Bust\n", dealer);
            } else {
                System.out.printf("Dealer has %s, and has %s\n", dealer, dealer.calculateHand());
            }

            for (int i = 0; i < num_of_players; i++) {
                boolean has_won = false;
                boolean has_tied = false;
                String message = "";

                if (players.get(i).hasBust())
                    has_won = false;
                else if (dealer.hasBust())
                    has_won = true;
                else if (players.get(i).calculateHand() > dealer.calculateHand())
                    has_won = true;
                else if (players.get(i).calculateHand() == dealer.calculateHand())
                    has_won = !(has_tied = true);
                else if (players.get(i).calculateHand() < dealer.calculateHand())
                    has_won = false;
                
                if (has_tied)
                    message = "Push";
                else if (players.get(i).hasBlackjack())
                    message = "Blackjack";
                else if (players.get(i).hasBust())
                    message = "Bust";
                else if (has_won)
                    message = "Won";

                System.out.printf("Player %s has %s\n", i + 1, message);
            }

            play_again = false;
        }

        stdin.close();
    }
}