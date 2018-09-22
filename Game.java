
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to roulette!");
        System.out.println("Please enter your name: ");
        String name = in.nextLine();
        Player player1 = new Player(name);
        Table game = new Table();
        game.setNumbers();
        System.out.println("Welcome " + player1.getName());
        boolean quit = false;
        int userSelection, userChoiceInteger, userBets, ballSpin;


        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Play a game of roulette ");
            System.out.println("2. View amount of chips you have ");
            System.out.println("0. Quit game ");
            userSelection = in.nextInt();
            in.nextLine();
            switch (userSelection) {
                case 1:
                    if(player1.getNumberOfChips() == 0){
                        System.out.println("You have ran out of chips and can no longer play. ");
                        break;
                    }
                    Table newGame = new Table();
                    newGame.setNumbers();
                    System.out.println("Would you like to play inside or outside? (1 for inside, 2 for outside) ");
                    int insideOrOut = in.nextInt();
                    if (insideOrOut == 1) {
                        System.out.println("Which number would you like to bet on?");
                        userChoiceInteger = in.nextInt();
                        userBets = player1.makeBet(player1);
                        System.out.println("Wheel spinning...");
                        ballSpin = game.randomNumber();

                        player1.straightUpBet(userChoiceInteger, ballSpin, userBets, player1);

                    } else {
                        System.out.println("Which of the following would you like to bet on? ");
                        System.out.println("1. Red/Black");
                        System.out.println("2. Even/Odd");
                        System.out.println("3. Column Bet");
                        System.out.println("4. 1-18 or 19-36");
                        int userOutsideSelection = in.nextInt();
                        in.nextLine();
                        switch (userOutsideSelection) {
                            case 1:
                                System.out.println("Which color would you like to bet on? (Enter 'red' or 'black') ");
                                String userColorChoice = in.nextLine();
                                userBets = player1.makeBet(player1);
                                System.out.println("Wheel spinning...");
                                ballSpin = game.randomNumber();

                                player1.colorBet(userColorChoice, ballSpin, userBets, player1, game);
                                break;
                            case 2:
                                System.out.println("Would you like to bet on even or odd? (Enter 'even' or 'odd') ");
                                String evenOrOddChoice = in.nextLine();
                                userBets = player1.makeBet(player1);
                                System.out.println("Wheel spinning...");
                                ballSpin = game.randomNumber();

                                player1.evenOrOddsBet(evenOrOddChoice, ballSpin, userBets, player1);
                                break;
                            case 3:
                                System.out.println("Which column would you like to bet on?");
                                System.out.println("1.  1-12");
                                System.out.println("2.  13-24");
                                System.out.println("3.  25-36");
                                userChoiceInteger = in.nextInt();
                                userBets = player1.makeBet(player1);
                                System.out.println("Wheel spinning...");
                                ballSpin = game.randomNumber();

                                player1.columnsBet(userChoiceInteger, ballSpin, userBets, player1);
                                break;
                            case 4:
                                System.out.println("Which would you like to bet on?");
                                System.out.println("1.  1-18");
                                System.out.println("2.  19-36");
                                userChoiceInteger = in.nextInt();
                                userBets = player1.makeBet(player1);
                                System.out.println("Wheel spinning...");
                                ballSpin = game.randomNumber();

                                player1.firstOrSecondEighteenBet(userChoiceInteger, ballSpin, userBets, player1);
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println(player1.getNumberOfChips());
                    break;
                case 0:
                    quit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("That is not a valid selection.");
                    break;
            }
        } while (quit != true);


    }


}
