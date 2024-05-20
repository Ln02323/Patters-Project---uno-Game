import java.util.ArrayList;
import java.util.LinkedList;

public class GameContext {
    private GameState state = new GameStateStart();
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void startGame() {
        state.startGame(this, game);
    }

    public boolean checkEndOfGame() {
        return state.checkEndOfGame(this, game);
    }

    public void addAllCards(Game game) {
        this.game.addAllCards();
    }

    public int numPlayers() {
        return game.numPlayers();
    }

    public LinkedList<Card> getCards() {
        return game.getCards();
    }

    public ArrayList<Player> getPlayers() {
        return game.getPlayers();
    }

    public CardBuilderDirector getCardDirector() {
        return game.getCardDirector();
    }
}
