public interface GameState {
    void startGame(GameContext context, Game game);
    boolean checkEndOfGame(GameContext context, Game game);
}
