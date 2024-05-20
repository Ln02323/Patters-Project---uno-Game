import java.util.ArrayList;

public class ScoreCalculator {
    private static ScoreCalculator instance = null;
    private CardBuilderDirector cardDirector;

    // Private constructor to prevent instantiation from outside
    private ScoreCalculator() {
        cardDirector = new CardBuilderDirector(new CardBuilder());
    }

    // Method to get the instance of ScoreCalculator
    public static ScoreCalculator getInstance() {
        if (instance == null) {
            instance = new ScoreCalculator();
        }
        return instance;
    }

    /**
     * This method calculates the score for a given card.
     * @param card The card for which the score is calculated.
     * @return The score of the card.
     */
    public int calculateScore(Card card) {
        int score = 0;
        if (cardDirector.constructCard(card.getDigital(), card.getColor()).getDigital() >= 0)
            score = cardDirector.constructCard(card.getDigital(), card.getColor()).getDigital();
        else if (cardDirector.constructBlackCard(card.getBlackActive()).getBlackActive() == 1 ||
                cardDirector.constructBlackCard4(card.getBlackActive4()).getBlackActive4() == 1)
            score = 50;
        else
            score = 20;

        return score;
    }


    /**
     * This method prints scores of all players at the end of the game.
     * @param players The list of players.
     * @param scores The list of scores corresponding to each player.
     */
    public void printScores(ArrayList<Player> players, ArrayList<Integer> scores) {
        clearScreen();
        for (int i = 0; i < players.size(); i++) {
            System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t   " + ConsoleColors.CYAN_BOLD_BRIGHT + "Player" + (i + 1)
                    + " scores: " + scores.get(i) + ConsoleColors.RESET);
        }
    }

    /**
     * Clears the console screen.
     */
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
