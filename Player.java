
import java.util.Scanner;

public class Player {

    private String name;
    private int numberOfChips;


    public Player(String name){
        this.name = name;
        numberOfChips = 100;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfChips() {
        return numberOfChips;
    }

    //inside bet
    //Player bets on a certain number 0-36
    //pays 35:1
    public int straightUpPayout(int n, boolean win){
        if(win){
            return winChips(n * 35);
        } else {
            return loseChips(n);
        }
    }

    public void straightUpBet(int userChoiceInteger, int ballSpin, int userBets, Player player){


        if (userChoiceInteger == ballSpin) {
            System.out.println("The ball landed on " + ballSpin + "\nYou win!\n");
            player.straightUpPayout(userBets, true);
        } else {
            System.out.println("The ball landed on " + ballSpin + "\nYou lose.\n");
            player.straightUpPayout(userBets, false);
        }
    }


    //outside bet
    //Player bets on a certain color. RED or BLACK
    //pays 1:1
    public int colorBetPayout(int n, boolean win){
        if(win){
            return winChips(n);
        } else {
            return loseChips(n);
        }
    }

    public void colorBet(String userChoice, int ballSpin, int userBets, Player player, Table game){


        if (userChoice.toUpperCase().equals(game.getRoulette().get(ballSpin))) {
            System.out.println("The ball landed on " + ballSpin + ", " + game.getRoulette().get(ballSpin) + "\nYou win!\n");
            player.colorBetPayout(userBets, true);
        } else {
            System.out.println("The ball landed on " + ballSpin + ", " + game.getRoulette().get(ballSpin) + "\nYou lose.\n");
            player.colorBetPayout(userBets, false);
        }
    }


    //outside bet
    //Player bets on if a ball will land on either an even or odd number
    //pays 1:1
    public int evenOrOddsPayout(int n, boolean win){
        if(win){
            return winChips(n);
        } else {
            return loseChips(n);
        }
    }

    public void evenOrOddsBet(String userChoice, int ballSpin, int userBets, Player player){
        if (userChoice.toUpperCase().equals("EVEN")) {
            if (ballSpin % 2 == 0) {
                System.out.println("The ball landed on " + ballSpin + "\nYou win!\n");
                player.evenOrOddsPayout(userBets, true);
            } else {
                System.out.println("The ball landed on " + ballSpin + "\nYou lose.\n");
                player.evenOrOddsPayout(userBets, false);
            }
        } else if (userChoice.toUpperCase().equals("ODD")) {
            if (ballSpin % 2 == 1) {
                System.out.println("The ball landed on " + ballSpin + "\nYou win!\n");
                player.evenOrOddsPayout(userBets, true);
            } else {
                System.out.println("The ball landed on " + ballSpin + "\nYou lose.\n");
                player.evenOrOddsPayout(userBets, false);
            }
        }
    }




    //outside bet
    //Player bets on if ball will land on a number either 1-18 or 19-36
    //pays 1:1
    public int firstOrSecondEighteenPayout(int n, boolean win){
        if(win){
            return winChips(n);
        } else {
            return loseChips(n);
        }
    }

    public void firstOrSecondEighteenBet(int userChoiceInteger, int ballSpin, int userBets, Player player){

        if ((userChoiceInteger == 1 && ballSpin > 0 && ballSpin <= 18) || (userChoiceInteger == 2 && ballSpin > 18 && ballSpin <= 36)) {
            System.out.println("The ball landed on " + ballSpin + "\nYou win!\n");
            player.firstOrSecondEighteenPayout(userBets, true);

        } else {
            System.out.println("The ball landed on " + ballSpin + "\nYou lose.\n");
            player.firstOrSecondEighteenPayout(userBets, false);

        }
    }

    //outside bet
    //Player bets on if ball will land on either 1-12, 13-24, 25-36
    //pays 2:1
    public int columnsBetPayout(int n, boolean win){
        if(win){
            return winChips(n*2);
        } else {
            return loseChips(n);
        }
    }

    public void columnsBet(int userChoiceInteger, int ballSpin, int userBets, Player player){
        switch (userChoiceInteger) {
            case 1:
                if (ballSpin > 0 && ballSpin <= 12) {
                    System.out.println("The ball landed on " + ballSpin + "\nYou win!\n");
                    player.columnsBetPayout(userBets, true);
                } else {
                    System.out.println("The ball landed on " + ballSpin + "\nYou lose.\n");
                    player.columnsBetPayout(userBets, false);
                }
                break;
            case 2:
                if (ballSpin > 12 && ballSpin <= 24) {
                    System.out.println("The ball landed on " + ballSpin + "\nYou win!\n");
                    player.columnsBetPayout(userBets, true);
                } else {
                    System.out.println("The ball landed on " + ballSpin + "\nYou lose.\n");
                    player.columnsBetPayout(userBets, false);
                }
                break;
            case 3:
                if (ballSpin > 24 && ballSpin <= 36) {
                    System.out.println("The ball landed on " + ballSpin + "\nYou win!\n");
                    player.columnsBetPayout(userBets, true);
                } else {
                    System.out.println("The ball landed on " + ballSpin + "\nYou lose.\n");
                    player.columnsBetPayout(userBets, false);
                }
                break;
            default:
                System.out.println("Not a valid selection.");
                break;
        }
    }



    public int makeBet(Player player){
        Scanner in = new Scanner(System.in);
        System.out.println("How much would you like to bet?");
        int amount = in.nextInt();
        while(amount < 1 || amount > player.getNumberOfChips()){
            System.out.println("That is not a valid amount. Please try again");
            System.out.println("How much would you like to bet?");
            amount = in.nextInt();
        }
        return amount;
    }


    //payout when player wins a game
    public int winChips(int n){
        return numberOfChips += n;
    }

    //when a player loses a game
    public int loseChips(int n){
        return numberOfChips -= n;
    }

}
