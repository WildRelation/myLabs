import cardmodel.Card;
import cardmodel.Pile;
import psmodel.PsLogic;

import java.util.Scanner;

public class PsUserInterface {
    private PsLogic myGame;
    private Scanner scanner;


    public PsUserInterface() {
        myGame = new PsLogic();
        scanner = new Scanner(System.in);
    }

    // Startar användargränssnittet och spelet
    public void start() {
        boolean exit = false;

        while (!exit) {
            showMenu();
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "N":
                    startNewGame();
                    break;
                case "X":
                    exit = true;
                    System.out.println("Exiting game...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 'N' or 'X'.");
            }
        }
    }

    // Visar menyn
    private void showMenu() {
        System.out.println("---Menu---");
        System.out.println("N New Game");
        System.out.println("X Exit");
        System.out.println("-----------");
    }

    // Startar ett nytt spel
    private void startNewGame() {
        System.out.println("N");
        System.out.println("New game...");
        myGame.initNewGame();
        System.out.println("Ready.");

        while (!myGame.isGameOver()) {
            showGameState();
            Card nextCard = myGame.pickNextCard();
            System.out.println("\nNext card: " + nextCard);

            // Hantera användarens val med undantagshantering
            boolean cardPlaced = false;
            while (!cardPlaced) {
                try {
                    System.out.print("Select a pile [0..4]: ");
                    int pileIndex = readPileIndex();
                    myGame.addCardToPile(pileIndex);
                    cardPlaced = true;  // Kortet har placerats framgångsrikt
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());  // Visa meddelandet "Denna hög är full"
                }
            }
        }

        // När spelet är över, visa slutpoäng
        showGameState();
        System.out.println("Game is over!");
        System.out.println("You got " + myGame.getPoints() + " points.");
    }

    // Visar spelets nuvarande status, dvs. korthögarna
    private void showGameState() {
        for (Pile pile : myGame.getPiles()) {
            System.out.println(pile);
        }
    }

    // Läser in användarens val av hög (0-4)
    private int readPileIndex() {
        while (true) {
            try {
                int pileIndex = Integer.parseInt(scanner.nextLine().trim());
                if (pileIndex >= 0 && pileIndex <= 4) {
                    return pileIndex;
                }
                System.out.print("Invalid index. Select a pile between [0..4]: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Select a pile between [0..4]: ");
            }
        }
    }

    // Huvudmetoden för att starta spelet
    public static void main(String[] args) {
        PsUserInterface ui = new PsUserInterface();
        ui.start();
    }
}
