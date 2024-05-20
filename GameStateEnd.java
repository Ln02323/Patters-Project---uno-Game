

/**
 * this method check if the game ends or nor
 * @return {@code true} if the game ends otherwise {@code false}
 */
public class GameStateEnd implements GameState{

    @Override
    public void startGame(GameContext context, Game game) {
        throw new IllegalStateException("Game is already started.");
    }

    @Override
    public boolean checkEndOfGame(GameContext context, Game game) {
        int numPlayer = context.getPlayers().size();
        for (int i = 0; i < numPlayer; i++) {
            if (context.getPlayers().get(i).getCards().size() == 0)
                return true;
        }
        return false;
    }
}
