import java.util.Collections;


/**
 * this method is for starting a game and add players to players list it shuffle
 * all cards and give each player 7 cards and check that the first draw pile
 * card dont be wild!
 */
public class GameStateStart implements GameState{

    @Override
    public void startGame(GameContext context, Game game) {
        context.addAllCards(game);
        Collections.shuffle(context.getCards());
        int numPlayers = context.numPlayers();
        for (int i = 0; i < numPlayers; i++) {
            context.getPlayers().add(new BasePlayer());//player is interface so use BasePlayer to start
        }

        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < 7; j++) {
                context.getPlayers().get(i).getCards().add(context.getCards().getFirst());
                context.getCards().removeFirst();
            }
        }
        while (context.getCardDirector().constructCard(context.getCards().getFirst().getDigital(), context.getCards().getFirst().getColor()).getColor().equals("black")) {
            context.getCards().addLast(context.getCards().getFirst());
            context.getCards().removeFirst();
        }

        // Move to CheckEndOfGameState to start checking the game status after starting
        context.setState(new GameStateEnd());
    }

    @Override
    public boolean checkEndOfGame(GameContext context, Game game) {
        throw new IllegalStateException("Cannot check end of game during start phase.");
    }
}
