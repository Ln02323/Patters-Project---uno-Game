import java.util.ArrayList;
import java.util.LinkedList;

public class PlaygroundFacade {
    private Playground playground;

    public PlaygroundFacade() {
        this.playground = new Playground();
    }

    public void printCard(Card card, int n, int numCard) {
        playground.printCard(card, n, numCard);
    }

    public void printPlayground(ArrayList<Player> players, LinkedList<Card> cards, int turn, int playerTurn, int choose) {
        playground.printPlayground(players, cards, turn, playerTurn, choose);
    }
}
